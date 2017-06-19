package com.pj.config.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 	自定义拦截器
 *	@author		GFF
 *	@date		2017年2月9日下午5:00:07
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class LoginInterceptor implements HandlerInterceptor{

	private String outsideOfficeHoursPage;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//	判断当前用户登录后才可以请求接口
		Cookie[] cookies = request.getCookies();
		//jsession
		if(null != cookies && cookies.length > 0){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("CSESSIONID")){
					return true;
				}else{
					response.sendRedirect(outsideOfficeHoursPage);
					return false;
				}
			}
		}
		response.sendRedirect(outsideOfficeHoursPage);
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 *	@author 	GFF
	 *	@date		2017年2月9日下午5:14:10	
	 * 	@param arg0
	 */
	public void setOutsideOfficeHoursPage(String outsideOfficeHoursPage) {
		 this.outsideOfficeHoursPage = outsideOfficeHoursPage;  
		
	}

	public String getOutsideOfficeHoursPage() {
		return outsideOfficeHoursPage;
	}

}
