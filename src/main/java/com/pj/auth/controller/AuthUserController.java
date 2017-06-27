package com.pj.auth.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthUserService;
import com.pj.config.web.controller.SystemManageController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/authuser")
@Api(value="authuser", description="权限", position=12)
public class AuthUserController extends SystemManageController{
	@Resource
	private AuthUserService authuserService;
	
	/**
	 * 添加权限
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	@ApiOperation(value = "添加权限", httpMethod = "POST", response = String.class, notes = "添加权限")
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	@ResponseBody()
	public Map<String, Object> saveauth(@ModelAttribute("AuthUser") AuthUser authuser)
			throws ClientProtocolException, IOException, URISyntaxException {
		Map<String, Object> map;
		try {
			this.authuserService.insert(authuser);
			map = this.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加权限失败" + e.getMessage());
			map = this.error();
		}
		return map;

	}
	
	/**
	 * 删除权限
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	@ApiOperation(value = "删除权限", httpMethod = "POST", response = String.class, notes = "删除权限")
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	@ResponseBody()
	public Map<String, Object> DeleteAuth(@ModelAttribute("AuthUser") AuthUser authuser)
			throws ClientProtocolException, IOException, URISyntaxException {
		Map<String, Object> map;
		try {
			this.authuserService.delete(authuser);
			map = this.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加权限失败" + e.getMessage());
			map = this.error();
		}
		return map;

	}
}
