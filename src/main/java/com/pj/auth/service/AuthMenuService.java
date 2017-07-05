package com.pj.auth.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.auth.pojo.AuthMenu;
import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.service.BaseService;


public interface AuthMenuService extends BaseService<AuthMenu, Integer> {


	List<AuthMenu> GetMenu(AuthMenu authmenu);

	List<AuthMenu> GetMenubyUserid(Integer grade,Integer auth,Integer userid);

	/**
	 * 	根据消息中心id查询所有具有消息中心权限的人员
	 *	@author 	GFF
	 *	@date		2017年7月3日下午2:22:48	
	 * 	@return
	 */
	List<AuthUser> selectUserByMessageCenterId();
	
	List<AuthMenu> GetOneMenubyUserid(Integer userid);

	List<AuthMenu> GetTwoMenubyUserid(Integer userid,Integer fid);
	  
	int GetAuthMenubyUserid(String name,Integer userid);
}
