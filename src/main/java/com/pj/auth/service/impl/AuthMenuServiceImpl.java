package com.pj.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthMenuMapper;
import com.pj.auth.pojo.AuthMenu;
import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthMenuService;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;


@Transactional
@Service
public class AuthMenuServiceImpl extends AbstractBaseServiceImpl<AuthMenu, Integer> implements AuthMenuService {

	@Resource
	private AuthMenuMapper authMenuMapper;
	
	@Resource
	private AuthUserService authUserService;
	
	private static final Integer messageCenterMenuId = 46 ;

	@Override
	public MyMapper<AuthMenu> getMapper() {
		return authMenuMapper;
	}
	
	@Override
	public List<AuthMenu> GetMenu(AuthMenu authmenu) {
		List<AuthMenu> authmenus = this.authMenuMapper.GetMenu(authmenu);
		return authmenus;
	}

	@Override
	public List<AuthMenu> GetMenubyUserid(Integer grade, Integer auth, Integer userid) {
		List<AuthMenu> authmenus =authMenuMapper.GetMenubyUserid(grade, auth, userid);
		return authmenus;
	}

	@Override
	public List<AuthUser> selectUserByMessageCenterId() {
		AuthUser record = new AuthUser();
		record.setMenuid(messageCenterMenuId);
		List<AuthUser> list = this.authUserService.select(record );
		return list;
	}
	
	@Override
	public List<AuthMenu> GetOneMenubyUserid(Integer userid) {
		List<AuthMenu> authmenus =authMenuMapper.GetOneMenubyUserid(userid);
		return authmenus;
	}

	@Override
	public List<AuthMenu> GetTwoMenubyUserid(Integer userid, Integer fid) {
		List<AuthMenu> authmenus =authMenuMapper.GetTwoMenubyUserid(userid,fid);
		return authmenus;
	}

	@Override
	public int GetAuthMenubyUserid(String name, Integer userid) {
		int num =authMenuMapper.GetAuthMenubyUserid(name,userid);
		return num;
	}
	

	 

}
