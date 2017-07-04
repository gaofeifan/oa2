package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowApprove;

public interface FlowApproveMapper extends MyMapper<FlowApprove> {

	/**
	 * 根据申请类型和申请表id得到审批信息列表
	 * @param applyId
	 * @param applyType
	 * @return
	 */
	List<FlowApprove> selectByApplyIdAndType(@Param(value = "applyId") Integer applyId, @Param(value = "applyType") String applyType);

	/**
	 * 根据中间表id查找审批人list
	 * @param id
	 * @return
	 */
	List<FlowApprove> selectListByApplyId(Integer applyId);
}