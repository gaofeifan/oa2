package com.pj.system.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Demp;

public interface DempService  extends BaseService<Demp, Integer>{


	/**
	 * 	获取公司下的所有部门
	 *	@author 	GFF
	 *	@date		2017年4月10日下午5:38:09	
	 * 	@param companyId
	 * 	@return
	 */
	List<Demp> selectByCompanyId(Integer companyId);


	/**
	 * 	根据部门名称公司id查询
	 *	@author 	GFF
	 *	@date		2016年12月23日下午4:29:30	
	 * 	@param companyId
	 * 	@param dempName
	 * 	@return
	 */
	Integer selectByNameANDCompanyId(Integer companyId, String dempName);
	
	/**
	 * 	获取公司下面的所有部门（排除该部门下面的所有子集）
	 *	@author 	GFF
	 *	@date		2017年1月24日下午4:18:07	
	 * 	@param id
	 * 	@return
	 */
	List<Demp> selectEliminateSubset(Integer id);

	/**
	 * 	判断是否可以删除
	 *	@author 	GFF
	 *	@date		2017年4月10日下午5:48:22	
	 * 	@param id
	 * 	@return
	 */
	Boolean isDeleteDemp(Integer id);


	

	
}
