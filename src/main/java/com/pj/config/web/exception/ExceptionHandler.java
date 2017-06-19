package com.pj.config.web.exception;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
public class ExceptionHandler implements HandlerExceptionResolver {
	@SuppressWarnings("unused")
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
			String msg;
			String message = "资源出现异常";
	
			ModelAndView modelAndView = new ModelAndView();
			// 判断异常类型
			if (exception instanceof CustomException) {
				if(exception instanceof NullPointerException){
					message = "输入空值异常";
				}
				if(exception instanceof FileNotFoundException){
					message = "文件未找到异常";
				}
				if(exception instanceof SQLException){
					message = "查询资源异常";	
				}
				
				
				// 如果是自定义异常,则取异常信息
				msg = exception.getMessage();
				System.out.println(msg);
			} else {
				// 如果是运行时异常,则取错误堆栈,获取堆栈中的错误信息
				StringWriter s = new StringWriter();
				PrintWriter printWriter = new PrintWriter(s);
				exception.printStackTrace(printWriter);
				msg = s.toString();
			}
			System.out.println(msg);
			// 把错误信息发给相关人员,邮件,短信等方式
			// 返回错误页面,给用户显示错误信息
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
			
		

		
	}

}
