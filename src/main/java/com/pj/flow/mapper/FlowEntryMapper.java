package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;

public interface FlowEntryMapper extends MyMapper<FlowEntry> {

	/**
	 * 组合查询得到详情
	 * @param id
	 * @return
	 */
	FlowEntry selectById(@Param(value = "id") Integer id);
	
	/**	根据表单id查询offer详情
	 *	@author 	GFF
	 *	@date		2017年6月26日下午7:35:00	
	 * 	@param applyId
	 */
	FlowOffer selectOfferDetailsByApplyId(Integer applyId);

	/**
	 * 我的入职申请
	 * @param userId
	 * @return
	 */
	List<FlowEntry> searchEntrys(Integer userId);

	void insertEntry(FlowEntry flowEntry);

	/**
	 * 根据主键得到入职表的申请人信息
	 * @param formId
	 * @return
	 */
	FlowEntry selectApplyInfoById(Integer formId);

}