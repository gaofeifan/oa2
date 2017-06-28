package com.pj.config.template;

import java.util.Set;

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
public abstract class MessageTemplate {
	
	public final void messageNotification(){
		inserMessage(addMessageContent());
	}

	private void inserMessage(MessageContent messageContent) {
		getMessageContentService().insertSelective(messageContent);
		for (Integer userId : addMessageViewers()) {
			getMessageContentUserService().insertSelective(new MessageContentUser(userId, messageContent.getId(), 0));
		}
	}



	protected abstract MessageContentUserService getMessageContentUserService();

	protected abstract MessageContentService getMessageContentService();

	protected abstract MessageContent addMessageContent();

	protected abstract Set<Integer> addMessageViewers();

	
}
