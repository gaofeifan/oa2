package com.pj.system.mapper;

import java.util.List;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.User;

public interface UserMapper extends MyMapper<User> {

	/**
	 * 	通过条件查询用户
	 *	@author 	GFF
	 *	@date		2017年6月20日下午2:46:37	
	 * 	@param user
	 * 	@return
	 */
	List<User> selectUsersByCondition(User user);

	/**
	 * 	分页查询
	 *	@author 	GFF
	 *	@date		2017年6月20日下午3:56:39	
	 * 	@param user
	 */
	List<User> pageQuery(User user);
}