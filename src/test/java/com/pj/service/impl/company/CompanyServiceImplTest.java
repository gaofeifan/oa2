package com.pj.service.impl.company;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pj.config.base.properties.ManageProperties;
import com.pj.config.base.tool.NumberTool;
import com.pj.system.pojo.Company;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.UserService;
import com.pj.utils.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class CompanyServiceImplTest {

	@Autowired
	private NumberTool numberUtils;
	@Resource
	private ManageProperties baseProperties;
	
	@Resource
	private CompanyService companyService;
	@Resource
	private DempService dempService;
	@Resource
	private UserService userService;
	
	@Test
	public void test() {
		List<Company> selectAll = this.companyService.selectAll();
		System.out.println(selectAll.size());
	}
	@Test
	public void test2(){
		Date date = this.userService.selectByemail("gaofeifan@pj-l.com").getHiredate();
		System.out.println(DateUtils.convert(date, null));
	}
	@Test
	public void test3(){
		String number = numberUtils.getSingleNumber(dempService, 7);
		System.out.println(number);
	}
	@Test
	public void test4(){
		
	}
	
	
	

}

