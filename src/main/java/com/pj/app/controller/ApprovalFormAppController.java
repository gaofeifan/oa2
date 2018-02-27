package com.pj.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.app.service.ApprovalFormAppService;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowApproveService;
import com.pj.flow.service.FlowEntryService;
import com.pj.flow.service.FlowRecruitService;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;
import com.pj.utils.AESUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *	@author		GFF
 *	@date		2017年8月7日下午1:33:41
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@RequestMapping("/app/approvalForm")
@Controller
@Api(value = "approvalForm-app", description = "审批表单(移动端)", position = 4)
public class ApprovalFormAppController extends BaseController {

	@Resource
	private FlowEntryService flowEntryService;
	@Resource
	private ApprovalFormAppService approvalFormAppService;
	@Resource
	private FlowApproveService flowApproveService;
	@Resource
	private UserService userService;
	@Resource
	private FlowRecruitService flowRecruitService;
	
	@ApiOperation(value = "查询审批表单(移动端)", httpMethod = "GET", response = Object.class)
	@RequestMapping(value = "/selectApprovalformsByTypeANdEmail.do", method = RequestMethod.GET)
	@ResponseBody
	public Object selectApprovalformsByTypeANdEmail(@ApiParam("类型   entry(入职) recruit(招聘)") @RequestParam("type") String type){
		List<FlowUserApplication> list;
		try {
			String email = //"yexu@pj-l.com";
					this.getSession();
			if(StringUtils.isBlank(email)){
				return this.errorToJsonp("查询邮箱为空  请检查是否登录");
			}
			list = this.approvalFormAppService.selectApprovalformsByTypeANdEmail(type,email);
			return this.successJsonp(list);
		} catch (Exception e) {
			return this.errorToJsonp(e.getMessage());
		}
	}
	@ApiOperation(value = "查询入职详情(移动端)", httpMethod = "GET", response = Object.class)
	@RequestMapping(value = "/selectEntryDetailById.do", method = RequestMethod.GET)
	@ResponseBody
	public Object selectEntryDetailById(@ApiParam("入职表单id") @RequestParam("entryId") Integer entryId){
		try {
			String email = //"wangxuehui@pj-l.com";
 					this.getSession();
			User user = userService.selectByEamil(email);
			final int userId = user.getId();
			Map<String, Object> result = new HashMap<String, Object>();
			//申请详情
			FlowEntry flowEntry = flowEntryService.selectById(entryId);
			//审批列表
			List<FlowApprove> list = flowApproveService.selectByApplyIdAndType(flowEntry.getId(), ApplyType.ENTRY.getApplyType());
			FlowApprove approve = list.stream().filter(fa -> fa.getUserid() == userId).findFirst().get();
			result.put("entry", flowEntry);
			result.put("approves", approve); 
			return this.successJsonp(result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			return this.errorToJsonp(e.getMessage());
		}
	}
	
	@ApiOperation(value = "查询招聘详情(移动端)", httpMethod = "GET", response = Object.class)
	@RequestMapping(value = "/selectRecruitDetailById.do", method = RequestMethod.GET)
	@ResponseBody
	public Object selectRecruitDetailById(@ApiParam("招聘表单id") @RequestParam("recruitId") Integer recruitId){
		try {
			String email = //"xuliping@pj-l.com";
					this.getSession();
			User user = this.userService.selectByEamil(email);
			final int userId = user.getId();
			Map<String, Object> result = new HashMap<String, Object>();
			//申请详情
			FlowRecruit recruit = flowRecruitService.selectById(recruitId);
			if(StringUtils.isNoneBlank(recruit.getReplaceOffer())){
				String string = AESUtils.decryptHex(recruit.getReplaceOffer(), AESUtils.ALGORITHM);
				recruit.setReplaceOffer(string);
			}
			//审批详情
			List<FlowApprove> list = flowApproveService.selectByApplyIdAndType(recruit.getId(), ApplyType.RECRUIT.getApplyType());
			FlowApprove approve = list.stream().filter(fa -> fa.getUserid() == userId).findFirst().get();
			result.put("recruit", recruit);
			result.put("approves", approve);
			return this.successJsonp(result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("异常" + e.getMessage());
			return this.errorToJsonp(e.getMessage());
		}
	}
}

