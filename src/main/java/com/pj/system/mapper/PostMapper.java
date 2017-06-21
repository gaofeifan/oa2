package com.pj.system.mapper;

import java.util.List;

import com.pj.config.base.mapper.MyMapper;
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

}