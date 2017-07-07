package com.pj.system.pojo;

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
	private String workTime;
	
	@Column
	private String duty;
	
	@Column
	private String grossWage;
	
	@Column
	private String reasonLeave;
	
	@Column
	private Integer userId;
	
	@Column
	private String certifierAndPhone;

	@Column
	private String workUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
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

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	@Override
	public String toString() {
		return "WorkExperience [id=" + id + ", workTime=" + workTime + ", duty=" + duty + ", grossWage=" + grossWage
				+ ", reasonLeave=" + reasonLeave + ", userId=" + userId + ", certifierAndPhone=" + certifierAndPhone
				+ ", workUnit=" + workUnit + "]";
	}
	
}
