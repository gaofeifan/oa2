package com.pj.system.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pj.utils.annotation.AES;

/**
 * 薪资表
 * @author GFF
 * @date 2017年6月19日上午11:12:07
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Table(name = "t_salary")
public class Salary {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 试用总额
	 */
	@AES
	@Column
	private String totalSalary;

	/**
	 * 试用报销金额
	 */
	@AES
	private String reimbursement;

	/**
	 * 试用基本工资
	 */
	@AES
	@Column
	private String baseSalary;

	/**
	 * 试用岗位工资
	 */
	@AES
	@Column
	private String postSalary;

	/**
	 * 试用绩效工资
	 */
	@AES
	@Column
	private String performanceSalary;

	/**
	 * 试用午餐补贴
	 */
	@AES
	private String lunchAllowance;

	/**
	 * 试用通讯补贴
	 */
	@AES
	@Column
	private String communicationAllowance;

	/**
	 * 试用全勤
	 */
	@AES
	@Column
	private String fullHours;

	/**
	 * 用户id
	 */
	@Column
	private Integer userId;

	/**
	 * 入职申请单id
	 */
	@Column
	private Integer entryId;

	/**
	 * 薪资类型 0 试用 1转正 2 实习
	 */
	@Column
	private Integer salaryType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(String reimbursement) {
		this.reimbursement = reimbursement;
	}

	public String getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getPostSalary() {
		return postSalary;
	}

	public void setPostSalary(String postSalary) {
		this.postSalary = postSalary;
	}

	public String getPerformanceSalary() {
		return performanceSalary;
	}

	public void setPerformanceSalary(String performanceSalary) {
		this.performanceSalary = performanceSalary;
	}

	public String getLunchAllowance() {
		return lunchAllowance;
	}

	public void setLunchAllowance(String lunchAllowance) {
		this.lunchAllowance = lunchAllowance;
	}

	public String getCommunicationAllowance() {
		return communicationAllowance;
	}

	public void setCommunicationAllowance(String communicationAllowance) {
		this.communicationAllowance = communicationAllowance;
	}

	public String getFullHours() {
		return fullHours;
	}

	public void setFullHours(String fullHours) {
		this.fullHours = fullHours;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(Integer salaryType) {
		this.salaryType = salaryType;
	}

}
