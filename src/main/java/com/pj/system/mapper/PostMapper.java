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
	 * 查询部门下直接的岗位，即dempid=dempId
	 * @author limr
	 * @param dempId
	 * @return
	 */
	List<Organization> selectLinealsByDempId(Integer dempId);

}