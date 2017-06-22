package com.pj.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.FamilyMemberMapper;
import com.pj.system.pojo.FamilyMember;
import com.pj.system.service.FamilyMemberService;

/**
 *	@author		GFF
 *	@date		2017年6月21日上午10:16:51
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class FamilyMemberServiceImpl extends AbstractBaseServiceImpl<FamilyMember, Integer>
		implements FamilyMemberService {

	@Resource
	private FamilyMemberMapper familyMemberMapper;
	
	@Override
	public MyMapper<FamilyMember> getMapper() {
		return familyMemberMapper;
	}


}
