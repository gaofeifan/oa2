package com.pj.flow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.pj.BaseTest;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
import com.pj.flow.service.FlowEntryService;
import com.pj.utils.SendEmailUtils;

/**
 *	@author		GFF
 *	@date		2017年6月29日下午7:07:53
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class FlowEntryServiceImplTest extends BaseTest{

	@Resource
	private FlowEntryService flowEntryService;
	
	@Test
	public void testFindOffer(){
		FlowOffer flowOffer = this.flowEntryService.selectOfferDetailsByApplyIdAndEmail(1, "hujingjing@pj-l.com");
		FlowEntry selectById = this.flowEntryService.selectById(1);
		String string = SendEmailUtils.getResourceTemp("/temp/offer2");
		
		System.out.println(flowOffer);
			
	}
	
}
