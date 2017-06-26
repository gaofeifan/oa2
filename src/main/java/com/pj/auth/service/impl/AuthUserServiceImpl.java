package com.pj.auth.service.impl;

import javax.annotation.Resource;

import com.pj.auth.mapper.AuthUserMapper;
import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;

public class AuthUserServiceImpl extends AbstractBaseServiceImpl<AuthUser, Integer> {

	@Resource
	private AuthUserMapper authUserMapper;

	@Override
	public MyMapper<AuthUser> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
