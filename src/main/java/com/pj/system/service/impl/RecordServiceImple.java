package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.system.mapper.RecordMapper;
import com.pj.system.pojo.Record;
import com.pj.system.service.RecordService;

@Service
@Transactional
public class RecordServiceImple implements RecordService {

	@Resource
	private RecordMapper recordMapper;
	
	public void saveRecord(Record record) {
		this.recordMapper.insertSelective(record);
	}

	@Override
	public List<Record> findRecordsBymessageId(Integer messageid) {
		List<Record> records = this.recordMapper.findRecordsBymessageId(messageid);
		return records.size() != 0 ? records :null;
	}

	@Override
	public void updateRecord(Record record) {
		this.recordMapper.updateByPrimaryKeySelective(record);
		
	}
	
	
}
