package com.pj.flow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.service.FlowApproveService;
import com.pj.flow.service.FlowRecruitService;
import com.pj.flow.service.FlowRecruitTodoService;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 项目名称：oa   
 * 类名称：RecruitController   
 * 类描述：招聘申请   
 * 创建人：limr   
 * 创建时间：2017年6月21日 下午5:13:39   
 * 修改人：limr   
 * 修改时间：2017年6月21日 下午5:13:39   
 * 修改备注：   
 * @version    
 *
 */
@Controller
@RequestMapping("/recruit")
@Api(value="recruit", description="招聘申请", position=1)
public class RecruitController extends BaseController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(RecruitController.class); 
	@Resource
	private FlowRecruitService flowRecruitService;
	
	@Resource
	private FlowRecruitTodoService flowRecruitTodoService;
	
	@Resource
	private FlowApproveService flowApproveService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private SessionProvider sessionProvider;
	
	@Resource
	private DempService dempService;
	
	
	@ApiOperation(value = "招聘申请查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘申请查询")
	@RequestMapping(value = "/searchRecruits.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue searchRecruits(HttpServletResponse response, HttpServletRequest request){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			
			List<FlowRecruit> list = flowRecruitService.searchRecruits(null, null, user.getId());		
			for(FlowRecruit flowRecruit : list){
				Integer dempId = flowRecruit.getApplyDempId();
				//拼接上父部门的组合
				String dempName = dempService.selectDempParentNameById(dempId);
				flowRecruit.setDempName(dempName);
			}
			
			map = this.successJsonp(list);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交招聘申请" + e.getMessage());
		}
		return map;
	}
	/**
	 * 	提交申请
	 */
	@ApiOperation(value = "提交招聘申请", httpMethod = "GET", response=MappingJacksonValue.class, notes ="提交招聘申请")
	@RequestMapping(value = "/insertRecruit.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue insertRecruit(
			@ModelAttribute("flowRecruit")FlowRecruit flowRecruit){
		MappingJacksonValue map;
		try {
			flowRecruit.setStatus(0);
			flowRecruitService.insertSelective(flowRecruit);
			
			map = this.successJsonp("提交成功");
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交招聘申请" + e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 	得到直属领导
	 */
	@ApiOperation(value = "得到直属领导", httpMethod = "GET", response=MappingJacksonValue.class, notes ="得到直属领导")
	@RequestMapping(value = "/getLeader.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue getLeader(
			@ApiParam(value = "公司id", required = true)@RequestParam(value = "companyId", required = true)Integer companyId, 
			@ApiParam(value = "部门id")@RequestParam(value = "dempId")Integer dempId, 
			@ApiParam(value = "是否是公司领导(0:否，1:是)", defaultValue = "0")@RequestParam(value = "isCompanyLeader", defaultValue = "0")Integer isCompanyLeader, 
			@ApiParam(value = "是否是部门领导(0:否，1:是)", defaultValue = "0")@RequestParam(value = "isDempLeader", defaultValue = "0")Integer isDempLeader){
		MappingJacksonValue map;
		try {
			User user = flowRecruitService.getLeader(companyId, dempId, isCompanyLeader, isDempLeader);
			map = this.successJsonp(user);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("得到直属领导" + e.getMessage());
		}
		return map;
	}
	/**
	 * 	根据替代人员姓名查询用户
	 */
	@ApiOperation(value = "根据替代人员姓名查询用户", httpMethod = "GET", response=MappingJacksonValue.class, notes ="根据替代人员姓名查询用户")
	@RequestMapping(value = "/getReplaceUser.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue getReplaceUser(
			@ApiParam(value = "公司id", required = true)@RequestParam(value = "companyId", required = true)Integer companyId, 
			@ApiParam(value = "部门id", required = false)@RequestParam(value = "dempId", required = false)Integer dempId, 
			@ApiParam(value = "姓名", required = true)@RequestParam(value = "replaceName", required = true)String replaceName){
		MappingJacksonValue map;
		try {
			User user = userService.getReplaceUser(companyId, dempId, replaceName);
			map = this.successJsonp(user);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("替代用户" + e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 跳转申请表页面
	 */
	@ApiIgnore
	@RequestMapping(value = "/toRecruit.do", method = RequestMethod.GET)
	@ApiOperation(value = "跳转申请表页面", httpMethod = "GET", response=ModelAndView.class, notes ="跳转申请表页面")
	public ModelAndView toRecruit(HttpServletResponse response, HttpServletRequest request, Model model){
		//得到当前登录用户
		String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
		User user = this.userService.selectByEamil(email);
		model.addAttribute(user);
		return new ModelAndView("recruit/add");
	}
	
	
	/**
	 * 	申请单详情
	 */
	@ApiOperation(value = "申请单详情", httpMethod = "GET", response=Map.class, notes ="申请单详情")
	@RequestMapping(value = "/showApply.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue showApply(
			@ApiParam(value = "招聘申请单id", required = true)@RequestParam(value = "recruitId", required = true)Integer recruitId){
		MappingJacksonValue map;
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			//申请详情
			FlowRecruit recruit = flowRecruitService.selectById(recruitId);
			//审批详情
			List<FlowApprove> list = flowApproveService.selectByApplyIdAndType(recruit.getId(), ApplyType.RECRUIT.getApplyType());
			result.put("recruit", recruit);
			result.put("approves", list);
			map = this.successJsonp(result);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("申请单详情" + e.getMessage());
		}
		return map;
	}
	
	
	/**********************招聘待办**********************/
	
	/**
	 * 	招聘待办提示,得到待办个数
	 */
	@ApiOperation(value = "招聘待办提示,得到待办个数", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘待办提示,得到待办个数")
	@RequestMapping(value = "/todoTips.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue todoTips(
			HttpServletResponse response, HttpServletRequest request){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			
			//根据当前用户id得到所负责的岗位的招聘状态为招聘中的个数
			int number = flowRecruitTodoService.getNumByState(user.getId(), RecruitTodoState.IN_RECRUIT.getState());
			
			map = this.successJsonp(number);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("招聘待办提示" + e.getMessage());
		}
		return map;
	}
	/**
	 * 	招聘待办查询
	 */
	@ApiOperation(value = "招聘待办查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘待办查询")
	@RequestMapping(value = "/listRecruitTodo.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue listRecruitTodo(
			HttpServletResponse response,
			HttpServletRequest request,
			@ApiParam(value = "招聘待办状态（1:招聘中,2:已提交,3:已暂停,4:已审批）", required = true)@RequestParam(value = "state", required = true)Integer state,
			@ApiParam(value = "公司id", required = false)@RequestParam(value = "companyId", required = false)Integer companyId,
			@ApiParam(value = "申请人姓名", required = false)@RequestParam(value = "username", required = false)String username){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);

			List<FlowRecruit> recruits = flowRecruitService.selectByQuery(user.getId(), companyId, username, state);
			
			for(FlowRecruit flowRecruit : recruits){
				Integer dempId = flowRecruit.getDempId();
				//拼接上父部门的组合
				String dempName = dempService.selectDempParentNameById(dempId);
				flowRecruit.setDempName(dempName);
				
			}
			map = this.successJsonp(recruits);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("招聘待办查询" + e.getMessage());
		}
		return map;
	}
	
	@ApiOperation(value = "待办提交回显数据", httpMethod = "GET", response=MappingJacksonValue.class, notes ="待办提交回显数据")
	@RequestMapping(value = "/getUserInfo.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue getUserInfo(
			@ApiParam(value = "招聘表id", required = true)@RequestParam(value = "recruitId", required = true)Integer recruitId){
		MappingJacksonValue map;
		try {
			FlowRecruit flowRecruit = flowRecruitService.getUserInfo(recruitId);
			
			map = this.successJsonp(flowRecruit);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("待办提交回显数据" + e.getMessage());
		}
		return map;
	}
	/**
	 * 	招聘待办状态改变
	 */
	@ApiOperation(value = "招聘待办状态改变", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘待办状态改变")
	@RequestMapping(value = "/changeState.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue changeState(
			HttpServletResponse response,
			HttpServletRequest request,
			@ApiParam(value = "招聘待办状态（0:终止,1:开始,2:提交,3:暂停）", required = true)@RequestParam(value = "state", required = true)Integer state,
			@ApiParam(value = "理由", required = false)@RequestParam(value = "reason", required = false)String reason,
			@ApiParam(value = "招聘表id", required = true)@RequestParam(value = "recruitId", required = true)Integer recruitId){
		MappingJacksonValue map;
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			
			flowRecruitService.updateState(user, recruitId, reason, state);
			map = this.successJsonp(null);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("招聘待办状态改变" + e.getMessage());
		}
		return map;
	}
	
	
}
