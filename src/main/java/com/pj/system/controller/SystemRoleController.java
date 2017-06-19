package com.pj.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.system.pojo.SystemRole;
import com.pj.system.service.SystemRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *	@author		GFF
 *	@date		2016年12月21日下午4:01:55
 *	@version	1.0.0
 *  @since		1.8
 *	@parameter	系统角色表
 */
@Api(value="SystemRole",description="系统角色")
@Controller
@RequestMapping("/SystemRole")
public class SystemRoleController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SystemRoleController.class); 
	
	@Resource
	private SystemRoleService systemRoleService;
	
	@ApiOperation(value="添加数据" ,httpMethod="GET")
	@RequestMapping(value = "/saveSystemRole.do",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public void saveSystemRole(@ApiParam("systemRole") @ModelAttribute("systemRole")SystemRole systemRole ){
		systemRoleService.saveSystemRole(systemRole);
	}
	
	@ApiOperation(value="更新数据" ,httpMethod="GET")
	@RequestMapping(value = "/updateSystemRole.do",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public void updateSystemRole(@ApiParam("systemRole") @ModelAttribute("systemRole")SystemRole systemRole){
		this.systemRoleService.updateSystemRole(systemRole);
	}
	
	@ApiOperation(value="根据条件查询" ,httpMethod="GET")
	@RequestMapping(value = "/findSystemRoleByCondition.do",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> findSystemRoleByCondition(@ApiParam("systemRole") @ModelAttribute("systemRole")SystemRole systemRole){
		Map<String,Object> map;
		try {
			List<SystemRole> systemRoles = this.systemRoleService.findSystemRoleByCondition(systemRole);
			map = this.success(systemRoles);
		} catch (Exception e) {
			logger.error("根据条件查询异常"+e.getMessage());
			map = this.error("根据条件查询异常");
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="删除数据" ,httpMethod="GET")
	@RequestMapping(value = "/deleteSystemRoleById.do",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public void deleteSystemRoleById(@ApiParam("主键") @RequestParam("id") Integer id){
		this.systemRoleService.deleteSystemRoleById(id);
	}
}
