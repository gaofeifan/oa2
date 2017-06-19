package com.pj.controller.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.system.pojo.Company;
import com.pj.system.service.CompanyService;
import com.pj.utils.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class CompanyControllerTest {

	
	@Resource
	private CompanyService companyService;
	
	@Test
	public void test() {
		Company company = new Company();
		company.setName("物流公司");
		company.setAddress("北京市望京来广营");
		company.setNumber("BT111");
		this.companyService.insertSelective(company );
		
	}
	@Test
	public void test2() throws ParseException {
		
	}
	public static void main(String[] args) throws ParseException {
		List<Date> lsit = new ArrayList<>();
		lsit.add(new Date());
		@SuppressWarnings("unused")
		int num = 1;
		if(true){
			lsit.clear();
			num = 0;
		}
		CompanyControllerTest comp = new CompanyControllerTest();
		comp.test3();
		
	}
	public void test3() throws ParseException{
		float num = 10;
		int startHour = 17;
		int endHour = 14;
		
		float hour = 0;
		if(startHour >= 9 && startHour <= 12){
			hour = endHour - startHour;
			if(endHour >= 13 && endHour <= 18){
				hour -= 1;
			}
		}else if(startHour > 12){
			if(endHour >= 13 && endHour <= 18){
				hour = endHour - startHour;
			}else if(endHour <= 12){
				int between = DateUtils.hourBetween(DateUtils.updateDateByCondition(new Date(), 2017, 1, 5, startHour), DateUtils.updateDateByCondition(new Date(), 2017, 1, 6, endHour), DateUtils.DATE_TIME_FORMAT);
				hour = between - 15;
				num -=1;
			}
		}
		System.out.println(hour);
		hour /= 8;
		System.out.println(  hour+num);
	}
	
	@SuppressWarnings("unused")
	public void hour(){
		int startHour = 17;
		int endHour = 10;
		float hour = 0;
		float totalHours = 0;
		if(startHour >= 9 && startHour <= 12){
			hour = endHour - startHour;
			if(endHour >= 13 && endHour <= 18){
				hour -= 1;
			}
		}else{
			hour = endHour - startHour;
		}
		hour /= 8;
		totalHours =  hour;
	}

}
