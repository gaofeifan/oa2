package com.pj.system.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年7月4日下午8:00:19
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="t_education")
public class Education {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	@Column
	private String learningTime;
	@Column
	private String campus;
	@Column
	private String specialty;
	@Column
	private String education;
	@Column
	private Integer isFullTime;
	@Column
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLearningTime() {
		return learningTime;
	}
	public void setLearningTime(String learningTime) {
		this.learningTime = learningTime;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer getIsFullTime() {
		return isFullTime;
	}
	public void setIsFullTime(Integer isFullTime) {
		this.isFullTime = isFullTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
