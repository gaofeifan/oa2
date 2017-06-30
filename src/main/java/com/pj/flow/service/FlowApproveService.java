package com.pj.flow.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowUserApplication;

/**
 *	@author		GFF
 *	@date		2017年6月26日下午2:14:12
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface FlowApproveService extends BaseService<FlowApprove, Integer> {

	/**
	 * 我的审批
	 * @param userid 审批人id
	 * @param checkstatus 
	 * @return
	 */
	List<FlowUserApplication> searchMyApproves(Integer userid, Integer checkstatus);

	/**
	 * 提交审批
	 * @param userid
	 * @param checkstatus
	 * @param handleidea
	 * @param formId
	 * @param applyType
	 */
	void commitApprove(Integer userid, Integer checkstatus, String handleidea, Integer formId, String applyType);

}
