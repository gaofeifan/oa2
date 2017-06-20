package com.pj.flow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.service.EntryService;

@Transactional
@Service
public class EntryServiceImpl extends AbstractBaseServiceImpl<FlowEntry, Integer> implements EntryService {

	@Autowired
	private FlowEntryMapper flowEntryMapper;
	@Override
	public MyMapper<FlowEntry> getMapper() {
		return flowEntryMapper;
	}

}
