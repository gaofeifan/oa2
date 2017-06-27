package com.pj.auth.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthUserMapper;
import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;

@Service
@Transactional
public class AuthUserServiceImpl extends AbstractBaseServiceImpl<AuthUser, Integer> implements AuthUserService{

	@Resource
	private AuthUserMapper authUserMapper;

	@Override
	public MyMapper<AuthUser> getMapper() {
		return authUserMapper;
	}

	@Override
	public int insertAuthUser(AuthUser authuser) {
		return authUserMapper.insertAuthUser(authuser);
	}

	@Override
	public int deleteByUserid(Integer userid) {
		return authUserMapper.deleteByUserid(userid);
	}

}
