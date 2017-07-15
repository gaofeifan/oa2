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
	
	int selectByApprove(@Param(value = "userid") Integer userid,@Param(value = "checkstatus") Integer checkstatus);
	
	int selectByUserid(@Param(value = "userid") Integer userid);

	/**
	 * 	查询下一个审批人员
	 *	@author 	GFF
	 *	@date		2017年7月11日下午3:06:06	
	 * 	@param id
	 * 	@param applyId
	 */
	FlowApprove selectNextApproval(@Param(value = "approveId") Integer id, @Param(value = "applyId") Integer applyId);

	/**
	 * 	查询所有为审批的流程
	 *	@author 	GFF
	 *	@date		2017年7月12日下午4:19:57	
	 * 	@return
	 */
	List<FlowApprove> selectNoApprovalAll();
}