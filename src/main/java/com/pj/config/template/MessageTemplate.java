package com.pj.config.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.message.pojo.MessageContent;
import com.pj.message.pojo.MessageContentUser;
import com.pj.message.service.MessageContentService;
import com.pj.message.service.MessageContentUserService;


/**
 *	@author		GFF
 *	@date		2017年6月16日下午6:43:16
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public abstract class MessageTemplate {
	
	@Autowired
	private MessageContentService messageContentService;
	
	@Autowired
	private MessageContentUserService messageContentUserService;
		
	public final void messageNotification(){
		inserMessage(addMessageContent());
	}

	private void inserMessage(MessageContent messageContent) {
		messageContentService.insertSelective(messageContent);
		for (Integer userId : addMessageViewer()) {
			messageContentUserService.insertSelective(new MessageContentUser(userId, messageContent.getId(), 0));
		}
	}

	protected abstract MessageContent addMessageContent();

	protected abstract List<Integer> addMessageViewer();
	
	
	
}
