package com.pj.system.mapper;

import java.util.List;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.Demp;

public interface DempMapper extends MyMapper<Demp> {


	/**
	 * 	获取公司下面的所有部门（排除该部门下面的所有子集）
	 *	@author 	GFF
	 *	@date		2017年1月24日下午4:20:25	
	 * 	@param id
	 * 	@return
	 */
	List<Demp> selectEliminateSubset(Integer id);

	/**
	 * 	获取当前id的父节点
	 *	@author 	GFF
	 *	@date		2017年6月27日下午2:40:44	
	 * 	@param id
	 * 	@return
	 */
	List<Demp> selectDempParentListById(Integer id);

	/**
	 * 	获取所有的子集
	 *	@author 	GFF
	 *	@date		2017年6月27日下午2:55:33	
	 * 	@param id
	 * 	@return
	 */
	List<Demp> selectDempChildListById(Integer id);

	
	
}