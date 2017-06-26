package com.pj.config.template;

import java.util.ArrayList;
import java.util.List;

import com.pj.config.base.constant.MessageType;
import com.pj.message.pojo.MessageContent;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:43:30
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class EntryMessageTemplate extends MessageTemplate {

	private MessageContent messageContent;
	
	private List<Integer> messageViewer = new ArrayList<>();
	
	@Override
	protected MessageContent addMessageContent() {
		messageContent.setTitle(MessageType.ENTRY_MES.getDesc());
		messageContent.setType(MessageType.ENTRY_MES.getValue());
		return messageContent;
	}

	@Override
	protected List<Integer> addMessageViewer() {
		return messageViewer;
	}

	public void addMessageViewer(Integer userId) {
		messageViewer.add(userId);
	}
	
	
	

}
