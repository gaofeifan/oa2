package com.pj.auth.mapper;

import com.pj.auth.pojo.AuthAgency;
import com.pj.config.base.mapper.MyMapper;

/**
 *	@author		GFF
 *	@date		2017年6月22日下午3:42:56
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface AuthAgencyMapper extends MyMapper<AuthAgency> {

	/**
	 * 	根据公司部门查询机构权限
	 *	@author 	GFF
	 *	@date		2017年6月28日上午11:53:21	
	 * 	@param record
	 * 	@return
	 */
	AuthAgency selectAuthAgencyByCompanyIdOrDempId(AuthAgency record);

}
