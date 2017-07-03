package com.pj.flow.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;
import com.pj.flow.service.FlowEntryService;
import com.pj.utils.OfferUtils;
import com.pj.utils.SendEmailUtils;

/**
 *	@author		GFF
 *	@date		2017年6月29日下午7:07:53
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class FlowEntryServiceImplTest{

	@Autowired
	private FlowEntryService flowEntryService;
	
	@Test
	public void testFindOffer(){
		FlowOffer flowOffer = this.flowEntryService.selectOfferDetailsByApplyIdAndEmail(1, "hujingjing@pj-l.com");
		System.out.println(flowOffer);
//		String offerTemp = SendEmailUtils.getResourceTemp("/temp/offer2");
//		String string = OfferUtils.replaceOfferContent(offerTemp, flowOffer);
//		SendEmailUtils.sendMessage("gaofeifan@pj-l.com", "PJ.123456", "1315697146@qq.com", flowOffer.getCompany()+"offer", string, null);
			
	}
	
}
