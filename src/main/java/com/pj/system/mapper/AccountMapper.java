package com.pj.system.mapper;

import java.util.List;

import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.User;
import com.pj.system.pojo.UserQuery;

public interface AccountMapper {

	//查询所有用户信息
	List<User> findAll();
	//条件查询
	List<User> findByOne(User user);
	//用户管理批里更新用户
	void updateBatch(User user);
	//查询用户
	User findById(Integer id);
	//账号管理更新单个用户
	void updateByOne(User user);
	//用户设置更新手机号,密码
	void updateSet(User user);
	//查询所有公司
	List<Company> selctCompany();
	//查询所有部门
	List<Demp> selectDept();
	//查询所有用户带分页
	List<User> findAll(UserQuery userQuery); 
	//查询总条数
	Integer selectCount(UserQuery userQuery);
	//根据用户名查找用户
	User findByName(String username);
	//只是查询用户
	User findId(Integer id);
	//与sso进行邮箱的数据同步
	void syncUpdateEmail(String email,User user);
	void updateById(User user);
}
