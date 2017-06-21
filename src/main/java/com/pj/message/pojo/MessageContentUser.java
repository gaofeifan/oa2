package com.pj.message.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:01:03
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="message_content_user")
public class MessageContentUser {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	@Column
	private Integer userId;
	
	@Column
	private Integer messageId;

	@Column
	private Integer isFind;
	
	public MessageContentUser() {}
	

	public MessageContentUser(Integer userId, Integer messageId, Integer isFind) {
		super();
		this.userId = userId;
		this.messageId = messageId;
		this.isFind = isFind;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getIsFind() {
		return isFind;
	}
	public void setIsFind(Integer isFind) {
		this.isFind = isFind;
	}
	
}
