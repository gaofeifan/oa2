package com.pj.system.service;

import java.util.List;
import java.util.Set;

import com.pj.config.base.pojo.page.Pagination;
import com.pj.system.pojo.PageBean;
import com.pj.system.pojo.User;

public interface AccountService {

	// 查询所有用户
	PageBean<User> findAll(int pageSize, int pageNum);

	// 条件查询
	PageBean<User> findByOne(int pageSize, int pageNum, User user);

	// 批量更新用户信息
	void updateByBatch(List<User> ids);

	void updateById(User user);

	void updateByOne(List<User> ids);

	User findById(Integer id);

	/**
	 * 修改密码,email
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Integer id, String newPassword, String email);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePasswordByAll(Set<Integer> userId, String newPassword);

	List<User> findAll();
	
	public Pagination findAll(Integer pageNo,String username,Integer dempid,Integer companyid);
	
	public User findByName(String name);
	
	public void updatephone(User user);
	//与sso进行邮箱的数据同步
	public void SyncUpdateEmail(User user );

	

}
