package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowUserApplication;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午9:18:18
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface FlowUserApplicationMapper extends MyMapper<FlowUserApplication> {

	/**
	 * 我的审批查询
	 * @author limr
	 * @param userid
	 * @param checkstatus
	 * @return
	 */
	List<FlowUserApplication> searchMyApproves(@Param(value = "userid") Integer userid, @Param(value = "checkstatus") Integer checkstatus);

	/**
	 * 根据申请表id和申请类型查询
	 * @param formId
	 * @param applyType
	 * @return
	 */
	FlowUserApplication selectByApplyIdAndType(@Param(value = "formId")Integer formId,@Param(value = "applyType") String applyType);
}
