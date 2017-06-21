package com.pj.flow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.service.FlowEntryService;

@Transactional
@Service
public class FlowEntryServiceImpl extends AbstractBaseServiceImpl<FlowEntry, Integer> implements FlowEntryService {

	@Autowired
	private FlowEntryMapper flowEntryMapper;
	@Override
	public MyMapper<FlowEntry> getMapper() {
		return flowEntryMapper;
	}

}
