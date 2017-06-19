package com.pj.system.service;

import java.util.List;

import com.pj.system.pojo.Record;

public interface RecordService {

	//	保存消息操作表
	void saveRecord(Record record);

	//	根据消息id 查询消息详情表
	List<Record> findRecordsBymessageId(Integer id);

	//	更新消息
	void updateRecord(Record record);


}
