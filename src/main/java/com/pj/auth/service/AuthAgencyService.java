package com.pj.auth.service;

import com.pj.auth.pojo.AuthAgency;
import com.pj.config.base.service.BaseService;

/**
 *	@author		GFF
 *	@date		2017年6月22日下午3:44:20
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface AuthAgencyService extends BaseService<AuthAgency, Integer> {

	/**
	 * 	查询用户的机构等级
	 *	@author 	GFF
	 *	@date		2017年6月28日上午9:56:31	
	 * 	@param companyId
	 * 	@param dempId
	 * 	@param isCompanyLeader
	 * 	@param isDempLeader
	 * 	@return
	 */
	AuthAgency selectApplicantAgency(int companyId, int dempId, int isCompanyLeader, int isDempLeader);

}
