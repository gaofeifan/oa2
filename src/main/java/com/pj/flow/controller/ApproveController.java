package com.pj.flow.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowApproveService;
import com.pj.flow.service.FlowEntryService;
import com.pj.flow.service.FlowRecruitService;
import com.pj.flow.service.FlowUserApplicationService;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 项目名称：oa   
 * 类名称：RecruitController   
 * 类描述：我的审批查询   
 * 创建人：limr   
 * 创建时间：2017年6月21日 下午5:13:39   
 * 修改人：limr   
 * 修改时间：2017年6月21日 下午5:13:39   
 * 修改备注：   
 * @version    
 *
 */
@Controller
@RequestMapping("/approve")
@Api(value="approve", description="我的审批", position=1)
public class ApproveController extends BaseController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(ApproveController.class); 

	@Autowired
	private UserService userService;
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private FlowApproveService flowApproveService;
	
	@Autowired
	private FlowRecruitService flowRecruitService;
	
	@Autowired
	private FlowEntryService flowEntryService;
	
	@Autowired
	private DempService dempService;
	
	@Autowired
	private FlowUserApplicationService flowUserApplicationService;
	
	
	@ApiOperation(value = "审批查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="审批查询")
	@RequestMapping(value = "/searchAllApproves.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue searchAllApproves(HttpServletResponse response, HttpServletRequest request,
			@ApiParam(value = "页码", required = false, defaultValue = "1") @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@ApiParam(value = "每页的个数", required = false, defaultValue = "10") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(value = "申请类型（招聘:recruit,入职:entry）", required = true)@RequestParam(value = "applyType", required = true)String applyType,
			@ApiParam(value = "公司id", required = false)@RequestParam(value = "companyId", required = false)Integer companyId,
			@ApiParam(value = "申请人姓名", required = false)@RequestParam(value = "username", required = false)String username
			){
		MappingJacksonValue map;
		try {
			
			//根据applyType判断是招聘还是入职,
			if (applyType.equals(ApplyType.RECRUIT.getApplyType())) {
				//招聘
				Page<FlowRecruit> page = PageHelper.startPage(Pagination.cpn(pageNo), pageSize, true);
				List<FlowRecruit> recruits = flowRecruitService.searchRecruits(companyId, username, null);
				for(FlowRecruit recruit : recruits){
					//申请人部门
					Integer dempId = recruit.getApplyDempId();
					//拼接上父部门的组合
					String dempName = dempService.selectDempParentNameById(dempId);
					recruit.setDempName(dempName);
				}
				Pagination pagination = new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), recruits);
				map = this.successJsonp(pagination);
			}else if(applyType.equals(ApplyType.ENTRY.getApplyType())){
				//入职
				Page<FlowEntry> page = PageHelper.startPage(Pagination.cpn(pageNo), pageSize, true);
				List<FlowEntry> entrys = flowEntryService.searchEntrys(companyId, username, null);
				for(FlowEntry entry : entrys){
					//申请人部门
					Integer dempId = entry.getDempId();
					//拼接上父部门的组合
					String dempName = dempService.selectDempParentNameById(dempId);
					entry.setDempName(dempName);
				}
				Pagination pagination = new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), entrys);
				map = this.successJsonp(pagination);
			}else {
				map = this.successJsonp(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("审批查询" + e.getMessage());
		}
		return map;
	}
	@ApiOperation(value = "我的审批查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="我的审批查询")
	@RequestMapping(value = "/searchMyApproves.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue searchMyApproves(HttpServletResponse response, HttpServletRequest request,
			@ApiParam(value = "页码", required = false, defaultValue = "1") @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@ApiParam(value = "每页的个数", required = false, defaultValue = "10") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@ApiParam(value = "审批状态(0:未审批,1:已审批)", required = true) @RequestParam(value = "checkstatus", required = true) Integer checkstatus
			){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			//0、审批中 1、不同意 2、同意
			//如果是0，查询未处理的且 是否可审批(0 可审批  1 不可审批)为0的数据列表
			Page<FlowRecruit> page = PageHelper.startPage(Pagination.cpn(pageNo), pageSize, true);
			List<FlowUserApplication> list = flowApproveService.searchMyApproves(user.getId(), checkstatus);		
			Pagination pagination = new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), list);
			map = this.successJsonp(pagination);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("我的审批查询" + e.getMessage());
		}
		return map;
	}
	@ApiOperation(value = "选择姓名跳转对应的申请详情页面", httpMethod = "GET", response=MappingJacksonValue.class, notes ="选择姓名跳转对应的申请详情页面")
	@RequestMapping(value = "/toApplyInfo.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue toApplyInfo(
			@ApiParam(value = "申请表id", required = true) @RequestParam(value = "formId", required = true) Integer formId,
			@ApiParam(value = "申请类型(招聘:recruit 入职:entry，转正:regular ，异动:change，离职:dimission，请假:leave，其他:other)", required = true) @RequestParam(value = "applyType", required = true) String applyType
			){
		MappingJacksonValue map;
		try {
			//判断申请类型
			if (applyType.equals(ApplyType.RECRUIT.getApplyType())) {
				//招聘
				FlowRecruit flowRecruit = flowRecruitService.selectById(formId);
				map = this.successJsonp(flowRecruit);
			}else if(applyType.equals(ApplyType.ENTRY.getApplyType())){
				//入职
				FlowEntry flowEntry = flowEntryService.selectById(formId);
				map = this.successJsonp(flowEntry);
			}else{
				map = this.successJsonp(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("选择姓名跳转对应的申请详情页面" + e.getMessage());
		}
		return map;
	}
	
	@ApiOperation(value = "提交审批", httpMethod = "GET", response=MappingJacksonValue.class, notes ="提交审批")
	@RequestMapping(value = "/commitApprove.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue commitApprove(
			@ApiParam(value = "审批人id", required = true) @RequestParam(value = "userid", required = true) Integer userid,
			@ApiParam(value = "审批状态(0、审批中 1、不同意 2、同意)", required = true) @RequestParam(value = "checkstatus", required = true) Integer checkstatus,
			@ApiParam(value = "审批意见", required = false) @RequestParam(value = "handleidea", required = false) String handleidea,
			@ApiParam(value = "申请表id", required = true) @RequestParam(value = "formId", required = true) Integer formId,
			@ApiParam(value = "申请类型(招聘:recruit 入职:entry，转正:regular ，异动:change，离职:dimission，请假:leave，其他:other)", required = true) @RequestParam(value = "applyType", required = true) String applyType
			){
		MappingJacksonValue map;
		try {
			/**
			 * 先查询中间表
			 * 	根据申请表id和申请类型查询是否存在，如存在不保存不存在则保存，
			 * 再保存审批表
			 */
			//根据申请表id和申请类型得到中间表
			FlowUserApplication flowUserApplication = flowUserApplicationService.selectByApplyIdAndType(formId,applyType);
			if(flowUserApplication != null){
				flowApproveService.commitApprove(flowUserApplication,userid, checkstatus, handleidea, formId, applyType);
				map = this.successJsonp("保存成功");
			}else{
				map = this.successJsonp("未找到相关数据，flowUserApplication is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("选择姓名跳转对应的申请详情页面" + e.getMessage());
		}
		return map;
	}
	
	/**
	 * 	查询我的申请
	 *	@author 	GFF
	 *	@date		2017年7月8日下午5:40:22	
	 * 	@return
	 */
	@ApiOperation(value = "查询我的申请", httpMethod = "GET", response=MappingJacksonValue.class, notes ="查询我的申请")
	@RequestMapping(value = "/selectMyApply.do", method = RequestMethod.GET)
	public @ResponseBody Object selectMyApply(){
		return flowApproveService;
	}
	
}
