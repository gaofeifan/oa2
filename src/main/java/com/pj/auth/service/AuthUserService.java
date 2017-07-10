package com.pj.auth.service;

import java.util.List;

import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.service.BaseService;

public interface AuthUserService extends BaseService<AuthUser, Integer>  {

	
	int insertAuthUser(String type,Integer id,Integer fid,Integer userid,Integer current);
	
	int deleteByUserid(Integer userid);

	/**
	 * 根据userid 菜单id 和级别得到选中状态
	 * @param grade
	 * @param menuId
	 * @param userid
	 * @return
	 */
	List<Integer> getSelectedMenuIds(Integer grade, Integer menuId, Integer userid);
	
}
