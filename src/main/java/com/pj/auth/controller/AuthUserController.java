package com.pj.auth.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.service.AuthUserService;
import com.pj.config.web.controller.SystemManageController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/auth/user")
@Api(value="authuser", description="权限")
public class AuthUserController extends SystemManageController{
	@Resource
	private AuthUserService authuserService;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthAgencyController.class);
	
	/**
	 * 添加权限
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	@RequestMapping(value="/saveauth.do" , method=RequestMethod.GET)
	@ApiOperation(value = "添加权限", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue saveauth(
			@ApiParam("点击菜单类型") @RequestParam(value = "type", required = true) String type,
			@ApiParam("复选框value") @RequestParam(value = "id", required = true) Integer id,
			@ApiParam("父级菜单id") @RequestParam(value = "fid", required = true) Integer fid,
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid,
			@ApiParam("选中状态0取消勾选，1为勾选") @RequestParam(value = "current", required = true) Integer current){

		try {
			this.authuserService.insertAuthUser(type,id,fid,userid,current);
			return this.successJsonp(this.success());
		} catch (Exception e) {
			logger.error("【AuthUserController.saveauth】"+e.getMessage());
			return this.successJsonp(this.error("保存失败"+e.getMessage()));
		}

	}
	
	/**
	 * 删除权限
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	@RequestMapping(value="/DeleteAuth.do" , method=RequestMethod.GET)
	@ApiOperation(value = "删除权限", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue DeleteAuth(@ApiParam("用户id") @RequestParam(value = "userid", required = true) Integer userid) {
		try {
			this.authuserService.deleteByUserid(userid);
			return this.successJsonp(this.success());
		} catch (Exception e) {
			logger.error("【AuthUserController.saveauth】"+e.getMessage());
			return this.successJsonp(this.error("删除失败"+e.getMessage()));
		}

	}
	
	@RequestMapping(value="/getSelectedMenuIds.do" , method=RequestMethod.GET)
	@ApiOperation(value = "得到选中状态的菜单id集合", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue getSelectedMenuIds(
			@ApiParam(value = "菜单等级（1,2,3）", required = true, defaultValue = "1") @RequestParam(value = "grade", required = true, defaultValue = "1") Integer grade,
			@ApiParam(value = "菜单ID", required = false) @RequestParam(value = "menuid", required = false) Integer menuid,
			@ApiParam(value = "用户ID", required = true) @RequestParam(value = "userid", required = true) Integer userid){
		try {
			List<Integer> menuIds = authuserService.getSelectedMenuIds(grade, menuid, userid);
			return this.successJsonp(menuIds);
		} catch (Exception e) {
			logger.error("【AuthUserController.getSelectedMenuIds】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("得到选中状态的菜单id集合失败"));
	}
	
}
