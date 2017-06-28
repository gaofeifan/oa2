package com.pj.message.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pj.BaseTest;
import com.pj.config.base.constant.MessageType;
import com.pj.config.base.constant.NotificationType;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.UserService;

/**
 *	@author		GFF
 *	@date		2017年6月27日下午3:13:16
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class MessageContentServiceImplTest extends BaseTest{

	@Autowired
	private MessageContentService messageContentService;
	@Autowired
	private UserService userService;
	@Autowired
	private DempService dempService;
	
	/**
	 * 	测试未审批的测试
	 *	@author 	GFF
	 *	@date		2017年6月27日下午3:16:26
	 */
	@Test
	public void testAddUnapprovedMessage(){
		User user = this.userService.selectByEamil("gaofeifan@pj-l.com");
		String names = this.dempService.selectDempParentNameById(user.getDempid());
		MessageContent content = new MessageContent();
		content.setApplicatId(user.getId());
		content.setApplicatPosition("主管及以下");
		content.setApplyTime(new Date());
		content.setTitle(MessageType.ENTRY_MES.getDesc());
		content.setType(MessageType.ENTRY_MES.getValue());
		content.setApplicatDemp(names);
		content.setApplicatId(user.getId());
		content.setApplicatName(user.getUsername());
		this.messageContentService.addUnapprovedMessage(content );
	}
	@Test
	public void testAddApprovedMessage(){
		User user = this.userService.selectByEamil("gaofeifan@pj-l.com");
		String names = this.dempService.selectDempParentNameById(user.getDempid());
		MessageContent content = new MessageContent();
		content.setApplicatId(user.getId());
		content.setApplicatPosition("主管及以下");
		content.setApplyTime(new Date());
		content.setTitle(MessageType.ENTRY_MES.getDesc());
		content.setType(MessageType.ENTRY_MES.getValue());
		content.setApplicatDemp(names);
		content.setApplicatId(user.getId());
		content.setApplicatName(user.getUsername());
		this.messageContentService.addApprovedMessage(content, 1);
	}
	@Test
	public void testSelectMessageAllByEamilAndNotificationType(){
		List<MessageContent> list = this.messageContentService.selectMessageAllByEamilAndNotificationType("hujingjing@pj-l.com", NotificationType.APPROVAL.getValue());
		for (MessageContent messageContent : list) {
			System.out.println(messageContent);
		}
	}
	
}
