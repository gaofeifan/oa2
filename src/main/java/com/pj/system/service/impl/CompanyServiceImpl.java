package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.pojo.Company;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class CompanyServiceImpl extends AbstractBaseServiceImpl<Company, Integer> implements CompanyService {

	@Resource
	private CompanyMapper companyMapper;

	@Resource 
	private DempService dempService;
	
	@Resource
	private UserService userService;
	
	
	@Override
	public MyMapper<Company> getMapper() {
		return companyMapper;
	}

	/**
	 * 根据名称查询
	 */
	@Override
	public Integer selectByName(String companyName) {
		Example example = new Example(Company.class);
		example.createCriteria().andCondition(" name LIKE ","%"+companyName+"%" ).andCondition(" isdelete = 0");
		List<Company> list = this.companyMapper.selectByExample(example);
		return list.size() != 0 ?  list.get(0).getId() :null;
	}

	/**
	 * 查询是否可以删除
	 */
	@Override
	public Boolean isDeleteCompany(Integer companyId) {
		Boolean flag = false;
		Example example = new Example(Company.class);
		example.createCriteria().andCondition(" pId = "+companyId).andCondition(" isdelete = 0 ");
//		List<Company> companys = this.companyMapper.selectByExample(example );
//		List<User> users = this.userService.findUserByDempIdAndCompanyId(null, companyId);
//		List<Demp> demps = this.dempService.selectByCompanyId(companyId);
//		if(companys.size() == 0 && users.size() == 0 && demps.size() == 0){
//			flag = true;
//		}else{
//			flag =false;
//		}
		return flag;
	}

}
