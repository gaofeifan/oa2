package com.pj.auth.service;

import java.util.List;

import com.pj.auth.pojo.AuthAgency;
import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;

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
	 * @param position 
	 * @param recruitApplyReason 
	 * 	@return
	 */
	List<User> selectApplicantAgency(Integer companyId, Integer dempId, Integer isCompanyLeader, Integer isDempLeader, Position position, Integer recruitApplyReason ,Integer applyId);

	/**
	 * 	根据公司部门查询机构
	 *	@author 	GFF
	 *	@date		2017年6月29日下午1:45:26	
	 * 	@param companyId
	 * 	@param dempId
	 * 	@return
	 */
	AuthAgency selectAuthAgencyByCompanyIdOrDempId(Integer companyId, Integer dempId, Integer grade);

	/**
	 * 	查询所有的机构
	 *	@author 	GFF
	 *	@date		2017年7月5日下午2:22:27	
	 * 	@return
	 */
	List<Object> selectAuthAgencyALL();

	/**
	 * 	查询机构级别
	 *	@author 	GFF
	 *	@date		2017年7月6日上午9:30:41
	 */
	AuthAgency selectInstitutionalLevel();

	/**
	 * 	根据公司部门查询所有机构权限
	 *	@author 	GFF
	 *	@date		2017年7月19日下午4:15:27	
	 * 	@param companyId
	 * 	@param dempId
	 * 	@param object
	 */
	List<AuthAgency> selectAuthAgencysByCompanyIdOrDempId(Integer companyId, Integer dempId);

}
