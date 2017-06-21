package com.pj.flow.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowApplicationType;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:22:08
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public interface FlowApplicationTypeService extends BaseService<FlowApplicationType, Integer> {

}
