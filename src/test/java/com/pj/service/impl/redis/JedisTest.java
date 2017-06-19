//package com.pj.service.impl.redis;
//
//import java.text.DecimalFormat;
//
//import java.util.Set;
//
//import javax.annotation.Resource;
//import javax.print.attribute.standard.NumberUp;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.pj.service.JedisService;
//import com.pj.service.impl.JedisServiceImpl;
//
//import redis.clients.jedis.Jedis;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations={"classpath:spring-config.xml"})
//public class JedisTest {
//	
//	@Resource
//	private JedisService jedisService;
//	
//	@Resource
//	private Jedis jedis;
//	
//	@Test
//	public void test1(){
//		this.jedis.append("RZ", "1111111");
//	}
//	@Test
//	public void test2(){
//		Long incr = this.jedis.incr("RZ");
//		String number = "";
//		String xxx = ""+incr;
//		if(xxx.length() != 7){
//			if(xxx.length() == 1){
//				number = "000000"+xxx;
//			}
//			else if(xxx.length() == 2){
//				number = "00000"+xxx;
//			}
//			else if(xxx.length() == 3){
//				number = "0000"+xxx;
//			}
//			else if(xxx.length() == 4){
//				number = "000"+xxx;
//			}
//			else if(xxx.length() == 5){
//				number = "00"+xxx;
//			}
//			else if(xxx.length() == 6){
//				number = "0"+xxx;
//			}
//		}
//		System.out.println(number);
//	}
//	@Test
//	public void test3(){
//		String string = this.jedis.get("RZ");
//		System.out.println(string);
//		
//	}
//	
//	@Test
//	public void test4(){
//		String string = this.jedis.set("number", "1");
//		System.out.println(string);
//	}
//	
//	@Test
//	public void test6(){
//		String string = this.jedis.get("number");
//		System.out.println(string);
//	}
//
//	@Test
//	public void test5(){
//		String number = this.jedisService.getNumber();
//		System.out.println(number);
//	}	
//	@Test
//	public void test7(){
//		String number = this.jedisService.getAccesstoken();
//		System.out.println(number);
//	}	
//	
//}
