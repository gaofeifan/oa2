package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowEntry;

public interface FlowEntryMapper extends MyMapper<FlowEntry> {

	/**
	 * 组合查询得到详情
	 * @param id
	 * @return
	 */
	List<FlowEntry> selectById(@Param(value = "id") Integer id);

}