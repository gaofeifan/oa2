package com.pj.flow.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="flow_recruit")
public class FlowRecruit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private String number;

    private Integer applyId;

    private Date applyDate;

    private Integer companyId;

    private Integer postId;

    private Integer dempId;

    private Integer positionId;

    private Integer isDempLeader;

    private Integer isCompanyLeader;

    private Integer needNum;

    private String workAddress;

    private Integer applyReasonType;
    
    private Integer applyReasonChildType;
    
    private String applyReason;
    
    private Integer replaceId;

    private Integer channel;

    private Integer sex;

    private String age;

    private String education;

    private String duty;

    private String technology;

    private String knowledge;

    private String businessAbility;

    private String specialAbility;

    private String experience;

    private String otherDemand;

    private String state;

    private String result;

    private Integer entryNum;

    private Integer leaderId;

    private String offerRange;

    private Integer isCheck;

    private Integer status;
    
    
    
    //查询使用
    private String username;
    private String replaceName;
    private String replaceOffer;
    private String leaderName;
    private String companyName;
    private String dempName;
    private String postName;
    private String positionName;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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