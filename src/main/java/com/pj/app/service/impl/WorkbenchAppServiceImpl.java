package com.pj.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.app.service.WorkbenchAppService;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.ApprovalResults;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;

/**
 *	@author		GFF
 *	@date		2017年8月7日上午11:42:20
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class WorkbenchAppServiceImpl implements WorkbenchAppService {

	@Resource
	private FlowUserApplicationMapper flowUserApplicationMapper;
	@Resource
	private UserService userService;
	
	/**
	 * 	根据邮箱查询工作台展示条数
	 *	@author 	GFF
	 *	@date		2017年8月7日上午11:43:05	
	 * 	@param email
	 * 	@return
	 */
	@Override
	public Map<String, Object> selectApprovalNumber(String email) {
		User user = userService.selectByEamil(email);
		if(user == null){
			throw new RuntimeException("根据当前登录用户查询异常 请重新登录");
		}
		List<FlowUserApplication> approves = this.flowUserApplicationMapper.searchMyApproves(user.getId(),  ApprovalResults.UNTREATED.getValue());
		long entryCount = approves.stream().filter(approve -> approve.getApplyType().equals(ApplyType.ENTRY.getApplyType())).count();
		long recruitCount = approves.stream().filter(approve -> approve.getApplyType().equals(ApplyType.RECRUIT.getApplyType())).count();
		Map<String, Object> map = new HashMap<>();
		map.put(ApplyType.ENTRY.getApplyType(), entryCount);
		map.put(ApplyType.RECRUIT.getApplyType(), recruitCount);
		return map;
	}
	
}
