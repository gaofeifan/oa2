package com.pj.flow.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.service.FlowRecruitService;
import com.pj.system.pojo.User;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
@Api(value="recruit", description="入职申请", position=1)
public class RecruitController extends BaseController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(RecruitController.class); 
	@Resource
	private FlowRecruitService flowRecruitService;
	@Resource
	private UserService userService;
	@Resource
	private SessionProvider sessionProvider;
	
	/**
	 * 	提交申请
	 */
	@ApiOperation(value = "提交招聘申请", httpMethod = "POST", response=Map.class, notes ="提交招聘申请")
	@RequestMapping(value = "/insertRecruit.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> insertRecruit(@ModelAttribute("flowRecruit")FlowRecruit flowRecruit){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			flowRecruitService.insertSelective(flowRecruit);
			
			map = this.success("提交成功");
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交招聘申请");
		}
		return map;
	}
	/**
	 * 	得到直属领导
	 */
	@ApiOperation(value = "得到直属领导", httpMethod = "GET", response=Map.class, notes ="得到直属领导")
	@RequestMapping(value = "/commitEntry.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String , Object> getLeader(
			@ApiParam(value = "公司id", required = true)@RequestParam(value = "companyId", required = true)Integer companyId, 
			@ApiParam(value = "部门id")@RequestParam(value = "dempId")Integer dempId, 
			@ApiParam(value = "是否是公司领导", defaultValue = "0")@RequestParam(value = "isCompanyLeader", defaultValue = "0")Integer isCompanyLeader, 
			@ApiParam(value = "是否是部门领导", defaultValue = "0")@RequestParam(value = "isDempLeader", defaultValue = "0")Integer isDempLeader){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = flowRecruitService.getLeader(companyId, dempId, isCompanyLeader, isDempLeader);
			map = this.success(user);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("得到直属领导");
		}
		return map;
	}
	/**
	 * 	根据替代人员姓名查询用户
	 */
	@ApiOperation(value = "根据替代人员姓名查询用户", httpMethod = "GET", response=Map.class, notes ="根据替代人员姓名查询用户")
	@RequestMapping(value = "/getReplaceUser.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String , Object> getReplaceUser(
			@ApiParam(value = "公司id", required = true)@RequestParam(value = "companyId", required = true)Integer companyId, 
			@ApiParam(value = "部门id")@RequestParam(value = "dempId")Integer dempId, 
			@ApiParam(value = "姓名", required = true)@RequestParam(value = "username", required = true)String username){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userService.getReplaceUser(companyId, dempId, username);
			map = this.success(user);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("替代用户");
		}
		return map;
	}
	
	/**
	 * 跳转申请表页面
	 */
	@RequestMapping(value = "/toRecruit.do", method = RequestMethod.GET)
	@ApiOperation(value = "跳转申请表页面", httpMethod = "GET", response=ModelAndView.class, notes ="跳转申请表页面")
	public ModelAndView toRecruit(HttpServletResponse response, HttpServletRequest request, Model model){
		//得到当前登录用户
		String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
		User user = this.userService.selectByEamil(email);
		model.addAttribute(user);
		return new ModelAndView("recruit/add");
	}
}
