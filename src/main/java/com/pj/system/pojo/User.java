package com.pj.system.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Table(name="t_user")
public class User implements Serializable {
	@ApiModelProperty(value = "密码", required = false)
	@Transient
	private String password;	

	@ApiModelProperty(value = "用户id", required = false)
	@Id
	private Integer id;

    /**
     * 用户编号
     */
	@ApiModelProperty(value = "用户编号", required = false)
	@Column(name="number")
    private String number;

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
     * 档案编号
     */
	@Column(name="filenumber")
	@ApiModelProperty(value = "档案编号", required = false)
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
     * 转正薪水  加密
     */
	@ApiModelProperty(value = "转正薪水  加密", required = false)
	@Column(name="regularpay")
    private String regularpay;

    /**
     * 试用薪水  加密
     */
	@Column(name="probationpay")
	@ApiModelProperty(value = "试用薪水  加密", required = false)
    private String probationpay;

    /**
     * 地址
     */
	@Column(name="address")
	@ApiModelProperty(value = "地址", required = false)
    private String address;

    /**
     * 部门id
     */
	@Column(name="dempid")
	@ApiModelProperty(value = "部门id", required = false)
    private Integer dempid;

    /**
     * 出生时间
     */
	@Column(name="birthdate")
	@ApiModelProperty(value = "出生时间", required = false)
    private Date birthdate;

    /**
     * 试用期终止时间
     */
	@Column(name="pbspdate")
	@ApiModelProperty(value = "试用期终止时间", required = false)
    private Date pbspdate;

    /**
     * 合同终止时间
     */
	@Column(name="comppdate")
	@ApiModelProperty(value = "合同终止时间", required = false)
    private Date comppdate;

    /**
     * 是否发放合同 1是 0否
     */
	@Column(name="iscompact")
	@ApiModelProperty(value = "是否发放合同 1是 0否", required = false)
    private Integer iscompact;

    /**
     * 是否开通今目标 1是 0否
     */
	@Column(name="isnowtarget")
	@ApiModelProperty(value = "是否开通今目标 1是 0否", required = false)
    private Integer isnowtarget;

    /**
     * 邮箱
     */
	@Column(name="email")
	@ApiModelProperty(value = "邮箱", required = false)
    private String email;

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
     * 籍贯
     */
	@Column(name="nativeplace")
	@ApiModelProperty(value = "籍贯", required = false)
    private String nativeplace;

    /**
     * 户口性质
     */
	@Column(name="alnature")
	@ApiModelProperty(value = "户口性质", required = false)
    private String alnature;

    /**
     * 学历
     */
	@Column(name="edubg")
	@ApiModelProperty(value = "学历", required = false)
    private String edubg;

    /**
     * 学校
     */
	@Column(name="school")
	@ApiModelProperty(value = "学校", required = false)
    private String school;

    /**
     * 是否全日制 1是0否
     */
	@Column(name="isfulltime")
	@ApiModelProperty(value = "是否全日制 1是0否", required = false)
    private Integer isfulltime;

    /**
     * 开户银行
     */
	@Column(name="depositbank")
	@ApiModelProperty(value = "开户银行", required = false)
    private String depositbank;

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
     * 职级id
     */
	@Column(name="rankid")
	@ApiModelProperty(value = "职级id", required = false)
    private Integer rankid;

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
     * 角色编号
     */
	@Column(name="roleid")
	@ApiModelProperty(value = "角色编号", required = false)
    private Integer roleid;

    /**
     * 是否删除 0未删除  1已删除
     */
	@Column(name="isdelete")
	@ApiModelProperty(value = "是否删除 0未删除  1已删除", required = false)
    private Integer isdelete;

    /**
     * 激活状态  1已激活 0已离职
     */
	@Column(name="isstatus")
	@ApiModelProperty(value = "激活状态  1已激活 0已离职", required = false)
    private Integer isstatus;

    /**
     * 企业外键只用来查询
     */
	@Column(name="companyid")
	@ApiModelProperty(value = "企业外键只用来查询", required = false)
    private Integer companyid;

    /**
     * 是否为新社保 1 是 0否
     */
	@Column(name="newsecurity")
	@ApiModelProperty(value = "是否为新社保 1 是 0否", required = false)
    private Integer newsecurity;

    /**
     * 是否有社保卡   1 是 0否
     */
	@Column(name="issecurity")
	@ApiModelProperty(value = "是否有社保卡   1 是 0否", required = false)
    private Integer issecurity;

    /**
     * 	合同类型		1劳动合同   2 实习合同
     */
	@Column(name="labelcompacttype")
	@ApiModelProperty(value = "合同类型		1劳动合同  0  实习合同", required = false)
    private Integer labelcompacttype;

	/**
	 * 	用工性质 0 试用 1 实习 2正式
	 */
	@Column(name="worktype")
	@ApiModelProperty(value = "用工性质 0 试用 1 实习 2正式", required = false)
	private Integer worktype;

	/**
	 * 	是否转正 0 为   1以
	 */
	@ApiModelProperty(value = "是否转正 0 为   1以", required = false)
	@Column(name="isregular")
	private Integer isregular;
	
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
   
    //查询使用
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
     * 	单号
     */
	@Transient
    private String applyNumber;
    
    /**
     * 公司名称
     */
	@Transient
    private String companyname;
	@Transient
    private String postname;
	@Transient
    private String rolename;
	@Transient
    private String rankname;
    
    /**
     * 	消息查询
     */
	@Transient
	@ApiModelProperty(value = "请假类型（用于消息查询）", required = false)
    private String leaveType;
	@Transient
	@ApiModelProperty(value = "请假时间（用于消息查询）", required = false)
    private Date leaveHours;
	@ApiModelProperty(value = "请假原因（用于消息查询）", required = false)
	@Transient
    private String leaveReason;
	@Transient
	@ApiModelProperty(value = "消息类型（用于消息查询）", required = false)
    private String type;

	@ApiModelProperty(value = "转正时间（用于消息查询）", required = false)
	@Column(name="regulardate")
    private Date regularDate;
	@ApiModelProperty(value = "异动详情（用于消息查询）", required = false)
	@Transient
    private String changeDetails;
	@ApiModelProperty(value = "异动时间（用于消息查询）", required = false)
	@Transient
    private Date changeDate;
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
     * 领导的id
     */
	@Transient
	private Integer leaderid;
	@ApiModelProperty(value = "ssoId", required = false)
	@Column(name="ssoId")
    private Integer ssoId;
	

	@ApiModelProperty(value = "openid", required = false)
	private String openid;
    /**
     * 	分页
     */
	@Transient
    protected Integer pageNo = 1;
	@Transient
    protected Integer startRow;
	@Transient
    protected Integer pageSize = 10;
    
	
    
    public User() {
		super();
	}

	public User(String email) {
		super();
		this.email = email;
	}

	public User(String username, Integer isdelete , Date hiredate) {
		this.username = username;
		this.isdelete = isdelete;
		this.hiredate = hiredate;
	}

	public User(Integer id, String openid) {
		super();
		this.id = id;
		this.openid = openid;
	}

	public User(Integer id, String openid,String phone)  {
		super();
		this.id = id;
		this.openid = openid;
		this.phone = phone;
	}

	public User(Integer id, Integer positionid, Integer isdelete) {
		super();
		this.id = id;
		this.positionid = positionid;
		this.isdelete = isdelete;
	}

	public User(Integer id, String accessToken, String weChatName, String openid) {
		this.id = id;
		this.accessToken = accessToken;
		this.weChatName = weChatName;
		this.openid = openid;
	}

	public User(Integer postid, Integer isdelete) {
		super();
		this.postid = postid;
		this.isdelete = isdelete;
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

	public Integer getWorktype() {
		return worktype;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public String getSystemRoleName() {
		return systemRoleName;
	}

	public void setSystemRoleName(String systemRoleName) {
		this.systemRoleName = systemRoleName;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	public Date getLeaveHours() {
		return leaveHours;
	}

	public void setLeaveHours(Date leaveHours) {
		this.leaveHours = leaveHours;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public void setWorktype(Integer worktype) {
		this.worktype = worktype;
	}

	public String getRolename() {
		return rolename;
	}
	

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	public Date getRegularDate() {
		return regularDate;
	}

	public String getChangeDetails() {
		return changeDetails;
	}

	public void setChangeDetails(String changeDetails) {
		this.changeDetails = changeDetails;
	}

	public void setRegularDate(Date regularDate) {
		this.regularDate = regularDate;
	}
	  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getRankname() {
		return rankname;
	}

	public void setRankname(String rankname) {
		this.rankname = rankname;
	}

	public Integer getSsoId() {
		return ssoId;
	}

	public void setSsoId(Integer ssoId) {
		this.ssoId = ssoId;
	}


	public Integer getIsregular() {
		return isregular;
	}

	public void setIsregular(Integer isregular) {
		this.isregular = isregular;
	}

	public String getPostname() {
		return postname;
	}


	public void setPostname(String postname) {
		this.postname = postname;
	}


	public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }
    
	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public Integer getLeaderid() {
		return leaderid;
	}

	public void setLeaderid(Integer leaderid) {
		this.leaderid = leaderid;
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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getFilenumber() {
        return filenumber;
    }

    public void setFilenumber(String filenumber) {
        this.filenumber = filenumber == null ? null : filenumber.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
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
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdentityproof() {
        return identityproof;
    }

    public void setIdentityproof(String identityproof) {
        this.identityproof = identityproof == null ? null : identityproof.trim();
    }

    public String getRegularpay() {
        return regularpay;
    }

    public void setRegularpay(String regularpay) {
        this.regularpay = regularpay == null ? null : regularpay.trim();
    }

    public String getProbationpay() {
        return probationpay;
    }

    public void setProbationpay(String probationpay) {
        this.probationpay = probationpay == null ? null : probationpay.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDempid() {
        return dempid;
    }

    public void setDempid(Integer dempid) {
        this.dempid = dempid;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
    public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
	 @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	public Date getPbspdate() {
        return pbspdate;
    }

    public void setPbspdate(Date pbspdate) {
        this.pbspdate = pbspdate;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
    public Date getComppdate() {
		return comppdate;
	}


	public void setComppdate(Date comppdate) {
		this.comppdate = comppdate;
	}

	public Integer getIscompact() {
        return iscompact;
    }

    public void setIscompact(Integer iscompact) {
        this.iscompact = iscompact;
    }
    
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getIsnowtarget() {
        return isnowtarget;
    }

    public void setIsnowtarget(Integer isnowtarget) {
        this.isnowtarget = isnowtarget;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
    public Date getLeavedate() {
		return leavedate;
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

	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}


	public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public String getAlnature() {
        return alnature;
    }

    public void setAlnature(String alnature) {
        this.alnature = alnature == null ? null : alnature.trim();
    }

    public String getEdubg() {
        return edubg;
    }

    public void setEdubg(String edubg) {
        this.edubg = edubg == null ? null : edubg.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getIsfulltime() {
        return isfulltime;
    }

    public void setIsfulltime(Integer isfulltime) {
        this.isfulltime = isfulltime;
    }

    public String getDepositbank() {
        return depositbank;
    }

    public void setDepositbank(String depositbank) {
        this.depositbank = depositbank == null ? null : depositbank.trim();
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard == null ? null : bankcard.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Integer getRankid() {
        return rankid;
    }

    public void setRankid(Integer rankid) {
        this.rankid = rankid;
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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getIsstatus() {
        return isstatus;
    }

    public void setIsstatus(Integer isstatus) {
        this.isstatus = isstatus;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getNewsecurity() {
        return newsecurity;
    }

    public void setNewsecurity(Integer newsecurity) {
        this.newsecurity = newsecurity;
    }

    public Integer getIssecurity() {
        return issecurity;
    }

    public void setIssecurity(Integer issecurity) {
        this.issecurity = issecurity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


	public Integer getLabelcompacttype() {
		return labelcompacttype;
	}


	public void setLabelcompacttype(Integer labelcompacttype) {
		this.labelcompacttype = labelcompacttype;
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

	@Override
	public String toString() {
		return "User [password=" + password + ", id=" + id + ", number=" + number + ", username=" + username + ", sex="
				+ sex + ", filenumber=" + filenumber + ", hiredate=" + hiredate + ", phone=" + phone
				+ ", identityproof=" + identityproof + ", regularpay=" + regularpay + ", probationpay=" + probationpay
				+ ", address=" + address + ", dempid=" + dempid + ", birthdate=" + birthdate + ", pbspdate=" + pbspdate
				+ ", comppdate=" + comppdate + ", iscompact=" + iscompact + ", isnowtarget=" + isnowtarget + ", email="
				+ email + ", leavedate=" + leavedate + ", nation=" + nation + ", nativeplace=" + nativeplace
				+ ", alnature=" + alnature + ", edubg=" + edubg + ", school=" + school + ", isfulltime=" + isfulltime
				+ ", depositbank=" + depositbank + ", bankcard=" + bankcard + ", contacts=" + contacts + ", rankid="
				+ rankid + ", positionid=" + positionid + ", postid=" + postid + ", roleid=" + roleid + ", isdelete="
				+ isdelete + ", isstatus=" + isstatus + ", companyid=" + companyid + ", newsecurity=" + newsecurity
				+ ", issecurity=" + issecurity + ", labelcompacttype=" + labelcompacttype + ", worktype=" + worktype
				+ ", isregular=" + isregular + ", positionname=" + positionname + ", dempname=" + dempname
				+ ", companyname=" + companyname + ", postname=" + postname + ", rolename=" + rolename + ", rankname="
				+ rankname + ", leaderid=" + leaderid + ", ssoId=" + ssoId + ", pageNo=" + pageNo + ", startRow="
				+ startRow + ", pageSize=" + pageSize + "]";
	}
}