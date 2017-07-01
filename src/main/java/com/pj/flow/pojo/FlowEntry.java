package com.pj.flow.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pj.system.pojo.Salary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table(name="flow_entry")
@ApiModel
public class FlowEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

	
	@Column
	private Integer applyId;
	//申请人
	@Column
	private String username;
	
	@Column
    private String number;

    @ApiModelProperty(value = "招聘表id")
    @Column
    private Integer recruitId;

    @ApiModelProperty(value = "入职姓名")
    @Column
    private String name;

    @ApiModelProperty(value = "性别")
    @Column
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    @Column
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @Column
    private String email;

    @ApiModelProperty(value = "入职日期")
    @Column
    private Date entryDate;

    @ApiModelProperty(value = "试用期")
    @Column
    private String probation;

    @ApiModelProperty(value = "服务年份")
    @Column
    private String serviceYears;

    @ApiModelProperty(value = "备注")
    @Column
    private String remark;

    @ApiModelProperty(value = "背景调查表url")
    @Column
    private String checkUrl;

    @ApiModelProperty(value = "简历url")
    @Column
    private String resumeUrl;

    @ApiModelProperty(value = "应聘人员登记表url")
    @Column
    private String registerUrl;

    @ApiModelProperty(value = "入职状态")
    @Column
    private Integer state;
    
    @ApiModelProperty(value = "申请结果")
    @Column
    private Integer result;

    @ApiModelProperty(value = "工资信息(json格式[{'totalSalary(总工资)':'111','baseSalary(基本工资)':'10','postSalary(岗位工资)':'1','performanceSalary(绩效工资)':'200','reimbursement(报销金额)':'200','lunchAllowance(午餐补贴)':'200','communicationAllowance(通讯补贴)':'200','fullHours(全勤)':'200','salaryType':(1(实习))},{'totalSalary(总工资)':'111','baseSalary(基本工资)':'10','postSalary(岗位工资)':'1','performanceSalary(绩效工资)':'200','reimbursement(报销金额)':'200','lunchAllowance(午餐补贴)':'200','communicationAllowance(通讯补贴)':'200','fullHours(全勤)':'200','salaryType':(2(试用))},{'totalSalary(总工资)':'111','baseSalary(基本工资)':'10','postSalary(岗位工资)':'1','performanceSalary(绩效工资)':'200','reimbursement(报销金额)':'200','lunchAllowance(午餐补贴)':'200','communicationAllowance(通讯补贴)':'200','fullHours(全勤)':'200','salaryType':(3(转正))}])")
    @Transient
    private String salaryJson;
    
    @Column
    private Integer status;
    
    @Column
    private Date applyDate;
    
    @Transient
    private List<Salary> salarys;

    //查询使用
    @Transient
    private String offerRange;
    @Transient
    private String leaderName;
    @Transient
    private String companyName;
    @Transient
    private String dempName;
    @Transient
    private Integer dempId;
    @Transient
    private String postName;
    @Transient
    private String applyDateStr;
    
    public String getSalaryJson() {
		return salaryJson;
	}

	public void setSalaryJson(String salaryJson) {
		this.salaryJson = salaryJson;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	public Integer getDempId() {
		return dempId;
	}

	public void setDempId(Integer dempId) {
		this.dempId = dempId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getOfferRange() {
		return offerRange;
	}

	public void setOfferRange(String offerRange) {
		this.offerRange = offerRange;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDempName() {
		return dempName;
	}

	public void setDempName(String dempName) {
		this.dempName = dempName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public List<Salary> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<Salary> salarys) {
		this.salarys = salarys;
	}

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

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getProbation() {
        return probation;
    }

    public void setProbation(String probation) {
        this.probation = probation == null ? null : probation.trim();
    }

    public String getServiceYears() {
        return serviceYears;
    }

    public void setServiceYears(String serviceYears) {
        this.serviceYears = serviceYears == null ? null : serviceYears.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCheckUrl() {
        return checkUrl;
    }

    public void setCheckUrl(String checkUrl) {
        this.checkUrl = checkUrl == null ? null : checkUrl.trim();
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl == null ? null : resumeUrl.trim();
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public void setRegisterUrl(String registerUrl) {
        this.registerUrl = registerUrl == null ? null : registerUrl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	@Override
	public String toString() {
		return "FlowEntry [id=" + id + ", number=" + number + ", recruitId=" + recruitId + ", name=" + name + ", sex="
				+ sex + ", phone=" + phone + ", email=" + email + ", entryDate=" + entryDate + ", probation="
				+ probation + ", serviceYears=" + serviceYears + ", remark=" + remark + ", checkUrl=" + checkUrl
				+ ", resumeUrl=" + resumeUrl + ", registerUrl=" + registerUrl + ", state=" + state + ", status="
				+ status + ", salarys=" + salarys + ", offerRange=" + offerRange + ", leaderName=" + leaderName
				+ ", companyName=" + companyName + ", dempName=" + dempName + ", postName=" + postName + "]";
	}
    
    
}