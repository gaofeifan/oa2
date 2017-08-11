package com.pj.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.Organization;
import com.pj.system.pojo.Post;

public interface PostMapper extends MyMapper<Post>{
	/**
	 * 	根据条件查询岗位
	 *	@author 	GFF
	 *	@date		2016年12月23日下午4:38:23	
	 * 	@param post
	 * 	@return
	 */
	List<Post> selectALL(Post post);
	
	List<Post> SelectByUserid(@Param(value = "userid") Integer userid,@Param(value = "menuid") Integer menuid,@Param(value = "dempid") Integer dempid);

	/**
	 * 查询公司下直接的岗位，即dempid=0
	 * @author limr
	 * @param companyId
	 * @return
	 */
	List<Organization> selectLinealsByCompanyId(Integer companyId);
	/**
	 * 查询公司下直接的岗位，即dempid=0
	 * @author limr
	 * @param companyId
	 * @return
	 */
	List<Integer> selectLinealIdsByCompanyId(Integer companyId);

	/**
	 * 查询部门下直接的岗位，即dempid=dempId
	 * @author limr
	 * @param dempId
	 * @return
	 */
	List<Organization> selectLinealsByDempId(Integer dempId);

	/**
	 * 根据number得到数据
	 * @author limr
	 * @param number
	 * @return
	 */
	Organization selectByNumber(String number);

	/**
	 * 得到所有postid
	 * @author limr
	 * @param isdelete
	 * @return
	 */
	List<Integer> selectAllPostId(int isdelete);

	/**
	 * 查询部门下直接的岗位num
	 * @author limr
	 * @param dempId
	 * @return
	 */
	List<String> selectLinealNumsByCompanyId(Integer companyId);

	/**
	 * 查询部门下直接的岗位number，即dempid=dempId
	 * @author limr
	 * @param dempId
	 * @return
	 */
	List<String> selectLinealNumsByDempId(Integer dempId);

	/**
	 * 得到所有companyid
	 * @author limr
	 * @param isdelete
	 * @return
	 */
	List<Integer> selectAllCId(int isdelete);
	/**
	 * 得到所有demptid
	 * @author limr
	 * @param isdelete
	 * @return
	 */
	List<Integer> selectAllDId(int isdelete);

	/**
	 * 查询部门下直接的岗位id
	 * @author limr
	 * @param dempId
	 * @return
	 */
	List<Integer> selectLinealIdsByDempId(Integer dempId);

	/**
	 * 权限模块根据部门或公司查询岗位
	 * @author limr
	 * @param post
	 * @return
	 */
	List<Post> selectByComOrDemp(Post post);
	

}