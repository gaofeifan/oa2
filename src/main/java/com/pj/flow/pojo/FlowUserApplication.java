package com.pj.flow.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午11:51:37
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="flow_user_application")
public class FlowUserApplication {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	/**
	 * 	申请人id
	 */
	@Column
	private Integer userId;
	
	/**
	 * 	申请表id
	 */
	@Column
	private Integer fromId;
	
	/**
	 * 	申请类型
	 */
	@Column
	private Integer applicationId;
	
	/**
	 * 	申请人姓名
	 */
	@Column
	private String applicant;
	
	/**
	 * 	申请人部门
	 */
	@Column
	private String applicantDempName;
	
	/**
	 * 	申请时间
	 */
	@Column
	private String applicationTime;
	
	/**
	 * 	职位名称
	 */
	@Column
	private String applicantPostName;

	/**
	 * 	表单中具体的人员
	 */
	@Column
	private String username;
	
	/**
	 * 	申请单号
	 */
	@Column
	private String applicantNumber;

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

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getApplicantDempName() {
		return applicantDempName;
	}

	public void setApplicantDempName(String applicantDempName) {
		this.applicantDempName = applicantDempName;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getApplicantPostName() {
		return applicantPostName;
	}

	public void setApplicantPostName(String applicantPostName) {
		this.applicantPostName = applicantPostName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApplicantNumber() {
		return applicantNumber;
	}

	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
	}
	
}
