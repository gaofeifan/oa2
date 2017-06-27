package com.pj.auth.mapper;

import java.util.List;
import com.pj.auth.pojo.AuthMenu;
import com.pj.config.base.mapper.MyMapper;

public interface AuthMenuMapper extends MyMapper<AuthMenu> {
	
	//获取菜单信息
	List<AuthMenu> GetMenu(AuthMenu authmenu);
	
}
