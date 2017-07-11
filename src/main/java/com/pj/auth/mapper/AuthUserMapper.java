package com.pj.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.auth.pojo.AuthUser;
import com.pj.config.base.mapper.MyMapper;

public interface AuthUserMapper extends MyMapper<AuthUser> {
	
	int insertAuthUser(AuthUser authuser);
	
	int deleteByUserid(AuthUser authuser);

	/**
	 * 根据userid得到权限列表
	 * @author limr
	 * @param userid
	 * @return
	 */
	List<AuthUser> selectByUserid(@Param(value = "userid") Integer userid);
	
	
}
