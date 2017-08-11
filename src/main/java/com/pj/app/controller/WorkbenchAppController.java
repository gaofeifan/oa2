package com.pj.app.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.app.service.WorkbenchAppService;
import com.pj.config.web.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *	@author		GFF
 *	@date		2017年8月7日上午11:23:29
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@RequestMapping("/app/workbench")
@Controller
@Api(value = "workbench-app", description = "工作台(移动端)", position = 4)
public class WorkbenchAppController extends BaseController {

	@Resource
	private WorkbenchAppService workbenchAppService;
	@ApiOperation(value = "查询工作台审批数量", httpMethod = "GET", response = String.class, notes = "添加用户")
	@RequestMapping(value = "/selectApprovalNumber.do", method = RequestMethod.GET)
	@ResponseBody()
	public Object selectApprovalNumber(){
		String email = //"wangxuehui@pj-l.com";
				this.getSession();
		if(StringUtils.isBlank(email)){
			return this.errorToJsonp("查询邮箱为空  请检查是否登录");
		}
		try {
			Map<String,Object> map = this.workbenchAppService.selectApprovalNumber(email);
			return this.successJsonp(map);
		} catch (Exception e) {
			return this.errorToJsonp(e.getMessage());
		}
	}
}
