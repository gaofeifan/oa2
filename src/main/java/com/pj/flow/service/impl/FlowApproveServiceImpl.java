package com.pj.flow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowApproveMapper;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowApproveService;

/**
 *	@author		GFF
 *	@date		2017年6月26日下午2:15:05
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class FlowApproveServiceImpl extends AbstractBaseServiceImpl<FlowApprove, Integer>
									implements FlowApproveService {

	@Resource
	private FlowApproveMapper flowApproveMapper;
	
	@Resource
	private FlowUserApplicationMapper flowUserApplicationMapper;
	
	@Override
	public MyMapper<FlowApprove> getMapper() {
		return flowApproveMapper;
	}

	@Override
	public List<FlowUserApplication> searchMyApproves(Integer userid, Integer checkstatus) {
		return flowUserApplicationMapper.searchMyApproves(userid, checkstatus);
	}


}
