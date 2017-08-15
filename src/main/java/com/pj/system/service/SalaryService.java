package com.pj.system.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Salary;

/**
 *	@author		GFF
 *	@date		2017年6月22日下午3:48:22
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface SalaryService extends BaseService<Salary, Integer> {

	/**
	 * 	通过用户查询薪资
	 *	@author 	GFF
	 *	@date		2017年6月22日下午4:05:36	
	 * 	@param userId
	 * 	@return
	 */
	public List<Salary> selectSalaryByUserId(Integer userId);

	/**
	 * 	通过用户查询薪资
	 *	@author 	GFF
	 *	@date		2017年6月22日下午4:05:36	
	 * 	@param userId
	 * 	@return
	 */
	public List<Salary> selectSalaryByEntryId(Integer entryId);

	/**
	 * 	查询未加密薪资根据用户id
	 *	@author 	GFF
	 *	@date		2017年8月15日上午9:57:11	
	 * 	@param id
	 * 	@return
	 */
	public List<Salary> selectUnencryptedSalaryByUserId(Integer id);

	/**
	 * 	更新用户薪资不进行加密
	 *	@author 	GFF
	 *	@date		2017年8月15日上午10:00:26	
	 * 	@param salary
	 */
	public void updateByPrimaryKeyNoEncryption(Salary salary);
}
