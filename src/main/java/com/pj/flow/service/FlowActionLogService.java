package com.pj.flow.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowActionLog;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:20:07
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface FlowActionLogService extends BaseService<FlowActionLog, Integer> {

	/**
	 * 根据入职表id查询得到操作日志记录
	 * @author limr
	 * @param entryId
	 * @return
	 */
	List<FlowActionLog> selectByEntryId(Integer entryId);

}
