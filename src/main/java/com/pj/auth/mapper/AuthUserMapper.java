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
	List<AuthUser> selectByUserid(@Param(value = "userid") Integer userid, @Param(value = "type") String type);

	/**
	 * 根据userid和menuid删除数据
	 * @author limr
	 * @param userid
	 * @param menuId
	 * @param postid
	 */
	void deleteByUserMenuPost(@Param(value = "userid") Integer userid, @Param(value = "menuid") Integer menuid, @Param(value = "postid") Integer postid);

	/**
	 * 根据用户和菜单id type=post得到所有的岗位id
	 * @author limr
	 * @param userid
	 * @param menuid
	 * @return
	 */
	List<Integer> selectByMenuidAndUserid(@Param(value = "userid") Integer userid, @Param(value = "menuid") Integer menuid);

	/**
	 * 根据用户和菜单id type得到权限
	 * @author limr
	 * @param userid
	 * @param menuid
	 * @return
	 */
	AuthUser selectByUserMenuType(@Param(value = "userid") Integer userid, @Param(value = "menuid") Integer menuid, @Param(value = "type") String type);
	
	/**
	 * 根据userid和like menuids查询
	 * @param userid
	 * @param string
	 * @return
	 */
	List<AuthUser> selectByUseridAndMenuids(@Param(value = "userid") Integer userid, @Param(value = "menuids") String menuids);
	
	
}
