package com.pj.config.template;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.system.pojo.Message;
import com.pj.system.pojo.MessageUser;
import com.pj.system.pojo.User;
import com.pj.system.service.MessageService;
import com.pj.system.service.MessageUserService;
import com.pj.utils.enums.MessageType;


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
	private MessageService messageService;
	@Autowired
	private MessageUserService messageUserService;
	
	protected List<User> staffList;
	
	protected String messageContent;
	
	protected MessageType messageType;
	
	protected int userId;
	
	private MessageUser messageUser;
	
	public final void messageNotification(){
		//	添加通知员工
		addInformStaff();
		//	添加通知内容
		addMessageContentAndType(); 
		//	添加记录的用户
		addUser();
		//	保存消息
		insertMessage();
	}

	protected abstract void addUser();

	protected abstract void addMessageContentAndType();

	private void insertMessage() {
		Message message = new Message();
		message.setContent(messageContent);
		message.setDate(new Date());
		message.setTitle("【"+messageType.getDesc()+"】");
		message.setType(messageType.getValue());
		message.setUserId(userId);
		for (User user : staffList) {
			//	保存通知人员
			addUsers(user,message.getId());
		}
	}

	private void addUsers(User user , int messageId) {
		messageUser = new MessageUser();
		messageUser.setMessageId(messageId);
		messageUser.setUserId(user.getId());
		this.messageUserService.insertMessageUser(messageUser);
	}

	protected abstract void addInformStaff();
	
	
	
}
