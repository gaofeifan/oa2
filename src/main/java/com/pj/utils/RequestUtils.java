package com.pj.utils;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 处理Request 生成CSESSIONID
 * @author lx
 *
 */
public class RequestUtils {

	private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class); 
	public static String getCSESSIONID(HttpServletRequest request,HttpServletResponse response){
		//1：获取Cookie
		
		Cookie[] cookies = request.getCookies();
		//jsession
		if(null != cookies && cookies.length > 0){
			for (Cookie cookie : cookies) {
				//2:从Cookie中获取CSESSIONID
				logger.debug(cookies.toString());
				if(cookie.getName().equals("CSESSIONID")){
					//3:如果有 直接使用
					logger.info("【RequestUtils.getCSESSIONID】 COOKIE = "+ cookie.getValue());
					return cookie.getValue();
				}
			}
		}
		logger.debug("没有从 response中获取到cookie值 从新生成并返回到客户端");
		//4:判断如果 没有  创建一个CSESSIONID  保存CSESSIONID到Cookie中  保存COokie写回浏览器 
		String csessionid = UUID.randomUUID().toString().replaceAll("-", "");
		//Cookie
		Cookie cookie = new Cookie("CSESSIONID",csessionid);
		//设置路径
		cookie.setPath("/");
		//设置Cookie的存活时间    立即消失 0         关闭浏览器 消失-1    到时间再消失>0    前提：没有清理Cooke
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		return csessionid;
	}
}
