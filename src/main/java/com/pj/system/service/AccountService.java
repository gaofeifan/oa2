package com.pj.system.service;

import java.util.List;

import com.pj.system.pojo.User;

public interface AccountService {

	// 查询所有用户
/*	PageBean<User> findAll(int pageSize, int pageNum);*/

	// 条件查询
//	PageBean<User> findByOne(int pageSize, int pageNum, User user);


	void updateById(User user);

	void updateByOne(List<User> ids);

	User findById(Integer id);


	
//	public Pagination findAll(Integer pageNo,String username,Integer dempid,Integer companyid);
	
	public User findByName(String name);
	
	public void updatephone(User user);
	//与sso进行邮箱的数据同步
	public void SyncUpdateEmail(User user );

	

}
