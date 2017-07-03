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

	@Override
	public String toString() {
		return "FlowApprove [id=" + id + ", recordid=" + recordid + ", userid=" + userid + ", positionid=" + positionid
				+ ", handledate=" + handledate + ", handleidea=" + handleidea + ", checkstatus=" + checkstatus
				+ ", applyId=" + applyId + ", isApprove=" + isApprove + ", applyUserId=" + applyUserId + ", startTime="
				+ startTime + ", is_Messaging=" + is_Messaging + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result + ((applyUserId == null) ? 0 : applyUserId.hashCode());
		result = prime * result + ((checkstatus == null) ? 0 : checkstatus.hashCode());
		result = prime * result + ((handledate == null) ? 0 : handledate.hashCode());
		result = prime * result + ((handleidea == null) ? 0 : handleidea.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isApprove == null) ? 0 : isApprove.hashCode());
		result = prime * result + ((is_Messaging == null) ? 0 : is_Messaging.hashCode());
		result = prime * result + ((positionid == null) ? 0 : positionid.hashCode());
		result = prime * result + ((recordid == null) ? 0 : recordid.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlowApprove other = (FlowApprove) obj;
		if (applyId == null) {
			if (other.applyId != null)
				return false;
		} else if (!applyId.equals(other.applyId))
			return false;
		if (applyUserId == null) {
			if (other.applyUserId != null)
				return false;
		} else if (!applyUserId.equals(other.applyUserId))
			return false;
		if (checkstatus == null) {
			if (other.checkstatus != null)
				return false;
		} else if (!checkstatus.equals(other.checkstatus))
			return false;
		if (handledate == null) {
			if (other.handledate != null)
				return false;
		} else if (!handledate.equals(other.handledate))
			return false;
		if (handleidea == null) {
			if (other.handleidea != null)
				return false;
		} else if (!handleidea.equals(other.handleidea))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isApprove == null) {
			if (other.isApprove != null)
				return false;
		} else if (!isApprove.equals(other.isApprove))
			return false;
		if (is_Messaging == null) {
			if (other.is_Messaging != null)
				return false;
		} else if (!is_Messaging.equals(other.is_Messaging))
			return false;
		if (positionid == null) {
			if (other.positionid != null)
				return false;
		} else if (!positionid.equals(other.positionid))
			return false;
		if (recordid == null) {
			if (other.recordid != null)
				return false;
		} else if (!recordid.equals(other.recordid))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
	


}