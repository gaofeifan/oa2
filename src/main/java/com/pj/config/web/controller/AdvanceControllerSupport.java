package com.pj.config.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pj.config.base.pojo.PipelineContext;
import com.pj.config.base.pojo.SimplePipelineContext;

/**
 *	@author		GFF
 *	@date		2017年6月6日上午11:20:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class AdvanceControllerSupport {

	protected static Logger logger = Logger.getLogger(AdvanceControllerSupport.class);
	
	protected PipelineContext buildPipelineContent(){
		SimplePipelineContext pipelineContext = new SimplePipelineContext();
		pipelineContext.setRequest(getRequest());
		pipelineContext.setResponse(getResponse());
		return pipelineContext;
	}
	
	public HttpServletResponse getResponse() {
		return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse(); 
	}

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
