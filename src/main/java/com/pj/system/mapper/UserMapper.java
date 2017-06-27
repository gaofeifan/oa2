package com.pj.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	/**
	 * 查找公司领导
	 * @author limr
	 * @param companyid
	 * @return
	 */
	User getCompanyLeader(@Param(value="companyid") Integer companyid);

	/**
	 * 查找部门领导
	 * @author limr
	 * @param dempid
	 * @return
	 */
	User getDempLeader(@Param(value="dempid") Integer dempid);
	
	/**
	 * 根据部门id和姓名查找用户
	 * @author limr
	 * @param dempId
	 * @param username
	 * @return
	 */
	List<User> selectByNameAndDempId(@Param(value="dempid") Integer dempid, @Param(value="username") String username);

	/**
	 * 根据公司id和姓名查找用户
	 * @author limr
	 * @param companyId
	 * @param username
	 * @return
	 */
	List<User> selectByNameAndCompanyId(@Param(value="companyid") Integer companyid, @Param(value="username") String username);
}