package com.pj.config.template;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
import com.pj.message.service.MessageContentUserService;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:43:30
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public class FormMessageTemplate extends MessageTemplate {

	private MessageContent messageContent;
	
	private Set<Integer> ids;
	
	@Autowired
	private MessageContentService messageContentService;
	
	@Autowired
	private MessageContentUserService messageContentUserService;
	
	@Override
	protected MessageContent addMessageContent() {
		return messageContent;
	}

	@Override
	protected Set<Integer> addMessageViewers() {
		return ids;
	}

	public void addMessageContent(MessageContent messageContent) {
		this.messageContent = messageContent;
	}

	public void addMessageViewers(Set<Integer> ids) {
		this.ids = ids;
	}

	@Override
	protected MessageContentUserService getMessageContentUserService() {
		return messageContentUserService;
	}

	@Override
	protected MessageContentService getMessageContentService() {
		return messageContentService;
	}
	
	
	
	
}
