package com.pj.flow.mapper;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowRecruit;

public interface FlowRecruitMapper extends MyMapper<FlowRecruit> {

	/**
	 * 根据主键得到组合数据
	 * @param id
	 * @return
	 */
	FlowRecruit selectById(@Param(value = "id") Integer id);
}