package com.pj.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthAgencyMapper;
import com.pj.auth.pojo.AuthAgency;
import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.UserService;

/**
 *	@author		GFF
 *	@date		2017年6月22日下午3:44:49
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class AuthAgencyServiceImpl extends AbstractBaseServiceImpl<AuthAgency, Integer> implements AuthAgencyService {

	@Autowired
	private AuthAgencyMapper authAgencyMapper;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private UserService userService;
	
	@Override
	public MyMapper<AuthAgency> getMapper() {
		return authAgencyMapper;
	}

	@Override
	public AuthAgency selectApplicantAgency(int companyId, int dempId, int isCompanyLeader, int isDempLeader) {

		if(isCompanyLeader == 1){
			isCompanyLeader(companyId);
		
			
		}else if(isDempLeader == 1){
			
		}
		return null;
	}

	private void isCompanyLeader(int companyId) {
		Company company = this.companyService.selectParentCompanyById(companyId);
		User record = new User();
		record.setCompanyid(company.getId());
		record.setIsCompanyBoss(1);
		record.setIsdelete(0);
		List<User> list = this.userService.select(record );
	}
	
	
	


}
