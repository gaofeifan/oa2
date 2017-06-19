package com.pj.service.impl.company;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.system.pojo.Company;
import com.pj.system.service.CompanyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class CompanyServiceImplTest2 {

	@Resource
	private CompanyService companyService;
	
	@Test
	public void testFindCompanyById() {
		Company company = this.companyService.selectByPrimaryKey(1);
		System.out.println(company);
	}

	@Test
	public void testUpdateCompany() {
		Company company = new Company();
		company.setId(2);
		company.setAddress("广州");
		this.companyService.updateByPrimaryKeySelective(company );
	}

	@Test
	public void testFindAllCompant() {
		List<Company> compant = this.companyService.selectAll();
		for (Company company : compant) {
			System.out.println(company);
		}
		
	}

	@Test
	public void testIsDelete() {
		this.companyService.deleteByPrimaryKey(2);		
	}
	

}
