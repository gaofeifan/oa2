package com.pj.system.service;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Position;
public interface PositionService extends BaseService<Position, Integer> {

	/**
	 * 	查询是否可以删除
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:22:47	
	 * 	@param id
	 * 	@return
	 */
	Boolean isDeletePosition(Integer id);

	/**
	 * 	根据岗位查询职位
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:42:29	
	 * 	@param originalpostid
	 * 	@return
	 */
	Position selectByPostId(Integer originalpostid);
	
	/**
	 * 	根据名称查询
	 *	@author 	GFF
	 *	@date		2017年4月10日下午6:45:36	
	 * 	@param positionName
	 * 	@return
	 */
	Integer selectByName(String positionName);

	/**
	 * 	获取上级级别的职位信息
	 *	@author 	GFF
	 *	@date		2017年6月27日下午7:42:39	
	 * 	@param positionId
	 */
	Position selectSuperiorPositionById(int positionId);

	/**
	 * 	根据级别查询职位
	 *	@author 	GFF
	 *	@date		2017年6月28日上午9:20:24	
	 * 	@param grade
	 * 	@return
	 */
	Position selectPositionByGrade(int grade);
}
