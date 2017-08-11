package com.pj.system.service;

import java.util.List;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Organization;
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

	List<Post> SelectByUserid(Integer userid,Integer menuid,Integer dempid);

	/**
	 * 根据公司查询直接子岗位,即dempid=0
	 * @param companyId
	 * @return
	 */
	List<Organization> selectLinealsByCompanyId(Integer companyId);

	/**
	 * 根据部门查询直接子岗位,即dempid=dempId
	 * @param dempId
	 * @return
	 */
	List<Organization> selectLinealsByDempId(Integer dempId);
	
	/**
	 * 新增，增加机构编码
	 * @author limr
	 * @param record
	 * @return
	 */
	public int insertSelective(Post post);

	/**
	 * 更新岗位的signNum
	 */
	void updateSignNum();

	/**
	 * 修改，增加机构编码
	 * @author limr
	 * @param post
	 * @return
	 */
	void updatePost(Post post);

	/**
	 * 权限模块根据部门或公司查询岗位
	 * @author limr
	 * @param post
	 * @return
	 */
	List<Post> selectByComOrDemp(Post post);

}
