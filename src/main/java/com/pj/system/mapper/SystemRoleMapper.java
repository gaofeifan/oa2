package com.pj.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.pj.system.pojo.SystemRole;
import com.pj.system.pojo.SystemRoleQuery;

public interface SystemRoleMapper {
    int countByExample(SystemRoleQuery example);

    int deleteByExample(SystemRoleQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    List<SystemRole> selectByExample(SystemRoleQuery example);

    SystemRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemRole record, @Param("example") SystemRoleQuery example);

    int updateByExample(@Param("record") SystemRole record, @Param("example") SystemRoleQuery example);

    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);

	/**
	 *	@author 	GFF
	 *	@date		2016年12月21日下午4:19:15	
	 * 	@param systemRole
	 */
}