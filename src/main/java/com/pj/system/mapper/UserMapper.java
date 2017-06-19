package com.pj.system.mapper;

import java.util.List;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.User;

public interface UserMapper extends MyMapper<User> {


    int updateByPrimaryKey(User record);

    /**
     * 定时查询
     * @param user
     * @return
     */
	List<User> selectByDate(User user);


	/**
	 * 根据公司id多表查询得到人事用户id 
	 * @param companyid
	 * @return
	 */
	Integer selectHrByUerId(int companyid);

	//	根据公司与部门名称获取用户
	List<User> findUserByDempNameAndCompanyId(User user);

	//	分页查询
	List<User> pageQuery(User user);

	//	查询总数
	Integer selectUserCount(User user);


	List<User> findUserByDempNameAndCompanyIdAndPositionName(User user);

	List<User> findUserByDempNameAndCompanyIdAndPost(User user);

	List<User> findUserByCompanyAndDempAndPositionAndPost(User user);

	List<User> findUserByCompanyIdAndDempNameAndPositionId(User user);

	List<User> findUserByCompanyIdAndDempIdAndPositionId(User user);

	List<User> findUserByCompanyIdAndDempNameAndPositionIdAndPostId(User user);

	//	根据条件查询user
	List<User> findUserListByCondition(User user);

}