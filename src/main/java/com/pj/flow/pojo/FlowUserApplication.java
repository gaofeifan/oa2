package com.pj.flow.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "flow_user_application")
public class FlowUserApplication {
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer userId;

    private Integer fromId;

    private String applyType;

    private String applyName;

    private String applyDempName;

    private Date applyTime;

    private String applyPostName;

    private String username;

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

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
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

    public String getApplyPostName() {
        return applyPostName;
    }

    public void setApplyPostName(String applyPostName) {
        this.applyPostName = applyPostName == null ? null : applyPostName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}