package com.pj.auth.service;

import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.service.BaseService;

public interface AuthUserService extends BaseService<AuthUser, Integer>  {

	
	int insertAuthUser(AuthUser authuser);
	
	int deleteByUserid(Integer userid);
}
