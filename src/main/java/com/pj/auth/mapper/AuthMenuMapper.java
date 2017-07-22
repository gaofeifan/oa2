package com.pj.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.auth.pojo.AuthMenu;
import com.pj.config.base.mapper.MyMapper;

public interface AuthMenuMapper extends MyMapper<AuthMenu> {
	
	//获取菜单信息
	List<AuthMenu> GetMenu(AuthMenu authmenu);
	
	List<AuthMenu> GetMenubyUserid(@Param(value="grade") Integer grade,@Param(value="auth") Integer auth,@Param(value="userid") Integer userid);
	
	List<AuthMenu> GetOneMenubyUserid(@Param(value="userid") Integer userid);
	
	List<AuthMenu> GetTwoMenubyUserid(@Param(value="userid") Integer userid,@Param(value="fid") Integer fid);
	
	int GetAuthMenubyUserid(@Param(value="name") String name,@Param(value="userid") Integer userid);

	/**
	 * 得到三级菜单
	 * @author limr
	 * @param userid
	 * @param fid
	 * @return
	 */
	List<AuthMenu> GetThreeMenubyUserid(@Param(value="userid") Integer userid,@Param(value="fid") Integer fid);
	
	/**
	 * 查询所有需要设置权限的子菜单
	 * @author limr
	 * @param fid
	 * @return
	 */
	List<Integer> selectByFid(Integer fid);

	/**
	 * 根据是否需要岗位且级得到menuids
	 * @param post
	 * @param grade
	 * @return
	 */
	List<Integer> selectByPostAndGrade(@Param(value="post") Integer post, @Param(value="grade") int grade);

	//得到默认菜单
	List<AuthMenu> selectDefaults(int grade);

	/**
	 * 根据菜单名得到菜单
	 * @param name
	 * @return
	 */
	AuthMenu selectByName(String name);
}
