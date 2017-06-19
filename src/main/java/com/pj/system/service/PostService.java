package com.pj.system.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Post;

public interface PostService extends BaseService<Post, Integer> {


	/**
	 * 	根据条件查询岗位
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:01:39	
	 * 	@param post
	 * 	@return
	 */
	List<Post> selectALL(Post post);

	/**
	 * 	根据name查询
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:01:48	
	 * 	@param postName
	 * 	@return
	 */
	Integer selectByName(String postName);
	
	/**
	 * 	根据职级查询岗位
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:02:02	
	 * 	@param positionId
	 * 	@return
	 */
	List<Post> selectByPositionId(Integer positionId);

	/**
	 * 	查询是否可以删除
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:02:11	
	 * 	@param id
	 * 	@return
	 */
	Boolean isDeleteDemp(Integer id);

	/**
	 * 	根据名称部门id查询
	 *	@author 	GFF
	 *	@date		2016年12月23日下午4:35:15	
	 * 	@param dempId
	 * 	@param postName
	 * 	@return
	 */
	Integer selectByNameANDDempId(Integer dempId, String postName);



}
