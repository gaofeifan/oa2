package com.pj.flow.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowUserApplicationService;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:25:14
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class FlowUserApplicationServiceImpl extends AbstractBaseServiceImpl<FlowUserApplication, Integer> implements FlowUserApplicationService {

	@Resource
	private FlowUserApplicationMapper flowUserApplicationMapper;
	
	@Override
	public MyMapper<FlowUserApplication> getMapper() {
		return flowUserApplicationMapper;
	}

}
