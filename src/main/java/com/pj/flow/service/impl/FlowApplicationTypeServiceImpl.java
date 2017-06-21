package com.pj.flow.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowApplicationTypeMapper;
import com.pj.flow.pojo.FlowApplicationType;
import com.pj.flow.service.FlowApplicationTypeService;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:23:29
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class FlowApplicationTypeServiceImpl extends AbstractBaseServiceImpl<FlowApplicationType, Integer>
		implements FlowApplicationTypeService {

	@Resource
	private FlowApplicationTypeMapper flowApplicationTypeMapper;
	
	@Override
	public MyMapper<FlowApplicationType> getMapper() {
		return flowApplicationTypeMapper;
	}


}
