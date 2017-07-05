package com.pj.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.EducationMapper;
import com.pj.system.pojo.Education;
import com.pj.system.service.EducationService;

/**
 *	@author		GFF
 *	@date		2017年7月5日上午9:28:16
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class EducationServiceImpl extends AbstractBaseServiceImpl<Education, Integer> implements EducationService {

	@Autowired
	private EducationMapper educationMapper;

	@Override
	public MyMapper<Education> getMapper() {
		return educationMapper;
	}


}
