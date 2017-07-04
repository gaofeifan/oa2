package com.pj.auth.service;

import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.service.BaseService;

public interface AuthUserService extends BaseService<AuthUser, Integer>  {

	
	int insertAuthUser(String type,Integer id,Integer fid,Integer userid,Integer current);
	
	int deleteByUserid(Integer userid);
	
}
