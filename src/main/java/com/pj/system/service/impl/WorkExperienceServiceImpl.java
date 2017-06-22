package com.pj.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.WorkExperienceMapper;
import com.pj.system.pojo.WorkExperience;
import com.pj.system.service.WorkExperienceService;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午10:24:51
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class WorkExperienceServiceImpl extends AbstractBaseServiceImpl<WorkExperience, Integer>
		implements WorkExperienceService {

	@Resource
	private WorkExperienceMapper workExperienceMapper;
	
	@Override
	public MyMapper<WorkExperience> getMapper() {
		return workExperienceMapper;
	}


}
