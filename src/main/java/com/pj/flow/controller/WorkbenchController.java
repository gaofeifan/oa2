package com.pj.flow.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@RequestMapping(value="/ApplyState.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询我的申请状态", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue GetApprove(@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			Map<Integer,Integer> map = new HashMap<Integer, Integer>();
			map.put(0, flowApproveService.selectByCheckstatus(userid, 0));
			map.put(1, flowApproveService.selectByCheckstatus(userid, 1));
			map.put(2, flowApproveService.selectByCheckstatus(userid, 2));
			return this.successJsonp(map);
		} catch (Exception e) {
			logger.error("【WorkbenchController.Approve】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询我的申请状态失败"));
	}
	
	@RequestMapping(value="/ApprovalState.do" , method=RequestMethod.GET)
	@ApiOperation(value = "查询我的审批状态", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue GetApproveUserid(@ApiParam("用户ID") @RequestParam(value = "userid", required = true) Integer userid){
		try {
			return this.successJsonp(flowApproveService.selectByUserid(userid));
		} catch (Exception e) {
			logger.error("【WorkbenchController.ApproveUserid】"+e.getMessage());
			e.printStackTrace();
		}
		return this.successJsonp(this.error("查询我的审批状态失败"));
	}
	
}
