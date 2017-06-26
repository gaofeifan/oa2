
package com.pj.system.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Company;

public interface CompanyService extends BaseService<Company, Integer> {
	
	/**
	 * 	根据名称查询
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:55:34	
	 * 	@param companyName
	 * 	@return
	 */
	Integer selectByName(String companyName);
	
	/**
	 * 	查询是否可以删除
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:55:57	
	 * 	@param companyId
	 * 	@return
	 */
	Boolean isDeleteCompany(Integer companyId);

	/**
	 * 根据用户权限查询所负责公司信息
	 * @author limr
	 * @param userId
	 * @return
	 */
	List<Company> getByAuthUser(Integer userId);


}
