package com.pj.auth.service;

import java.util.List;

import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.service.BaseService;

public interface AuthUserService extends BaseService<AuthUser, Integer>  {

	
//	int insertAuthUser(String type,Integer id,Integer fid,Integer userid,Integer current);
	/**
	 * 保存权限
	 * @author limr
	 * @param type
	 * @param menuId
	 * @param grade 
	 * @param number
	 * @param userid
	 * @param isSelected:0取消勾选，1为勾选
	 */
	void insertAuthUser(String type, Integer menuId, Integer grade, String number, Integer userid, Integer isSelected);
	
	int deleteByUserid(Integer userid);

	/**
	 * 根据userid 菜单id 和级别得到选中状态
	 * @author limr
	 * @param grade
	 * @param post
	 * @param number
	 * @param menuId
	 * @param userid
	 * @return
	 */
	List<String> getSelectedMenuIds(Integer grade, Integer post, String number, Integer menuId, Integer userid);

	/**
	 * 保存默认权限
	 * @param userid
	 */
	void insertDefaultAuthUser(Integer userid);
	
}
