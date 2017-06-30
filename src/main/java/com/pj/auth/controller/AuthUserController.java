package com.pj.auth.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthUser;
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
	public @ResponseBody MappingJacksonValue saveauth(@ModelAttribute("authuser") AuthUser authuser){

		try {
			this.authuserService.insert(authuser);
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
}