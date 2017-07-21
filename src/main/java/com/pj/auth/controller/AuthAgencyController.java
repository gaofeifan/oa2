package com.pj.auth.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthAgency;
import com.pj.auth.service.AuthAgencyService;
import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.service.FlowApproveService;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *	@author		GFF
 *	@date		2017年6月26日上午9:24:45
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Controller
@RequestMapping("/auth/agency")
@Api(value = "authAgency", description = "机构权限")
public class AuthAgencyController extends BaseController{

	@Autowired
	private AuthAgencyService authAgencyService;
	@Resource
	private UserService userService;
	@Resource
	private FlowApproveService flowApproveService;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthAgencyController.class);
	
	/**
	 * 	添加机构权限
	 *	@author 	GFF
	 *	@date		2017年6月26日上午10:29:23	
	 * 	@param authAgency
	 * 	@return
	 */
	@RequestMapping(value="/saveAuthAgency.do" , method=RequestMethod.GET)
	@ApiOperation(value = "添加机构权限", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue saveAuthAgency(@ModelAttribute("authAgency")AuthAgency authAgency ){
		try {
			this.authAgencyService.insertSelective(authAgency);
			return this.successJsonp("添加成功");
		} catch (Exception e) {
			logger.error("【AuthAgencyController.saveAuthAgency】"+e.getMessage());
			return this.errorToJsonp("保存失败"+e.getMessage());
		}
	}
	
	
	/**
	 * 	根据id更新机构权限
	 *	@author 	GFF
	 *	@date		2017年6月26日上午10:29:06	
	 * 	@param authAgency
	 * 	@return
	 */
	@RequestMapping(value="/updateAuthAgencyById.do" , method=RequestMethod.GET)
	@ApiOperation(value = "根据id更新机构权限", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue updateAuthAgencyById(@ModelAttribute("authAgency")AuthAgency authAgency ){
		try {
			authAgency.setIsdelete(0);
			this.authAgencyService.updateByPrimaryKey(authAgency);
			return this.successJsonp(this.success());
		} catch (Exception e) {
			logger.error("【AuthAgencyController.updateAuthAgencyById】"+e.getMessage());
			e.printStackTrace();
			return this.errorToJsonp("更新失败"+e.getMessage());
		}
	}
	
	
	/**
	 * 	根据id删除权限机构
	 *	@author 	GFF
	 *	@date		2017年6月26日上午10:28:57	
	 * 	@param id
	 * 	@return
	 */
	@RequestMapping(value="/deleteAuthAgencyById.do" , method=RequestMethod.GET)
	@ApiOperation(value = "根据id删除权限机构", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue deleteAuthAgencyById(@ApiParam("权限id") @RequestParam(value = "id", required = true) Integer id){
		try {
			AuthAgency authAgency = this.authAgencyService.selectByPrimaryKey(id);
			List<AuthAgency> list2 = this.authAgencyService.selectAuthAgencysByCompanyIdOrDempId(authAgency.getCompanyId(), authAgency.getDempId());
			if(list2.size() > 1){
				this.authAgencyService.deleteByPrimaryKeyToLogic(id);
				return this.successJsonp("成功删除");
			}
			// 获取所有审批未通过的流程
			List<FlowApprove> approves = this.flowApproveService.selectNoApprovalAll();
			User record = new User();
			record.setCompanyid(authAgency.getCompanyId());
			record.setDempid(authAgency.getDempId());
			record.setIsdelete(0);
			List<User> list = this.userService.select(record );
			List<Integer> collect = list.stream().map(u -> u.getId()).collect(Collectors.toList());
			for (FlowApprove approve : approves) {
				FlowApprove flowApprove = new FlowApprove();
				flowApprove.setApplyId(approve.getApplyId());
				List<FlowApprove> select = this.flowApproveService.select(flowApprove);
				for (FlowApprove flowapp : select) {
					if(collect.contains(flowapp.getUserid())){
						return this.errorToJsonp("该机构存在未处理的任务无法删除");
					}
				}
			}
			this.authAgencyService.deleteByPrimaryKeyToLogic(id);
			return this.successJsonp("成功删除");
		} catch (Exception e) {
			logger.error("【AuthAgencyController.deleteAuthAgencyById】"+e.getMessage());
			e.printStackTrace();
		}
		return this.errorToJsonp("该机构存在未处理的任务无法删除");
	}

	
	/**
	 * 	查询所有机构权限(未删除)
	 *	@author 	GFF
	 *	@date		2017年6月26日上午10:28:16	
	 * 	@param id
	 * 	@return
	 */
	@RequestMapping(value="/findAuthAgencyAll.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询所有机构权限(未删除)", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue findAuthAgencyAll(){
		try {
			List<Object> list = this.authAgencyService.selectAuthAgencyALL();
			return this.successJsonp(list);
		} catch (Exception e) {
			logger.error("【AuthAgencyController.findAuthAgencyAll】"+e.getMessage());
			e.printStackTrace();
		}
		return this.errorToJsonp("查询机构异常");
	}
	
	@RequestMapping(value="/selectInstitutionalLevel.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询机构级别", httpMethod = "GET", response = Object.class)
	public @ResponseBody Object selectInstitutionalLevel(){
		try {
			AuthAgency authAgency = this.authAgencyService.selectInstitutionalLevel();
			return this.successJsonp(authAgency);
		} catch (Exception e) {
			logger.error("【AuthAgencyController.selectInstitutionalLevel】 查询异常 ： "+e.getMessage());
			return this.errorToJsonp("查询异常 ："+e.getMessage());
		}
	}
}
