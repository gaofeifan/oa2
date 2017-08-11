package com.pj.app.service;

import java.util.Map;

/**
 *	@author		GFF
 *	@date		2017年8月7日上午11:42:00
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface WorkbenchAppService {

	/**
	 * 	根据邮箱查询工作台展示条数
	 *	@author 	GFF
	 *	@date		2017年8月7日上午11:43:05	
	 * 	@param email
	 * 	@return
	 */
	Map<String, Object> selectApprovalNumber(String email);

}
