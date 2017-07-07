package com.pj.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
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
		Boolean flag = true;
		Example example = new Example(Company.class);
		example.createCriteria().andCondition(" pId = "+companyId).andCondition(" isdelete = 0 ");
		List<Company> companys = this.companyMapper.selectByExample(example );
		Demp record = new Demp();
		record.setCompanyid(companyId);
		record.setIsdelete(0);
		List<Demp> demps = this.dempService.select(record );
		if(companys.size() > 0 || demps.size() > 0){
			flag = false;
		}
		return flag;
	}

	/**
	 * 	根据用户权限查询所负责公司信息
	 */
	@Override
	public List<Company> getByAuthUser(Integer userId) {
		return companyMapper.getByAuthUser(userId);
	}

	/**
	 * 	根据id获取父节节点
	 */
	@Override
	public Company selectParentCompanyById(int id) {
		return this.companyMapper.selectParentCompanyById(id);
	}

	/**
	 * 	查询公司跟人事权限
	 *	@author 	GFF
	 *	@date		2017年7月5日下午7:30:58	
	 * 	@return
	 */
	@Override
	public List<Company> selectCompanyByPersonnelAuthority() {
		List<Company> companys = this.selectNotDeleteALL();
		List<Company> deleteCompanys = new ArrayList<>();
		for (Company company : companys) {
			List<Demp> dempList = this.dempService.selectDempByPersonnelAuthority(company.getId());
			if(dempList.size() == 0){
				deleteCompanys.add(company);
			}
		}
		for (Company company : deleteCompanys) {
			companys.remove(company);
		}
		return companys;
	}

	@Override
	public List<Company> selectByUserid(Integer userId, Integer menuid) {
		return this.companyMapper.selectByUserid(userId,menuid);
	}
	
	

}
