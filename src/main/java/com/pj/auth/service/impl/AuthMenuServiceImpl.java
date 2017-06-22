package com.pj.auth.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthMenuMapper;
import com.pj.auth.pojo.AuthMenu;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;

@Service
@Transactional
public class AuthMenuServiceImpl extends AbstractBaseServiceImpl<AuthMenu, Integer>  {
	@Resource
	private AuthMenuMapper authMenuMapper;

	@Override
	public MyMapper<AuthMenu> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
}
