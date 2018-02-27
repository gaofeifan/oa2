package com.pj.flow.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "flow_user_application")
public class FlowUserApplication {
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

	@Column
    private Integer userId;

	@Column
    private Integer formId;

	@Column
    private String applyType;

	@Column
    private String applyName;

	@Column
    private String applyDempName;
	
	@Column
    private Date applyTime;

	@Column
    private String applyCompanyName;

	@Column
    private String username;
	
	//查询使用
	@Transient
	private Integer approveId;
	@Transient
	private Integer checkstatus;
	@Transient
	private String applyDateStr;
	@Transient
	private Integer applyResult;
	@Transient
	private Integer applyState;
	@Transient
	private Integer endCheckstatus;
	/**
	 * 	最后的审批意见移动端使用
	 */
	@Transient
	private Integer endApproval;
	
	@Transient
	private String content;

    public Integer getApplyState() {
		return applyState;
	}

	public void setApplyState(Integer applyState) {
		this.applyState = applyState;
	}

	public Integer getApproveId() {
		return approveId;
	}

	public void setApproveId(Integer approveId) {
		this.approveId = approveId;
	}

	public Integer getApplyResult() {
		return applyResult;
	}

	public void setApplyResult(Integer applyResult) {
		this.applyResult = applyResult;
	}

	public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getApplyDempName() {
        return applyDempName;
    }

    public void setApplyDempName(String applyDempName) {
        this.applyDempName = applyDempName == null ? null : applyDempName.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyCompanyName() {
		return applyCompanyName;
	}

	public void setApplyCompanyName(String applyCompanyName) {
		this.applyCompanyName = applyCompanyName;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCheckstatus() {
		return checkstatus;
	}

	public void setCheckstatus(Integer checkstatus) {
		this.checkstatus = checkstatus;
	}

	public Integer getEndApproval() {
		return endApproval;
	}

	public void setEndApproval(Integer endApproval) {
		this.endApproval = endApproval;
	}

	public Integer getEndCheckstatus() {
		return endCheckstatus;
	}

	public void setEndCheckstatus(Integer endCheckstatus) {
		this.endCheckstatus = endCheckstatus;
	}
}