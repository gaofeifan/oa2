package com.pj.flow.controller;

import java.util.List;

import javax.annotation.Resource;
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

import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
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
			
			List<FlowEntry> list = flowEntryService.searchEntrys(user.getId());		
			for(FlowEntry flowEntry : list){
				Integer dempId = flowEntry.getDempId();
				//拼接上父部门的组合
				String dempName = dempService.selectDempParentNameById(dempId);
				flowEntry.setDempName(dempName);
			}
			
			map = this.successJsonp(list);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交招聘申请");
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
	public MappingJacksonValue commitEntry(@ModelAttribute("flowEntry") FlowEntry flowEntry,
						@ApiParam(value = "工资信息(json格式[{'totalSalary(总工资)':111,'baseSalary(基本工资)':10,'postSalary(岗位工资)':1,'performanceSalary(绩效工资)':'200','reimbursement(报销金额)':200,'lunchAllowance(午餐补贴)':'200','communicationAllowance(通讯补贴)':200,'fullHours(全勤)':200,'sal'ry_type':(1(实习))},{'totalSalary(总工资)':111,'baseSalary(基本工资)':10,'postSalary(岗位工资)':1,'performanceSalary(绩效工资)':200,'reimbursement(报销金额)':200,'lunchAllowance(午餐补贴)':200,'communicationAllowance(通讯补贴)':200,'fullHours(全勤)':200,'salary_type':(2(试用))},{'totalSalary(总工资)':111,'baseSalary(基本工资)':10,'postSalary(岗位工资)':1,'performanceSalary(绩效工资)':200,'reimbursement(报销金额)':200,'lunchAllowance(午餐补贴)':200,'communicationAllowance(通讯补贴)':200,'fullHours(全勤)':200,'salary_type':(3(转正))}])", required = false)@RequestParam(value = "salarys", required = false) String salarys){
		MappingJacksonValue map;
		try {
			flowEntryService.insertEntryAndSalary(flowEntry, salarys);
			map = this.successJsonp(null);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交入职申请");
		}
		return map;
	}
	@ApiOperation(value = "入职申请详情", httpMethod = "GET", response=MappingJacksonValue.class, notes ="入职申请详情")
	@RequestMapping("/showEntryApply.do")
	@ResponseBody
	public MappingJacksonValue showEntryApply(
			@ApiParam(value = "入职表id", required = true)@RequestParam(value = "entryId", required = false) Integer entryId){
		MappingJacksonValue map;
		try {
			FlowEntry flowEntry = flowEntryService.selectById(entryId);
			map = this.successJsonp(flowEntry);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("入职申请详情");
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
			 							 @ApiParam(value = "申请表单id", required = true)@RequestParam(value = "applyId", required = true)Integer applyId){
		MappingJacksonValue success = null;
		try {
			this.flowEntryService.sendOffer(iEamil,usernames,hour,applyId,getSession(),9);
			success = this.successJsonp(null);
		} catch (Exception e) {
			success = this.errorToJsonp(e.getMessage());
		}
		return success;
	}
	
}
