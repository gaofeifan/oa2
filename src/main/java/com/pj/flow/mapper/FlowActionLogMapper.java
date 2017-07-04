package com.pj.flow.mapper;

import java.util.List;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowActionLog;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:19:16
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface FlowActionLogMapper extends MyMapper<FlowActionLog> {

	/**
	 * 根据入职表id查询得到操作日志记录
	 * @author limr
	 * @param entryId
	 * @return
	 */
	List<FlowActionLog> selectByEntryId(Integer entryId);

	/**
	 * 得到招聘id为recruitId的已有日志记录的entryId(去重)
	 * @param recruitId
	 * @return
	 */
	List<Integer> selectByRecruitId(Integer recruitId);
}
