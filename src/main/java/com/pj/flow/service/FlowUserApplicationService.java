package com.pj.flow.service;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowUserApplication;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:24:29
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface FlowUserApplicationService extends BaseService<FlowUserApplication, Integer>{

	/**
	 * 根据申请表id和申请类型查询
	 * @param formId
	 * @param applyType
	 * @return
	 */
	FlowUserApplication selectByApplyIdAndType(@Param(value = "formId")Integer formId, @Param(value = "applyType")String applyType);
}
