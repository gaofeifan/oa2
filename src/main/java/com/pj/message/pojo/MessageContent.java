package com.pj.message.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午5:56:48
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="message_context")
public class MessageContent {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	@Column
	private String type;
	
	@Column
	private String title;
	
	@Column
	private Date applyTime;
	
	@Column
	private Integer applicatId;
	
	@Column
	private String applicatName;
	
	@Column
	private String applicatPosition;
	
	@Column
	private String applicatDemp;

	@Column
	private Integer notificationType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getApplicatId() {
		return applicatId;
	}

	public void setApplicatId(Integer applicatId) {
		this.applicatId = applicatId;
	}

	public String getApplicatName() {
		return applicatName;
	}

	public void setApplicatName(String applicatName) {
		this.applicatName = applicatName;
	}

	public String getApplicatPosition() {
		return applicatPosition;
	}

	public void setApplicatPosition(String applicatPosition) {
		this.applicatPosition = applicatPosition;
	}

	public String getApplicatDemp() {
		return applicatDemp;
	}

	public void setApplicatDemp(String applicatDemp) {
		this.applicatDemp = applicatDemp;
	}

	public Integer getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(Integer notificationType) {
		this.notificationType = notificationType;
	}
	
}
