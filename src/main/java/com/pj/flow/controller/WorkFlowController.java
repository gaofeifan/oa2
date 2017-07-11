package com.pj.flow.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.RecruitApplyReason;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;
import com.pj.system.service.PositionService;
import com.pj.system.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *	@author		GFF
 *	@date		2017年6月27日下午6:48:45
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Controller
@RequestMapping("/work")
@Api(value="work", description="工作流", position=1)
public class WorkFlowController {

	@Autowired
	private PositionService positionService;
	@Autowired
	private AuthAgencyService authAgencyService;
	@Resource
	private UserService userService;
	/**
	 * 	获取招聘流程
	 *	@author 	GFF
	 *	@date		2017年6月27日下午6:54:10
	 */
	@ApiOperation(value = "招聘待办查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘待办查询")
	@RequestMapping(value = "/getRecruitmentFlow.do", method = RequestMethod.GET)
	@ResponseBody
	public void getRecruitmentFlow(){
		User user = this.userService.selectByPrimaryKey(345);
		Position position = this.positionService.selectByPrimaryKey(user.getPositionid());
		authAgencyService.selectApplicantAgency(user.getCompanyid(), user.getDempid(), user.getIsCompanyBoss(),user.getIsDepartmentHead(), position, RecruitApplyReason.BUSSNESS.getReason(),2);
	}
}
