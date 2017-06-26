package com.pj.config.template;

import java.util.List;

import com.pj.message.pojo.MessageContent;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:43:30
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class FormMessageTemplate extends MessageTemplate {

	private MessageContent messageContent;
	
	private List<Integer> ids;
	
	@Override
	protected MessageContent addMessageContent() {
		return messageContent;
	}

	@Override
	protected List<Integer> addMessageViewers() {
		return ids;
	}

	public void addMessageContent(MessageContent messageContent) {
		this.messageContent = messageContent;
	}

	public void addMessageViewers(List<Integer> ids) {
		this.ids = ids;
	}
	

	
	
}
