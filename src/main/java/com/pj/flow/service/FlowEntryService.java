package com.pj.flow.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowEntry;

public interface FlowEntryService extends BaseService<FlowEntry, Integer> {

	/**
	 * 提交申请
	 * @param flowEntry
	 * @param salarys
	 */
	void insertEntryAndSalary(FlowEntry flowEntry, String salarys);

	/**
	 * 组合查询得到详情
	 * @param entryId
	 * @return
	 */
	List<FlowEntry> selectById(Integer entryId);

}
