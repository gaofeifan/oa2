package com.pj.flow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.constant.ApplyType;
import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowActionLog;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
import com.pj.flow.service.FlowActionLogService;
import com.pj.flow.service.FlowApproveService;
import com.pj.flow.service.FlowEntryService;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/entry")
@Api(value="entry", description="入职申请", position=1)
public class EntryController extends BaseController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(EntryController.class); 
	
	@Resource
	private FlowEntryService flowEntryService;
	
	@Resource
	private FlowApproveService flowApproveService;
	
	@Resource
	private FlowActionLogService flowActionLogService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private SessionProvider sessionProvider;
	
	@Resource
	private DempService dempService;
	
	@ApiOperation(value = "入职申请查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="入职申请查询")
	@RequestMapping(value = "/searchEntrys.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue searchEntrys(HttpServletResponse response, HttpServletRequest request){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			
			List<FlowEntry> list = flowEntryService.searchEntrys(null, null, user.getId());		
			for(FlowEntry flowEntry : list){
				Integer dempId = flowEntry.getDempId();
				//拼接上父部门的组合
				String dempName = dempService.selectDempParentNameById(dempId);
				flowEntry.setDempName(dempName);
			}
			
			map = this.successJsonp(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("入职申请查询");
		}
		return map;
	}
	
	/**
	 * 	提交申请
	 * [{"totalSalary(总工资)":111,"baseSalary(基本工资)":10,"postSalary(岗位工资)":1,"performanceSalary(绩效工资)":"200","reimbursement(报销金额)":200,"lunchAllowance(午餐补贴)":"200","communicationAllowance(通讯补贴)":"200","fullHours(全勤)":"200","salary_type":(1(实习))},
	    {"totalSalary(总工资)":111,"baseSalary(基本工资)":10,"postSalary(岗位工资)":1,"performanceSalary(绩效工资)":"200","reimbursement(报销金额)":200,"lunchAllowance(午餐补贴)":"200","communicationAllowance(通讯补贴)":"200","fullHours(全勤)":"200","salary_type":(2(试用))},
	    {"totalSalary(总工资)":111,"baseSalary(基本工资)":10,"postSalary(岗位工资)":1,"performanceSalary(绩效工资)":"200","reimbursement(报销金额)":200,"lunchAllowance(午餐补贴)":"200","communicationAllowance(通讯补贴)":"200","fullHours(全勤)":"200","salary_type":(3(转正))}
	   ]
	 */
	@ApiOperation(value = "提交入职申请", httpMethod = "GET", response=MappingJacksonValue.class, notes ="提交入职申请")
	@RequestMapping("/commitEntry.do")
	@ResponseBody
	public MappingJacksonValue commitEntry(HttpServletResponse response, HttpServletRequest request,
			@ModelAttribute(value = "flowEntry") FlowEntry flowEntry){
		MappingJacksonValue map;
		try {
			String salarys = flowEntry.getSalaryJson();
			
			flowEntryService.insertEntryAndSalary(flowEntry, salarys);
			map = this.successJsonp(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交入职申请"+e.getMessage());
		}
		return map;
	}
	
	@ApiOperation(value = "入职申请详情", httpMethod = "GET", response=MappingJacksonValue.class, notes ="入职申请详情")
	@RequestMapping("/showEntryApply.do")
	@ResponseBody
	public MappingJacksonValue showEntryApply(
			@ApiParam(value = "入职表id", required = true)@RequestParam(value = "entryId", required = true) Integer entryId){
		MappingJacksonValue map;
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			//申请详情
			FlowEntry flowEntry = flowEntryService.selectById(entryId);
			
			//审批列表
			List<FlowApprove> list = flowApproveService.selectByApplyIdAndType(flowEntry.getId(), ApplyType.ENTRY.getApplyType());
			
			result.put("entry", flowEntry);
			result.put("approves", list); 
			map = this.successJsonp(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("入职申请详情");
		}
		return map;
	}
	
	@ApiOperation(value = "入职待办状态详情", httpMethod = "GET", response=MappingJacksonValue.class, notes ="入职待办状态详情")
	@RequestMapping("/showApplyTodo.do")
	@ResponseBody
	public MappingJacksonValue showApplyTodo(
			@ApiParam(value = "入职表id", required = true)@RequestParam(value = "entryId", required = true) Integer entryId){
		MappingJacksonValue map;
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			//申请详情
			FlowEntry flowEntry = flowEntryService.selectById(entryId);
			//审批列表
			List<FlowApprove> list = flowApproveService.selectByApplyIdAndType(flowEntry.getId(), ApplyType.ENTRY.getApplyType());
			List<Boolean> collect = list.stream().map(approve -> approve.getIsApprove() == 1).collect(Collectors.toList());
			List<FlowActionLog> logList = null;
			if(!collect.contains(false)){
				//待办日志记录list
				logList = flowActionLogService.selectByEntryId(entryId);
			}
			result.put("entry", flowEntry);
			result.put("approves", list);
			result.put("logs", logList);
			map = this.successJsonp(result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("入职待办状态详情" + e.getMessage());
		}
		return map;
	}
	
	/**
	 * 	查询offer信息详情
	 *	@author 	GFF
	 *	@date		2017年6月26日下午6:49:59	
	 * 	@param applyId
	 * @return 
	 */
	@ApiOperation(value = "查询offer信息详情", httpMethod = "GET", response=MappingJacksonValue.class, notes ="查询offer信息详情")
	@RequestMapping("/selectOfferDetails.do")
	public @ResponseBody MappingJacksonValue selectOfferDetails(@ApiParam(value = "申请表单id", required = true)@RequestParam(value = "applyId", required = true)Integer applyId){
		MappingJacksonValue successJsonp = null;
		try {
			String email = getSession();
			FlowOffer flowOffer = this.flowEntryService.selectOfferDetailsByApplyIdAndEmail(applyId , email);
			successJsonp = this.successJsonp(flowOffer);
		} catch (Exception e) {
			logger.error("【EntryController.selectOfferDetails】:" + e.getMessage());
			successJsonp = this.errorToJsonp(e.getMessage());
		}
		return successJsonp;
	}
	
	
	/**
	 * 	发送offer
	 *	@author 	GFF
	 *	@date		2017年6月27日上午10:58:14	
	 * 	@param iEamil
	 * 	@param CC
	 * 	@param hour
	 * 	@return
	 */
	@ApiOperation(value = "发送offer", httpMethod = "GET", response=MappingJacksonValue.class, notes ="发送offer")
	@RequestMapping("/sendOffer.do")
	public @ResponseBody MappingJacksonValue sendOffer(@ApiParam(value = "个人邮箱", required = true)@RequestParam(value = "iEamil", required = true)String iEamil ,
			 							 @ApiParam(value = "抄送人", required = false)@RequestParam(value = "usernames", required = true)String usernames ,
			 							 @ApiParam(value = "时", required = true)@RequestParam(value = "hour", required = true)String  hour,
			 							 @ApiParam(value = "发送人邮箱密码", required = true)@RequestParam(value = "emailPassword", required = true)String  emailPassword,
			 							 @ApiParam(value = "申请表单id", required = true)@RequestParam(value = "applyId", required = true)Integer applyId){
			String email = getSession();
				try {
					this.flowEntryService.sendOffer(iEamil,usernames,hour,applyId,email,hour,emailPassword);
				} catch (Exception e) {
					return this.errorToJsonp(e.getMessage());
				}
			return this.successJsonp(null);
	}
	
	/**********************建档待办**********************/
	/**
	 * 	建档待办提示,得到待办个数
	 */
//	@ApiOperation(value = "建档待办提示,得到待办个数", httpMethod = "GET", response=MappingJacksonValue.class, notes ="建档待办提示,得到待办个数")
//	@RequestMapping(value = "/todoTips.do", method = RequestMethod.GET)
//	@ResponseBody
//	public MappingJacksonValue todoTips(
//			HttpServletResponse response, HttpServletRequest request){
//		MappingJacksonValue map;
//		try {
//			//得到当前登录用户
//			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
//			User user = this.userService.selectByEamil(email);
//			//根据当前用户id得到所负责的岗位的入职结果为已同意的个数
//			int number = flowEntryService.getNumByAuthResult(user.getId(), EntryApplyResult.ENTRY_AGREE.getState());
//			
//			map = this.successJsonp(number);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("异常" + e.getMessage());
//			throw new RuntimeException("建档待办提示");
//		}
//		return map;
//	}
	
	/**
	 * 	建档待办查询
	 */
	@ApiOperation(value = "建档待办查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘待办查询")
	@RequestMapping(value = "/listEntryTodo.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue listEntryTodo(
			HttpServletResponse response,
			HttpServletRequest request,
			@ApiParam(value = "入职公司id", required = false)@RequestParam(value = "companyId", required = false)Integer companyId,
			@ApiParam(value = "入职人姓名", required = false)@RequestParam(value = "name", required = false)String name){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			List<FlowEntry> entrys = flowEntryService.selectByTodo(user.getId(), companyId, name);
			map = this.successJsonp(entrys);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("建档待办查询");
		}
		return map;
	}
	

	/**
	 * 	发送offer
	 *	@author 	GFF
	 *	@date		2017年6月27日上午10:58:14	
	 * 	@param iEamil
	 * 	@param CC
	 * 	@param hour
	 * 	@return
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	@ApiOperation(value = "发送offer", httpMethod = "GET", response=MappingJacksonValue.class, notes ="发送offer")
	@RequestMapping("/testOffer.do")
	public @ResponseBody MappingJacksonValue testOffer() throws AddressException, MessagingException{
//		FlowOffer flowOffer = this.flowEntryService.selectOfferDetailsByApplyIdAndEmail(249, "zhangyiteng@pj-l.com");
//		String offerTemp = SendEmailUtils.getResourceTemp("/temp/offer2");
//		String string = OfferUtils.replaceOfferContent(offerTemp, flowOffer);
		try {
			flowEntryService.sendOffer("shy.gentleman@163.com", "gaofeifan@pj-l.com,zhengpengfei@pj-l.com","9", 557, "gaofeifan@pj-l.com", "9", "qwe.1234");
		} catch (Exception e) {
			return this.errorToJsonp(e.getMessage());
		}
//		SendEmailUtils.sendMessage("zhangyiteng@pj-l.com", "Zhang123456", "1315697146@qq.com", flowOffer.getCompany()+"offer", string, new String[]{"gaofeifan@pj-l.com","limengyun@pj-l.com"});
		return null;
	}
	
	/**
	 * 	查询字段详情
	 */
	@ApiOperation(value = "selectOfferDetail", httpMethod = "GET", response=MappingJacksonValue.class, notes ="发送offer")
	@RequestMapping("/selectOfferDetail.do")
	public @ResponseBody MappingJacksonValue selectOfferDetail(@ModelAttribute("flowOffer") FlowOffer flowOffer ){
		return null;
	}
	/**
	 * 	撤回
	 */
	@ApiOperation(value = "建档撤回", httpMethod = "GET", response=MappingJacksonValue.class, notes ="建档撤回")
	@RequestMapping(value = "/cancelEntry.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue cancelEntry(
			@ApiParam(value = "入职表id", required = true)@RequestParam(value = "entryId", required = true) Integer entryId){
		MappingJacksonValue map;
		try {
			flowEntryService.cancelEntry(entryId);
			map = this.successJsonp(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("建档撤回" + e.getMessage());
		}
		return map;
	}
}
