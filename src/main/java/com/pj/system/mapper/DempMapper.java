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
	
}