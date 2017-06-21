package com.pj.mapper.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	
	@Test
	public void test() {
		User user = this.userMapper.selectByPrimaryKey(2);
		System.out.println(user);
	}

	@Test
	public void test1() {
	}
	
	@Test
	public void test2(){
	}
	
	@Test
	public void test3(){
		User record = new User();
		record.setUsername("jerry2");
		record.setPhone("13888888888");
		this.userMapper.insertSelective(record );
	}
	
	
	public static Date dateConvert(String source){
		String replace = source.replace(".", "-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse;
		try {
			parse = sdf.parse(replace);
			return parse;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	@Test
	public static void main(String[] args) {
		Date date = dateConvert("2000.12.1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		System.out.println(format);
	}
	
	
	
}
