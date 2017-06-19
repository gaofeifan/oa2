package com.pj.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pj.system.mapper.UserMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class LambdaDemoTest {

	@Resource
	private UserMapper usermapper;
	@Test
	public void test(){
	
//		List list = new ArrayList<>();
//		List postlist = new ArrayList<>();
//		List comList = new ArrayList<>();
//		comList.add(1);
//		comList.add(2);
//		comList.add(3);
//		comList.add(4);
//		comList.add(5);
//		comList.add(6);
//		comList.add(7);
//		
//		postlist.add(1);
//		postlist.add(2);
//		postlist.add(3);
//		postlist.add(8);
//		postlist.add(9);
//		postlist.add(10);
//		postlist.add(11);
//	
//		
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		for(int i = 0;i<100;i++){
//			int y = i%5;
//			int z = i%7;
//			Integer iy = (Integer)list.get(y);
//			Integer postid = (Integer)postlist.get(z);
//			Integer c= (Integer)list.get(y);
//			String suffix =  ".com";
//			int prefix = i;
//			String email = i +suffix;
//			String phone = "15128262444";
//			//12
//			//String password = "c20ad4d76fe97759aa27a0c99bff6710";
//			String username = "赵"+i;
//			
//			User user = new User();
//			user.setDempid(iy);
//			user.setCompanyid(c);
//			user.setPostid(postid);
//			user.setCompanyid(iy);
//			user.setRankid(iy);
//			user.setEmail(email);
//			user.setPhone(phone);
//			//user.setPassword(password);
//			user.setUsername(username);
//			user.setRoleid(iy);
//			user.setAddress("望京"+i);
//			user.setSex("女");
//			user.setNation("汉");
//			user.setNativeplace("河北省保定市");
//			user.setAlnature("城镇");
//			user.setEdubg("本科");
//			user.setSchool("北京大学");
//			user.setDepositbank("交通银行");
//			usermapper.insertSelective(user);
//			
//		
//		}
	
}
}
