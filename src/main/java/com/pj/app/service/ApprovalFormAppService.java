package com.pj.app.service;

import java.util.List;

import com.pj.flow.pojo.FlowUserApplication;

/**
 *	@author		GFF
 *	@date		2017年8月7日下午1:44:56
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface ApprovalFormAppService {

	/**
	 * 	根据类型查询审批数据 通过类型与email
	 *	@author 	GFF
	 *	@date		2017年8月7日下午1:45:43	
	 * 	@param type
	 * 	@param email
	 * 	@return
	 */
	List<FlowUserApplication> selectApprovalformsByTypeANdEmail(String type, String email);

}
