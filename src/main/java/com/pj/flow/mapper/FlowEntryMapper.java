package com.pj.flow.mapper;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;

public interface FlowEntryMapper extends MyMapper<FlowEntry> {

	/**
	 * 	根据表单id查询offer详情
	 *	@author 	GFF
	 *	@date		2017年6月26日下午7:35:00	
	 * 	@param applyId
	 */
	FlowOffer selectOfferDetailsByApplyId(Integer applyId);

}