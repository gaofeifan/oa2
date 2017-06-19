package com.pj.flow.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午11:35:00
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="flow_action_log")
public class flowActionLog {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	/**
	 * 	状态
	 */
	private String status;
	
	/**
	 * 	操作时间
	 */
	private Date operationTime;
	
	/**
	 * 	申请单号
	 */
	private String applicationNumber;
	
	/**
	 * 	操作人员
	 */
	private String operationStaff;
	
	/**
	 * 	处理意见
	 */
	private String handlingSuggestion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getOperationStaff() {
		return operationStaff;
	}

	public void setOperationStaff(String operationStaff) {
		this.operationStaff = operationStaff;
	}

	public String getHandlingSuggestion() {
		return handlingSuggestion;
	}

	public void setHandlingSuggestion(String handlingSuggestion) {
		this.handlingSuggestion = handlingSuggestion;
	}
}
