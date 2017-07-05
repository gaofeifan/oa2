package com.pj.flow.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table(name="flow_recruit")
@ApiModel
public class FlowRecruit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(hidden=true)
    private Integer id;

	@ApiModelProperty(value = "申请人id", required = false)
    private Integer applyId;

	@ApiModelProperty(value = "申请人姓名", required = false)
	private String username;
	
	@ApiModelProperty(value = "申请日期", required = false)
    private Date applyDate;

	@ApiModelProperty(value = "所属公司", required = false)
    private Integer companyId;

	@ApiModelProperty(value = "岗位id", required = false)
    private Integer postId;

	@ApiModelProperty(value = "部门id", required = false)
    private Integer dempId;

	@ApiModelProperty(value = "职位id", required = false)
    private Integer positionId;

	@ApiModelProperty(value = "是否是部门负责人(0:否,1:是)", required = false)
    private Integer isDempLeader;

	@ApiModelProperty(value = "是否是公司负责人(0:否,1:是)", required = false)
    private Integer isCompanyLeader;

	@ApiModelProperty(value = "招聘人数", required = false)
    private Integer needNum;

	@ApiModelProperty(value = "工作地点", required = false)
    private String workAddress;

	@ApiModelProperty(value = "招聘原因类型(1:战略类, 2:业务类, 3:替代类)", required = false)
    private Integer applyReasonType;
   
	@ApiModelProperty(value = "招聘原因子类型(11:业务板块增加,12:储备人力; 21:业务扩大,22:职能增加,23:业务类其他; 31:离职补充,32:现有人员替换,33:替换类补充)", required = false)
    private Integer applyReasonChildType;
    
	@ApiModelProperty(value = "招聘原因", required = false)
    private String applyReason;
    
	@ApiModelProperty(value = "替换人员id", required = false)
    private Integer replaceId;

	@ApiModelProperty(value = "招聘渠道(1:外部招聘, 2:内部竞聘, 3:内部推荐, 4:猎头)", required = false)
    private Integer channel;

	@ApiModelProperty(value = "性别（0:不限, 1:男, 2:女）", required = false)
    private Integer sex;

	@ApiModelProperty(value = "年龄", required = false)
    private String age;

	@ApiModelProperty(value = "学历(0:不限, 1:高中及以上, 2:专科及以上, 3:本科及以上, 4:硕士及以上, 5:博士及以上, )", required = false)
    private String education;

	@ApiModelProperty(value = "岗位职责", required = false)
    private String duty;

	@ApiModelProperty(value = "技术资格", required = false)
    private String technology;

	@ApiModelProperty(value = "专业知识", required = false)
    private String knowledge;

	@ApiModelProperty(value = "业务能力", required = false)
    private String businessAbility;

	@ApiModelProperty(value = "特殊能力", required = false)
    private String specialAbility;

	@ApiModelProperty(value = "工作经历", required = false)
    private String experience;

	@ApiModelProperty(value = "其他需求", required = false)
    private String otherDemand;

	@ApiModelProperty(value = "申请状态(1:招聘审批中,2:招聘已审批,3:入职审批中,4:入职已审批,5:已发offer,6:已建档)", required = false)
    private Integer state;

	@ApiModelProperty(value = "申请结果(1:招聘同意,2:招聘不同意,3:招聘暂停,4:招聘取消,5:入职同意,6:入职不同意,7:入职完结)", required = false)
    private Integer result;

	@ApiModelProperty(value = "入职人数", required = false)
    private Integer entryNum;

	@ApiModelProperty(value = "直属领导id", required = false)
    private Integer leaderId;

	@ApiModelProperty(value = "薪资范围", required = false)
    private String offerRange;

	@ApiModelProperty(value = "是否需要调查(是否背景调查(0:否，1:是))", required = false)
    private Integer isCheck;

	@ApiModelProperty(value = "删除状态(0:未删除,1:已删除)", required = false)
    private Integer status;
	
//	//招聘待办状态（1:招聘中,2:已提交,3:已暂停,4:已审批）
//	private Integer todoState;
    
    //查询使用
	@Transient
    private String replaceName;
	@Transient
    private String replaceOffer;
	@Transient
    private String leaderName;
	@Transient
    private String companyName;
	@Transient
    private Integer applyDempId;
	@Transient
    private String dempName;
	@Transient
    private String postName;
	@Transient
    private String positionName;
	@Transient
    private String applyDateStr;
	@Transient
    private String entryDateStr;
	@Transient
    private Integer entryId;

    public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public String getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public Integer getApplyDempId() {
		return applyDempId;
	}

	public void setApplyDempId(Integer applyDempId) {
		this.applyDempId = applyDempId;
	}

	public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReplaceName() {
		return replaceName;
	}

	public void setReplaceName(String replaceName) {
		this.replaceName = replaceName;
	}

	public String getReplaceOffer() {
		return replaceOffer;
	}

	public void setReplaceOffer(String replaceOffer) {
		this.replaceOffer = replaceOffer;
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

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getDempId() {
        return dempId;
    }

    public void setDempId(Integer dempId) {
        this.dempId = dempId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getIsDempLeader() {
        return isDempLeader;
    }

    public void setIsDempLeader(Integer isDempLeader) {
        this.isDempLeader = isDempLeader;
    }

    public Integer getIsCompanyLeader() {
        return isCompanyLeader;
    }

    public void setIsCompanyLeader(Integer isCompanyLeader) {
        this.isCompanyLeader = isCompanyLeader;
    }

    public Integer getNeedNum() {
        return needNum;
    }

    public void setNeedNum(Integer needNum) {
        this.needNum = needNum;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }


    public Integer getApplyReasonType() {
		return applyReasonType;
	}

	public void setApplyReasonType(Integer applyReasonType) {
		this.applyReasonType = applyReasonType;
	}

	public Integer getApplyReasonChildType() {
		return applyReasonChildType;
	}

	public void setApplyReasonChildType(Integer applyReasonChildType) {
		this.applyReasonChildType = applyReasonChildType;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public Integer getReplaceId() {
		return replaceId;
	}

	public void setReplaceId(Integer replaceId) {
		this.replaceId = replaceId;
	}

	public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology == null ? null : technology.trim();
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }

    public String getBusinessAbility() {
        return businessAbility;
    }

    public void setBusinessAbility(String businessAbility) {
        this.businessAbility = businessAbility == null ? null : businessAbility.trim();
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility == null ? null : specialAbility.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getOtherDemand() {
        return otherDemand;
    }

    public void setOtherDemand(String otherDemand) {
        this.otherDemand = otherDemand == null ? null : otherDemand.trim();
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

	public Integer getEntryNum() {
        return entryNum;
    }

    public void setEntryNum(Integer entryNum) {
        this.entryNum = entryNum;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public String getOfferRange() {
        return offerRange;
    }

    public void setOfferRange(String offerRange) {
        this.offerRange = offerRange == null ? null : offerRange.trim();
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}