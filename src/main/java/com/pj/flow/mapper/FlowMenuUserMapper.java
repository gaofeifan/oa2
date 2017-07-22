package com.pj.flow.mapper;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowMenuUser;

public interface FlowMenuUserMapper extends MyMapper<FlowMenuUser> {

	/**
	 * 根据用户菜单和类型查询
	 * @author limr
	 * @param userId
	 * @param id
	 * @param applyType
	 * @return
	 */
	FlowMenuUser selectByUserMenuType(@Param(value = "userid") Integer userid, @Param(value = "menuid") Integer menuid, @Param(value = "type") String type);

}