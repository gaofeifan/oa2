package com.pj.auth.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthMenu;
import com.pj.auth.service.AuthMenuService;
import com.pj.config.web.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/auth/Menu")
@Api(value="authMenu", description="菜单")
public class AuthMenuController  extends BaseController{
	
	@Resource
	private AuthMenuService authMenuService;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthAgencyController.class);
	
	/**
	 * 	查询菜单信息
	 */
	@RequestMapping(value="/list.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询菜单信息", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue GetMenu(@ModelAttribute("authMenu")AuthMenu authmenu){
		try {
			List<AuthMenu> authmenus = this.authMenuService.GetMenu(authmenu);
			return this.successJsonp(authmenus);
		} catch (Exception e) {
			logger.error("【AuthMenuController.GetMenu】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询菜单信息失败"));
	}
}
