package com.pj.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthMenu;
import com.pj.auth.service.AuthMenuService;
import com.pj.config.web.controller.SystemManageController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/post")
@Api(value="post", description="菜单", position=12)
public class AuthMenuController  extends SystemManageController{
	
	@Resource
	private AuthMenuService authMenuService;
	
	
	/**
	 * 	查询菜单信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询菜单信息", httpMethod = "GET", response=String.class, notes ="查询菜单信息")
	@RequestMapping(value="/list.do", method =RequestMethod.GET)
	public Map<String, Object> findAllPost(@ModelAttribute("AuthMenu")AuthMenu authmenu){
		Map<String, Object> map;
		try {
			Map<String, Object> hashMap = new HashMap<>();
			List<AuthMenu> authmenus = this.authMenuService.GetMenu(authmenu);
			hashMap.put("authmenus", authmenus);
			map = this.success(hashMap);
		} catch (Exception e) {
			logger.error("查询菜单信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
}
