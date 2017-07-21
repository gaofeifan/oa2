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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthMenu;
import com.pj.auth.service.AuthMenuService;
import com.pj.config.web.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	
	@RequestMapping(value="/Authlist.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询菜单信息", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue Authlist(
			@ApiParam("菜单等级") @RequestParam(value = "grade", required = true) Integer grade,
			@ApiParam("是否设置权限") @RequestParam(value = "auth", required = true) Integer auth,
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			List<AuthMenu> authmenus = this.authMenuService.GetMenubyUserid(grade, auth, userid);
			return this.successJsonp(authmenus);
		} catch (Exception e) {
			logger.error("【AuthMenuController.Authlist】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询菜单信息失败"));
	}
	
	@RequestMapping(value="/OneAuthlist.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询一级菜单信息", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue OneAuthlist(
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			List<AuthMenu> authmenus = this.authMenuService.GetOneMenubyUserid(userid);
			return this.successJsonp(authmenus);
		} catch (Exception e) {
			logger.error("【AuthMenuController.OneAuthlist】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询菜单信息失败"));
	}
	
	@RequestMapping(value="/TwoAuthlist.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询二级菜单信息", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue TwoAuthlist(
			@ApiParam("一级菜单id") @RequestParam(value = "fid", required = true) Integer fid,
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			List<AuthMenu> authmenus = this.authMenuService.GetTwoMenubyUserid(userid, fid);
			return this.successJsonp(authmenus);
		} catch (Exception e) {
			logger.error("【AuthMenuController.TwoAuthlist】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询二级菜单信息失败"));
	}
	@RequestMapping(value="/ThreeAuthlist.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询三级菜单信息", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue ThreeAuthlist(
			@ApiParam("二级菜单id") @RequestParam(value = "fid", required = true) Integer fid,
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			List<AuthMenu> authmenus = this.authMenuService.GetThreeMenubyUserid(userid, fid);
			return this.successJsonp(authmenus);
		} catch (Exception e) {
			logger.error("【AuthMenuController.ThreeAuthlist】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询三级菜单信息失败"));
	}
	
	@RequestMapping(value="/AuthUser.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询用户权限", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue GetAuthMenubyUserid(
			@ApiParam("菜单名称") @RequestParam(value = "name", required = true) String name,
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			int num = this.authMenuService.GetAuthMenubyUserid( name, userid);
			return this.successJsonp(num);
		} catch (Exception e) {
			logger.error("【AuthMenuController.GetAuthMenubyUserid】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询用户权限失败"));
	}
}
