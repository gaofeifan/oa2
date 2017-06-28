package com.pj.system.mapper;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.Position;

public interface PositionMapper extends MyMapper<Position> {
	
	/**
	 * 	根据岗位查询
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:31:13	
	 * 	@param originalpostid
	 * 	@return
	 */
	Position selectByPostId(Integer originalpostid);

	/**
	 * 	获取上级级别的职位信息
	 *	@author 	GFF
	 *	@date		2017年6月27日下午7:53:19	
	 * 	@param positionId
	 * @return 
	 */
	Position selectSuperiorPositionById(int positionId);

}