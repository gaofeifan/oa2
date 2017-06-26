package com.pj.flow.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "flow_approve")
public class FlowApprove {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

	@Column
    private Integer recordid;

	@Column
    private Integer userid;

	@Column
    private Integer positionid;

	@Column
    private Date handledate;

	@Column
    private String handleidea;

	@Column
    private Integer checkstatus;

	@Column
    private Integer applyId;

	@Column
    private Integer isApprove;

	@Column
    private Integer applyUserId;

	@Column
    private Date startTime;

	@Column
    private Integer is_Messaging;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public Date getHandledate() {
        return handledate;
    }

    public void setHandledate(Date handledate) {
        this.handledate = handledate;
    }

    public String getHandleidea() {
        return handleidea;
    }

    public void setHandleidea(String handleidea) {
        this.handleidea = handleidea == null ? null : handleidea.trim();
    }

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

	public Integer getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(Integer isApprove) {
		this.isApprove = isApprove;
	}

	public Integer getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Integer applyUserId) {
		this.applyUserId = applyUserId;
	}

	public Integer getIs_Messaging() {
		return is_Messaging;
	}

	public void setIs_Messaging(Integer is_Messaging) {
		this.is_Messaging = is_Messaging;
	}


}