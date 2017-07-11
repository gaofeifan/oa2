package com.pj.flow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.flow.service.FlowApproveService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Workbench")
@Api(value="Workbench", description="工作台", position=1)
public class WorkbenchController  extends BaseController{

	@Autowired
	private FlowApproveService flowApproveService;
	
	@RequestMapping(value="/Approve.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询我的申请状态", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue GetMenu(
			@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid,
			@ApiParam("查询状态0:审批中  1:不同意  2:同意") @RequestParam(value = "isapprove", required = true) Integer isapprove){
		try {
			return this.successJsonp(flowApproveService.selectByApprove(userid, isapprove));
		} catch (Exception e) {
			logger.error("【WorkbenchController.Approve】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询我的申请状态失败"));
	}
	
	@RequestMapping(value="/ApproveUserid.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询我的审批状态", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue GetMenu(@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			return this.successJsonp(flowApproveService.selectByUserid(userid));
		} catch (Exception e) {
			logger.error("【WorkbenchController.ApproveUserid】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询我的审批状态失败"));
	}
	
}
