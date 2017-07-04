package com.pj.flow.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pj.config.base.constant.ApplyType;
import com.pj.flow.service.FlowApproveService;

/**
 *	@author		GFF
 *	@date		2017年7月3日下午6:12:35
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FlowApproveServiceImplTest{

	@Resource
	private FlowApproveService flowApproveService;
	
	@Test
	public void test(){
		this.flowApproveService.commitApprove(1, 2, null, 1, ApplyType.RECRUIT.getApplyType());
	}

}
