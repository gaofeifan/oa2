package com.pj.flow.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_approve")
public class FlowApprove {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer recordid;

    private Integer userid;

    private Integer positionid;

    private Date handledate;

    private String handleidea;

    private Integer checkstatus;

    private Integer applyId;

    private Integer isapprove;

    private Integer applyuserid;

    private Date startTime;

    private Integer ismessaging;

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

    public Integer getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(Integer isapprove) {
        this.isapprove = isapprove;
    }

    public Integer getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(Integer applyuserid) {
        this.applyuserid = applyuserid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getIsmessaging() {
        return ismessaging;
    }

    public void setIsmessaging(Integer ismessaging) {
        this.ismessaging = ismessaging;
    }
}