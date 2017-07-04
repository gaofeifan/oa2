package com.pj.flow.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowActionLogMapper;
import com.pj.flow.pojo.FlowActionLog;
import com.pj.flow.service.FlowActionLogService;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:20:54
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class FlowActionLogServiceImpl extends AbstractBaseServiceImpl<FlowActionLog, Integer> implements FlowActionLogService {

	@Resource
	private FlowActionLogMapper flowActionLogMapper;
	
	@Override
	public MyMapper<FlowActionLog> getMapper() {
		return flowActionLogMapper;
	}

	@Override
	public List<FlowActionLog> selectByEntryId(Integer entryId) {
		return flowActionLogMapper.selectByEntryId(entryId);
	}

}
