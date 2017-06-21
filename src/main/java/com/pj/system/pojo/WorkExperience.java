package com.pj.system.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月19日下午6:48:53
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="t_work_experience")
public class WorkExperience {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	@Column
	private Date workTime;
	
	@Column
	private String relation;
	
	@Column
	private String grossWage;
	
	@Column
	private String reasonLeave;
	
	@Column
	private Integer userId;
	
	@Column
	private String certifierAndPhone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getGrossWage() {
		return grossWage;
	}

	public void setGrossWage(String grossWage) {
		this.grossWage = grossWage;
	}

	public String getReasonLeave() {
		return reasonLeave;
	}

	public void setReasonLeave(String reasonLeave) {
		this.reasonLeave = reasonLeave;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCertifierAndPhone() {
		return certifierAndPhone;
	}

	public void setCertifierAndPhone(String certifierAndPhone) {
		this.certifierAndPhone = certifierAndPhone;
	}
}