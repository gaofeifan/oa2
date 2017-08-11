package com.pj.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.app.service.ApprovalFormAppService;
import com.pj.config.base.constant.ApprovalResults;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;
import com.pj.utils.DateUtils;

/**
 *	@author		GFF
 *	@date		2017年8月7日下午1:45:20
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class ApprovalFormAppServiceImpl implements ApprovalFormAppService {

	@Resource
	private FlowUserApplicationMapper flowUserApplicationMapper;
	@Resource
	private UserService userService;
	
	@Override
	public List<FlowUserApplication> selectApprovalformsByTypeANdEmail(String type, String email) {
		User user = userService.selectByEamil(email);
		if(user == null){
			throw new RuntimeException("根据当前登录用户查询异常 请重新登录");
		}
		if(StringUtils.isBlank(type)){
			throw new RuntimeException("类型传递有误");
		}
		Date endDate = new Date();
		String month = DateUtils.getNextMonth(endDate, -1);
		Date startDate = DateUtils.convert(month, DateUtils.DATE_FORMAT);
		List<FlowUserApplication> approves = this.flowUserApplicationMapper.searchMyApprovesApp(user.getId(), ApprovalResults.UNTREATED.getValue(),startDate,endDate);
		approves = approves.stream().filter(approve -> approve.getApplyType().equals(type)).collect(Collectors.toList());
		
		List<FlowUserApplication> apps = this.flowUserApplicationMapper.searchMyApprovesApp(user.getId(),ApprovalResults.NO_AGREE.getValue(),startDate,endDate);
		apps = apps.stream().filter(approve -> approve.getApplyType().equals(type)).collect(Collectors.toList());
		approves.addAll(apps);
		return approves;
	}

}
