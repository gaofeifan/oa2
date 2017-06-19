package com.pj.system.service;

import java.util.List;

import com.pj.system.pojo.SystemRole;

/**
 *	@author		GFF
 *	@date		2016年12月21日下午4:03:55
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface SystemRoleService {

	/**
	 *	@author 	GFF
	 *	@date		2016年12月21日下午4:04:23	
	 * 	@param systemRole
	 */
	void saveSystemRole(SystemRole systemRole);
	
	void updateSystemRole(SystemRole systemRole);

	/**
	 *	@author 	GFF
	 *	@date		2016年12月21日下午4:23:04	
	 * 	@param 		systemRole
	 * 				根据条件查询
	 * 	@return
	 */
	List<SystemRole> findSystemRoleByCondition(SystemRole systemRole);

	/**
	 *	@author 	GFF
	 *	@date		2016年12月21日下午4:35:53	
	 * 	@param id
	 */
	void deleteSystemRoleById(Integer id);

}
