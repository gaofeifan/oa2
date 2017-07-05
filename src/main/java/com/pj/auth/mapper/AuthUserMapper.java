package com.pj.auth.mapper;

import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.mapper.MyMapper;

public interface AuthUserMapper extends MyMapper<AuthUser> {
	
	int insertAuthUser(AuthUser authuser);
	
	int deleteByUserid(AuthUser authuser);
	
}
