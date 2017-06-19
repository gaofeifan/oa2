package com.pj.system.service;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Rank;

public interface RankService extends BaseService<Rank, Integer> {

	/**
	 * 	根据名称查询
	 *	@author 	GFF
	 *	@date		2017年4月11日上午9:40:02	
	 * 	@param rankName
	 * 	@return
	 */
	Integer selectByName(String rankName);

}
