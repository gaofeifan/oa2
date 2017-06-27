package com.pj.system.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

@Table(name="t_user")
public class User implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = false)
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;

    /**
     * 用户名
     */
	@Column(name="username")
	@ApiModelProperty(value = "用户名", required = false)
    private String username;

    /**
     * 性别 
     */
	@Column(name="sex")
	@ApiModelProperty(value = "性别 ", required = false)
    private String sex;

    /**
     * 工号
     */
	@Column(name="filenumber")
	@ApiModelProperty(value = "工号", required = false)
    private String filenumber;

    /**
     * 入职时间
     */
	@Column(name="hiredate")
	@ApiModelProperty(value = "入职时间", required = false)
    private Date hiredate;

    /**
     * 手机号
     */
	@Column(name="phone")
	@ApiModelProperty(value = "手机号", required = false)
    private String phone;

    /**
     * 身份证
     */
	@Column(name="identityproof")
	@ApiModelProperty(value = "身份证", required = false)
    private String identityproof;

	/**
	 * 身份证地址
	 */
	@Column(name="identityproof_address")
	@ApiModelProperty(value = "身份证地址", required = false)
	private String identityproofAddress;

    /**
     * 居住地址
     */
	@Column(name="residential_address")
	@ApiModelProperty(value = "居住地址", required = false)
    private String residentialAddress;

    /**
     * 部门id
     */
	@Column(name="dempid")
	@ApiModelProperty(value = "部门id", required = false)
    private Integer dempid;

    /**
     * 试用期
     */
	@Column(name="probation")
	@ApiModelProperty(value = "试用期", required = false)
    private Date probation;
	
	/**
	 * 合同开始日期
	 */
	@Column(name="contract_start_time")
	@ApiModelProperty(value = "合同终止时间", required = false)
	private Date contractStartTime;

    /**
     * 合同终止时间
     */
	@Column(name="contract_stop_time")
	@ApiModelProperty(value = "合同终止时间", required = false)
    private Date contractStopTime;

    /**
     * 是否开通钉钉 1是 0否
     */
	@Column(name="is_ding_talk")
	@ApiModelProperty(value = "是否开通钉钉 1是 0否", required = false)
    private Integer isDingTalk;

    /**
     * 邮箱
     */
	@Column(name="company_email")
	@ApiModelProperty(value = "邮箱", required = false)
    private String companyEmail;

    /**
     * 离职时间
     */
	@Column(name="leavedate")
	@ApiModelProperty(value = "离职时间", required = false)
    private Date leavedate;

    /**
     * 民族
     */
	@Column(name="nation")
	@ApiModelProperty(value = "民族", required = false)
    private String nation;

    /**
     * 户口性质
     */
	@Column(name="alnature")
	@ApiModelProperty(value = "户口性质", required = false)
    private String alnature;

    /**
     * 学校
     */
	@Column(name="school")
	@ApiModelProperty(value = "学校", required = false)
    private String school;

    /**
     * 是否全日制 1是0否
     */
	@Column(name="is_fulltime")
	@ApiModelProperty(value = "是否全日制 1是0否", required = false)
    private Integer isFulltime;

    /**
     * 开户银行
     */
	@Column(name="deposit_bank")
	@ApiModelProperty(value = "开户银行", required = false)
    private String depositBank;

    /**
     * 银行卡
     */
	@Column(name="bankcard")
	@ApiModelProperty(value = "银行卡", required = false)
    private String bankcard;

    /**
     * 紧急联系人及电话
     */
	@Column(name="contacts")
	@ApiModelProperty(value = "紧急联系人及电话", required = false)
    private String contacts;

    /**
     * 职位id
     */
	@Column(name="positionid")
	@ApiModelProperty(value = "职位id", required = false)
    private Integer positionid;

    /**
     * 岗位序号
     */
	@Column(name="postid")
	@ApiModelProperty(value = "岗位序号", required = false)
    private Integer postid;

    /**
     * 是否删除 0未删除  1已删除
     */
	@Column(name="isdelete")
	@ApiModelProperty(value = "是否删除 0未删除  1已删除", required = false)
    private Integer isdelete;

    /**
     * 激活状态  1已激活 0已离职
     */
	@Column(name="is_status")
	@ApiModelProperty(value = "激活状态  1已激活 0已离职", required = false)
    private Integer isStatus;

    /**
     * 企业外键只用来查询
     */
	@Transient
	@ApiModelProperty(value = "企业外键只用来查询", required = false)
    private Integer companyid;

	/**
	 * 是否为新参保 1 是 0否
	 */
	@Column(name="is_new_ginseng")
	@ApiModelProperty(value = "是否为新参保 1 是 0否", required = false)
	private Integer isNewGinseng;

    /**
     * 是否有社保卡   1 是 0否
     */
	@Column(name="is_social_security_cards")
	@ApiModelProperty(value = "是否有社保卡   1 是 0否", required = false)
    private Integer isSocialSecurityCards;

    /**
     * 	合同类型		1劳动合同   2 实习合同
     */
	@Column(name="contract_type")
	@ApiModelProperty(value = "合同类型		1劳动合同  0  实习合同", required = false)
    private Integer contractType;

	/**
	 * 	微信token
	 */
	@Column(name="access_token")
	@ApiModelProperty(value = "微信token", required = false)
	private String accessToken;
	/**
	 * 	微信昵称
	 */
	@Column(name="we_chat_name")
	@ApiModelProperty(value = "微信昵称", required = false)
	private String weChatName;

	/**
	 * 	子女状况 0 未 1 已
	 */
	@Column(name="child_status")
	@ApiModelProperty(value = "子女状况 0 未 1 已", required = false)
	private String childStatus;

	/**
	 * 	婚姻状况 0 未 1 已 2离异
	 */
	@Column(name="marital_status")
	@ApiModelProperty(value = "婚姻状况 0 未 1 已 2离异", required = false)
	private String maritalStatus;

	/**
	 * 	学历
	 */
	@Column(name="education")
	@ApiModelProperty(value = "学历", required = false)
	private String education;
	
	/**
	 * 	申请转正时间
	 */
	@Column(name="apply_regular_date")
	@ApiModelProperty(value = "申请转正时间", required = false)
	private Date applyRegularDate;

	/**
	 * 	合同期限
	 */
	@Column(name="contract_period")
	@ApiModelProperty(value = "合同期限", required = false)
	private Integer contractPeriod;

	/**
	 * 	个人邮箱
	 */
	@Column(name="i_email")
	@ApiModelProperty(value = "个人邮箱", required = false)
	private String iEmail;
	/**
	 * 	工作地址
	 */
	@Column(name="work_address")
	@ApiModelProperty(value = "工作地址", required = false)
	private String workAddress;
	
    /**
     * 职位名称
     */
	@Transient
    private String positionname;
    /**
     * 部门名称
     */
	@Transient
	private String dempname;
    /**
     * 公司名称
     */
	@Transient
    private String companyname;
	@Transient
    private String postname;
	@Transient
	private String replaceOffer;
    
    /**
     * 	消息查询
     */
	
	@Transient
	@ApiModelProperty(value = "系统编号（用于条件查询	   :该项未填写则系统角色无法进行查询）", required = false)
    private String terrace;
	@ApiModelProperty(value = "系统角色（用于条件查询  0 :(为查询该系统所有的用户信息)  null :(为只查询未建立关联的用户信息)  其他 :(查询用户指定角色的用户信息)）", required = false)
	@Transient
    private Integer systemRoleid;
	@ApiModelProperty(value = "系统角色名称（用于数据回现）", required = false)
	@Transient
	private String systemRoleName;
  
	/**
     * 	上级id
     */
	@Column
	@ApiModelProperty(value = "上级id", required = false)
	private Integer pid;
	
	@ApiModelProperty(value = "ssoId", required = false)
	@Column(name="sso_id")
    private Integer ssoId;
	

	@ApiModelProperty(value = "openid", required = false)
	@Column(name="open_id")
	private String openid;
	
	/**
	 * 	是否有公积金 1是 0否
	 */
	@ApiModelProperty(value = "是否有公积金 1是 0否", required = false)
	@Column(name="is_accumulation_fund")
	private Integer isAccumulationFund; 
	/**
	 * 	社保基数
	 */
	@ApiModelProperty(value = "社保基数", required = false)
	@Column(name="social_security_cardinal_number")
	private String socialSecurityCardinalNumber;

	/**
	 *  公积金基数
	 */
	@ApiModelProperty(value = "公积金基数", required = false)
	@Column(name="accumulation_fund_cardinal_number")
	private String accumulationFundCardinalNumber;
	
	/**
	 *  社保缴纳地址
	 */
	@ApiModelProperty(value = "社保缴纳地址", required = false)
	@Column(name="social_security_payment_address")
	private String socialSecurityPaymentAddress;
	
	/**
	 *  是否为部门负责人 1 是 0 否
	 */
	@ApiModelProperty(value = "是否为部门负责人 1 是 0 否", required = false)
	@Column(name="is_department_head")
	private Integer isDepartmentHead;
	
	/**
	 *  是否为公司负责人 1 是 0 否
	 */
	@ApiModelProperty(value = "是否为公司负责人 1 是 0 否", required = false)
	@Column(name="is_company_boss")
	private Integer isCompanyBoss;

	/**
	 *  公司邮箱密码
	 */
	@ApiModelProperty(value = "公司邮箱密码", required = false)
	@Column(name="company_email_password")
	private String companyEmailPassword;

	/**
	 * 	薪资
	 */
	@Transient
	private List<Salary> salarys;
	
	/**
	 * 	家庭成员
	 */
	@Transient
	private List<FamilyMember> familyMembers;
	
	/**
	 * 	工作经历
	 */
	@Transient
	private List<WorkExperience> workExperiences;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFilenumber() {
		return filenumber;
	}

	public void setFilenumber(String filenumber) {
		this.filenumber = filenumber;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentityproof() {
		return identityproof;
	}

	public void setIdentityproof(String identityproof) {
		this.identityproof = identityproof;
	}

	public String getIdentityproofAddress() {
		return identityproofAddress;
	}

	public void setIdentityproofAddress(String identityproofAddress) {
		this.identityproofAddress = identityproofAddress;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public Integer getDempid() {
		return dempid;
	}

	public void setDempid(Integer dempid) {
		this.dempid = dempid;
	}

	public Date getProbation() {
		return probation;
	}

	public void setProbation(Date probation) {
		this.probation = probation;
	}

	public Date getContractStartTime() {
		return contractStartTime;
	}

	public void setContractStartTime(Date contractStartTime) {
		this.contractStartTime = contractStartTime;
	}

	public Date getContractStopTime() {
		return contractStopTime;
	}

	public void setContractStopTime(Date contractStopTime) {
		this.contractStopTime = contractStopTime;
	}

	public Integer getIsDingTalk() {
		return isDingTalk;
	}

	public void setIsDingTalk(Integer isDingTalk) {
		this.isDingTalk = isDingTalk;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public Date getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAlnature() {
		return alnature;
	}

	public void setAlnature(String alnature) {
		this.alnature = alnature;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}


	public Integer getIsFulltime() {
		return isFulltime;
	}

	public void setIsFulltime(Integer isFulltime) {
		this.isFulltime = isFulltime;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getBankcard() {
		return bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Integer getPositionid() {
		return positionid;
	}

	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getIsNewGinseng() {
		return isNewGinseng;
	}

	public void setIsNewGinseng(Integer isNewGinseng) {
		this.isNewGinseng = isNewGinseng;
	}

	public Integer getIsSocialSecurityCards() {
		return isSocialSecurityCards;
	}

	public void setIsSocialSecurityCards(Integer isSocialSecurityCards) {
		this.isSocialSecurityCards = isSocialSecurityCards;
	}

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getWeChatName() {
		return weChatName;
	}

	public void setWeChatName(String weChatName) {
		this.weChatName = weChatName;
	}

	public String getChildStatus() {
		return childStatus;
	}

	public void setChildStatus(String childStatus) {
		this.childStatus = childStatus;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getApplyRegularDate() {
		return applyRegularDate;
	}

	public void setApplyRegularDate(Date applyRegularDate) {
		this.applyRegularDate = applyRegularDate;
	}

	public Integer getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(Integer contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getiEmail() {
		return iEmail;
	}

	public void setiEmail(String iEmail) {
		this.iEmail = iEmail;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public String getDempname() {
		return dempname;
	}

	public void setDempname(String dempname) {
		this.dempname = dempname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getTerrace() {
		return terrace;
	}

	public void setTerrace(String terrace) {
		this.terrace = terrace;
	}

	public Integer getSystemRoleid() {
		return systemRoleid;
	}

	public void setSystemRoleid(Integer systemRoleid) {
		this.systemRoleid = systemRoleid;
	}

	public String getSystemRoleName() {
		return systemRoleName;
	}

	public void setSystemRoleName(String systemRoleName) {
		this.systemRoleName = systemRoleName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSsoId() {
		return ssoId;
	}

	public void setSsoId(Integer ssoId) {
		this.ssoId = ssoId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getIsAccumulationFund() {
		return isAccumulationFund;
	}

	public void setIsAccumulationFund(Integer isAccumulationFund) {
		this.isAccumulationFund = isAccumulationFund;
	}

	public String getSocialSecurityCardinalNumber() {
		return socialSecurityCardinalNumber;
	}

	public void setSocialSecurityCardinalNumber(String socialSecurityCardinalNumber) {
		this.socialSecurityCardinalNumber = socialSecurityCardinalNumber;
	}

	public String getAccumulationFundCardinalNumber() {
		return accumulationFundCardinalNumber;
	}

	public void setAccumulationFundCardinalNumber(String accumulationFundCardinalNumber) {
		this.accumulationFundCardinalNumber = accumulationFundCardinalNumber;
	}

	public String getSocialSecurityPaymentAddress() {
		return socialSecurityPaymentAddress;
	}

	public void setSocialSecurityPaymentAddress(String socialSecurityPaymentAddress) {
		this.socialSecurityPaymentAddress = socialSecurityPaymentAddress;
	}

	public Integer getIsDepartmentHead() {
		return isDepartmentHead;
	}

	public void setIsDepartmentHead(Integer isDepartmentHead) {
		this.isDepartmentHead = isDepartmentHead;
	}

	public Integer getIsCompanyBoss() {
		return isCompanyBoss;
	}

	public void setIsCompanyBoss(Integer isCompanyBoss) {
		this.isCompanyBoss = isCompanyBoss;
	}

	public List<Salary> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<Salary> salarys) {
		this.salarys = salarys;
	}

	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public List<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	public String getReplaceOffer() {
		return replaceOffer;
	}

	public void setReplaceOffer(String replaceOffer) {
		this.replaceOffer = replaceOffer;
	}
	
	public String getCompanyEmailPassword() {
		return companyEmailPassword;
	}

	public void setCompanyEmailPassword(String companyEmailPassword) {
		this.companyEmailPassword = companyEmailPassword;
	}
	
}