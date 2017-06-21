package com.pj.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.system.mapper.AccountMapper;
import com.pj.system.pojo.User;
import com.pj.system.service.AccountService;
import com.pj.system.service.UserService;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private UserService userService;
	/*public  PageBean<User> findAll(int pageSize,int pageNum) {
		
		PageHelper.startPage(1,10);
		//PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		List<User> list = accountMapper.findAll();
		 
		 return new PageBean<User>(list);
		
	}*/
/*	@Override
	public PageBean<User> findByOne(int pageSize,int pageNum,User user) {

		PageHelper.startPage(1, 10);
		//PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		List<User> list = accountMapper.findByOne(user);
		
		return new PageBean<User>(list);
	}*/
	@Override
	public void updateByOne(List<User> ids) {
		for( User id: ids){
		
			if(ids.size() != 0){
				accountMapper.updateBatch(id);
			}
			}
		}
	@Override
	public User findById(Integer id) {
		User user = userService.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public void updateById(User user) {
		
		accountMapper.updateByOne(user);
	}
	
	
	
	/*public Pagination findAll(Integer pageNo,String username,Integer dempid,Integer companyid){
		UserQuery userQuery = new UserQuery();
		//当前页  pageNo如果是null 或小于1时 设置pageNo =1
		userQuery.setPageNo(Pagination.cpn(pageNo));
		//每页数
		userQuery.setPageSize(10);
		//拼接String
		StringBuilder params = new StringBuilder();
		//构建分页对象 （当前页，每页数（自定义）、总条数）
		if(username !=null&& username!=""){
			userQuery.setUsername(username);
			params.append("username=").append(username);
		}
		if(dempid !=null){
			userQuery.setDempid(dempid);
			params.append("&dempid").append(dempid);
		}
		if(companyid !=null){
			userQuery.setCompanyid(companyid);
			params.append("&companyid").append(companyid);
		}
		Pagination pagination = new Pagination(
				userQuery.getPageNo(),
				userQuery.getPageSize(),
				accountMapper.selectCount(userQuery)
				);
		//结果集
		pagination.setList(accountMapper.findAll(userQuery));
//		String url = "/oa/account/list";
//		pagination.pageView(url, params.toString());
//		
		return pagination;
	}*/
	public User findByName(String name) {
		/** 
		* @Title: findByName 
		* @Description: 
		* @param    
		* @return   
		*/
		return accountMapper.findByName(name);
	}
	@Override
	public void updatephone(User user) {
		try {
//			HttpclientUtils.update(user.getSsoId(), user.getUsername(), httpClienUrlProperties.getSsoUpdateUrl(), user.getEmail(), user.getPhone(), user.getRoleid(),null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		accountMapper.updateSet(user);
	}
	@Override
	public void SyncUpdateEmail(User user) {
		/** 
		* @Title: SyncUpdateEmail 
		* @Description: 与sso进行邮箱的数据同步
		* @param    
		* @return   
		*/
		accountMapper.updateById(user);
		
	}


}

