package com.pj.system.pojo;

import java.io.Serializable;

public class SystemRole implements Serializable {
    private Integer id;

    /**
     * 角色
     */
    private Integer roleid;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 所属平台
     */
    private String terrace;

    /**
     * 角色名称
     */
    private String rolename;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTerrace() {
        return terrace;
    }

    public void setTerrace(String terrace) {
        this.terrace = terrace == null ? null : terrace.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleid=").append(roleid);
        sb.append(", userid=").append(userid);
        sb.append(", terrace=").append(terrace);
        sb.append(", rolename=").append(rolename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}