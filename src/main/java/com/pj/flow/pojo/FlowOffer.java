package com.pj.flow.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pj.utils.DateUtils;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author GFF
 * @date 2017年6月26日下午6:56:58
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class FlowOffer {

	/**
	 * email
	 */
//	@ApiModelProperty(value = "邮箱", notes = "<email>")
	private String email;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名", notes = "<username>")
	private String username;

	/**
	 * 公司
	 */
	@ApiModelProperty(value = "公司", notes = "<company>")
	private String company;

	/**
	 * 岗位职级
	 */
	@ApiModelProperty(value = "岗位职级", notes = "<postName>")
	private String postName;

	/**
	 * 汇报对象
	 */
	@ApiModelProperty(value = "汇报对象", notes = "<pUserName>")
	private String pUserName;

	/**
	 * 工作部门
	 */
	@ApiModelProperty(value = "工作部门", notes = "<dempName>")
	private String dempName;

	/**
	 * 工作地点
	 */
	@ApiModelProperty(value = "工作地点", notes = "<workAddress>")
	private String workAddress;

	/**
	 * 基本工资 试用期内每月税前
	 */
	@ApiModelProperty(value = "基本工资 试用期内每月税前", notes = "<basePretaxSalaryForTrialPeriod>")
	private String basePretaxSalaryForTrialPeriod;

	/**
	 * 基本工资 试用期内每月税前 大写
	 */
	@ApiModelProperty(value = "基本工资  试用期内每月税前  大写", notes = "<basePretaxSalaryForTrialPeriodUpper>")
	private String basePretaxSalaryForTrialPeriodUpper;

	/**
	 * 基本工资 转正后每月税前
	 */
	@ApiModelProperty(value = "基本工资   转正后每月税前", notes = "<pre_taxSalary>")
	private String pre_taxSalary;

	/**
	 * 基本工资 转正后每月税前 大写
	 */
	@ApiModelProperty(value = "基本工资    转正后每月税前 大写", notes = "<pre_taxSalaryUpper>")
	private String pre_taxSalaryUpper;

	/**
	 * 岗位工资 试用期内每月税前
	 */
	@ApiModelProperty(value = " 岗位工资 试用期内每月税前", notes = "<theSalaryOfTheUsePeriod>")
	private String theSalaryOfTheUsePeriod;

	/**
	 * 岗位工资 试用期内每月税前 大写
	 */
	@ApiModelProperty(value = "岗位工资 试用期内每月税前 大写", notes = "<theSalaryOfTheUsePeriodUpper>")
	private String theSalaryOfTheUsePeriodUpper;

	/**
	 * 岗位工资 转正后每月税前
	 */
	@ApiModelProperty(value = "岗位工资    转正后每月税前", notes = "<postAPostSalary>")
	private String postAPostSalary;

	/**
	 * 岗位工资 转正后每月税前 大写
	 */
	@ApiModelProperty(value = "岗位工资    转正后每月税前 大写", notes = "<postAPostSalaryUpper>")
	private String postAPostSalaryUpper;

	/**
	 * 绩效工资 试用期每月税前
	 */
	@ApiModelProperty(value = "绩效工资  试用期每月税前", notes = "<probationPerformanceSalary>")
	private String probationPerformanceSalary;

	/**
	 * 绩效工资 试用期每月税前 大写
	 */
	@ApiModelProperty(value = "绩效工资  试用期每月税前 大写", notes = "<probationPerformanceSalaryUpper>")
	private String probationPerformanceSalaryUpper;

	/**
	 * 绩效工资 转正后每月税前
	 */
	@ApiModelProperty(value = "绩效工资  转正后每月税前", notes = "<transferPerformancePay>")
	private String transferPerformancePay;

	/**
	 * 绩效工资 转正后每月税前 大写
	 */
	@ApiModelProperty(value = "绩效工资  转正后每月税前   大写", notes = "<transferPerformancePayUpper>")
	private String transferPerformancePayUpper;

	/**
	 * 午餐补贴
	 */
	@ApiModelProperty(value = "午餐补贴", notes = "<lunchAllowance>")
	private String lunchAllowance;

	/**
	 * 通讯补贴
	 */
	@ApiModelProperty(value = "通讯补贴", notes = "<phoneAllowance>")
	private String phoneAllowance;

	/**
	 * 考勤工资
	 */
	@ApiModelProperty(value = "考勤工资", notes = "<presentAtDutyEveryDay>")
	private String presentAtDutyEveryDay;

	/**
	 * ，试用期为
	 */
	@ApiModelProperty(value = "试用期为", notes = "<probation>")
	private String probation;

	/**
	 * 服务期限
	 */
	@ApiModelProperty(value = "服务期限", notes = "<serviceHours>")
	private String serviceHours;

	/**
	 * 入职时间
	 */
	@ApiModelProperty(value = "入职时间", notes = "<hiredate>")
	private Date hiredate;

	/**
	 * 时分
	 */
	@ApiModelProperty(value = "时分", notes = "<timeDivision>")
	private String timeDivision;

	/**
	 * 联系人
	 */
	@ApiModelProperty(value = "联系人", notes = "<contacts>")
	private String contacts;

	/**
	 * 联系电话
	 */
	@ApiModelProperty(value = "联系电话(当前操作人员)", notes = "<contactsPhone>")
	private String contactsPhone;

	/**
	 * 联系电话
	 */
	@ApiModelProperty(value = "联系电话(用户)", notes = "<phone>")
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getpUserName() {
		return pUserName;
	}

	public void setpUserName(String pUserName) {
		this.pUserName = pUserName;
	}

	public String getDempName() {
		return dempName;
	}

	public void setDempName(String dempName) {
		this.dempName = dempName;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getBasePretaxSalaryForTrialPeriod() {
		return basePretaxSalaryForTrialPeriod;
	}

	public void setBasePretaxSalaryForTrialPeriod(String basePretaxSalaryForTrialPeriod) {
		this.basePretaxSalaryForTrialPeriod = basePretaxSalaryForTrialPeriod;
	}

	public String getBasePretaxSalaryForTrialPeriodUpper() {
		return basePretaxSalaryForTrialPeriodUpper;
	}

	public void setBasePretaxSalaryForTrialPeriodUpper(String basePretaxSalaryForTrialPeriodUpper) {
		this.basePretaxSalaryForTrialPeriodUpper = basePretaxSalaryForTrialPeriodUpper;
	}

	public String getPre_taxSalary() {
		return pre_taxSalary;
	}

	public void setPre_taxSalary(String pre_taxSalary) {
		this.pre_taxSalary = pre_taxSalary;
	}

	public String getPre_taxSalaryUpper() {
		return pre_taxSalaryUpper;
	}

	public void setPre_taxSalaryUpper(String pre_taxSalaryUpper) {
		this.pre_taxSalaryUpper = pre_taxSalaryUpper;
	}

	public String getTheSalaryOfTheUsePeriod() {
		return theSalaryOfTheUsePeriod;
	}

	public void setTheSalaryOfTheUsePeriod(String theSalaryOfTheUsePeriod) {
		this.theSalaryOfTheUsePeriod = theSalaryOfTheUsePeriod;
	}

	public String getTheSalaryOfTheUsePeriodUpper() {
		return theSalaryOfTheUsePeriodUpper;
	}

	public void setTheSalaryOfTheUsePeriodUpper(String theSalaryOfTheUsePeriodUpper) {
		this.theSalaryOfTheUsePeriodUpper = theSalaryOfTheUsePeriodUpper;
	}

	public String getPostAPostSalary() {
		return postAPostSalary;
	}

	public void setPostAPostSalary(String postAPostSalary) {
		this.postAPostSalary = postAPostSalary;
	}

	public String getPostAPostSalaryUpper() {
		return postAPostSalaryUpper;
	}

	public void setPostAPostSalaryUpper(String postAPostSalaryUpper) {
		this.postAPostSalaryUpper = postAPostSalaryUpper;
	}

	public String getProbationPerformanceSalary() {
		return probationPerformanceSalary;
	}

	public void setProbationPerformanceSalary(String probationPerformanceSalary) {
		this.probationPerformanceSalary = probationPerformanceSalary;
	}

	public String getProbationPerformanceSalaryUpper() {
		return probationPerformanceSalaryUpper;
	}

	public void setProbationPerformanceSalaryUpper(String probationPerformanceSalaryUpper) {
		this.probationPerformanceSalaryUpper = probationPerformanceSalaryUpper;
	}

	public String getTransferPerformancePay() {
		return transferPerformancePay;
	}

	public void setTransferPerformancePay(String transferPerformancePay) {
		this.transferPerformancePay = transferPerformancePay;
	}

	public String getTransferPerformancePayUpper() {
		return transferPerformancePayUpper;
	}

	public void setTransferPerformancePayUpper(String transferPerformancePayUpper) {
		this.transferPerformancePayUpper = transferPerformancePayUpper;
	}

	public String getLunchAllowance() {
		return lunchAllowance;
	}

	public void setLunchAllowance(String lunchAllowance) {
		this.lunchAllowance = lunchAllowance;
	}

	public String getPhoneAllowance() {
		return phoneAllowance;
	}

	public void setPhoneAllowance(String phoneAllowance) {
		this.phoneAllowance = phoneAllowance;
	}

	public String getPresentAtDutyEveryDay() {
		return presentAtDutyEveryDay;
	}

	public void setPresentAtDutyEveryDay(String presentAtDutyEveryDay) {
		this.presentAtDutyEveryDay = presentAtDutyEveryDay;
	}

	public String getProbation() {
		return probation;
	}

	public void setProbation(String probation) {
		this.probation = probation;
	}

	public String getServiceHours() {
		return serviceHours;
	}

	public void setServiceHours(String serviceHours) {
		this.serviceHours = serviceHours;
	}
	@JsonFormat(pattern=DateUtils.DATE_FORMAT,timezone = "GMT+8") 
	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getTimeDivision() {
		return timeDivision;
	}

	public void setTimeDivision(String timeDivision) {
		this.timeDivision = timeDivision;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FlowOffer [username=" + username + ", company=" + company + ", postName="
				+ postName + ", pUserName=" + pUserName + ", dempName=" + dempName + ", workAddress=" + workAddress
				+ ", basePretaxSalaryForTrialPeriod=" + basePretaxSalaryForTrialPeriod
				+ ", basePretaxSalaryForTrialPeriodUpper=" + basePretaxSalaryForTrialPeriodUpper + ", pre_taxSalary="
				+ pre_taxSalary + ", pre_taxSalaryUpper=" + pre_taxSalaryUpper + ", theSalaryOfTheUsePeriod="
				+ theSalaryOfTheUsePeriod + ", theSalaryOfTheUsePeriodUpper=" + theSalaryOfTheUsePeriodUpper
				+ ", postAPostSalary=" + postAPostSalary + ", postAPostSalaryUpper=" + postAPostSalaryUpper
				+ ", probationPerformanceSalary=" + probationPerformanceSalary + ", probationPerformanceSalaryUpper="
				+ probationPerformanceSalaryUpper + ", transferPerformancePay=" + transferPerformancePay
				+ ", transferPerformancePayUpper=" + transferPerformancePayUpper + ", lunchAllowance=" + lunchAllowance
				+ ", phoneAllowance=" + phoneAllowance + ", presentAtDutyEveryDay=" + presentAtDutyEveryDay
				+ ", probation=" + probation
				+ ", serviceHours=" + serviceHours + ", hiredate=" + hiredate + ", timeDivision=" + timeDivision
				+ ", contacts=" + contacts + ", contactsPhone=" + contactsPhone + ", phone=" + phone + "]";
	}

}
