package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.system.mapper.SystemRoleMapper;
import com.pj.system.pojo.SystemRole;
import com.pj.system.pojo.SystemRoleQuery;
import com.pj.system.pojo.SystemRoleQuery.Criteria;

/**
 *	@author		GFF
 *	@date		2016年12月21日下午4:04:09
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class SystemRoleService implements com.pj.system.service.SystemRoleService {

	@Resource
	private SystemRoleMapper systemRoleMapper;
	
	public void saveSystemRole(SystemRole systemRole) {
		this.systemRoleMapper.insertSelective(systemRole);
		
	}
	
	public void updateSystemRole(SystemRole systemRole){
		this.systemRoleMapper.updateByPrimaryKeySelective(systemRole);
	}

	@Override
	public List<SystemRole> findSystemRoleByCondition(SystemRole systemRole) {
		SystemRoleQuery example = new SystemRoleQuery();
		Criteria criteria = example.createCriteria();
		if(systemRole.getId() != null){
			criteria.andIdEqualTo(systemRole.getId());
		}
		if(systemRole.getRoleid() != null){
			criteria.andRoleidEqualTo(systemRole.getRoleid());
		}
		if(StringUtils.isNotBlank(systemRole.getRolename())){
			criteria.andRolenameEqualTo(systemRole.getRolename());
		}
		if(StringUtils.isNotBlank(systemRole.getTerrace())){
			criteria.andTerraceEqualTo(systemRole.getTerrace());
		}
		if(systemRole.getUserid() != null){
			criteria.andUseridEqualTo(systemRole.getUserid());
		}
		List<SystemRole> list = this.systemRoleMapper.selectByExample(example );
		return list;
	}

	/* (non-Javadoc)
	 * @see com.pj.service.SystemRoleService#deleteSystemRoleById(java.lang.Integer)
	 */
	@Override
	public void deleteSystemRoleById(Integer id) {
		this.systemRoleMapper.deleteByPrimaryKey(id);
	}

}
