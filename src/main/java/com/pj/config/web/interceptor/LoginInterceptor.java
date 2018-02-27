package com.pj.config.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * 
 * @author GFF
 * @date 2017年7月28日下午5:00:07
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class LoginInterceptor implements HandlerInterceptor {

	private static final String[] paths = new String[] { "/accountManage", "/accountSet", "/company", "/demp",
			"/Position", "/post", "/SystemRole", "/upload", "/user" };
	private String outsideOfficeHoursPage;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StringBuffer requestURL = request.getRequestURL();
		for (String path : paths) {
			if (requestURL.toString().contains(path)) {
				if (requestURL.toString().contains("/user")) {
					if (requestURL.toString().contains("/selectUserDetail.do")
							|| requestURL.toString().contains("/selectUserByUsername.do")
							|| requestURL.toString().contains("/findLoginUser.do")
							|| requestURL.toString().contains("/findUserByssoId.do")
							|| requestURL.toString().contains("/selectUserByCompanyIdAndPostId.do")
							|| requestURL.toString().contains("/selectPeopleWhoCopiedEmailByUsername.do")) {
						break;
					}
				}
				return true;
			}
		}
		// 判断当前用户登录后才可以请求接口
		Cookie[] cookies = request.getCookies();
		// jsession
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("CSESSIONID")) {
					return true;
				}
			}
	}
		response.sendRedirect(outsideOfficeHoursPage);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * @author GFF
	 * @date 2017年2月9日下午5:14:10
	 * @param arg0
	 */
	public void setOutsideOfficeHoursPage(String outsideOfficeHoursPage) {
		this.outsideOfficeHoursPage = outsideOfficeHoursPage;
	}

	public String getOutsideOfficeHoursPage() {
		return outsideOfficeHoursPage;
	}

}
