package com.pj.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.auth.pojo.AuthMenu;
import com.pj.config.base.mapper.MyMapper;

public interface AuthMenuMapper extends MyMapper<AuthMenu> {
	
	//获取菜单信息
	List<AuthMenu> GetMenu(AuthMenu authmenu);
	
	List<AuthMenu> GetMenubyUserid(@Param(value="grade") Integer grade,@Param(value="auth") Integer auth,@Param(value="userid") Integer userid);
}
