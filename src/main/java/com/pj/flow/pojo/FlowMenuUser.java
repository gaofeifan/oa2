package com.pj.flow.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "flow_menu_user")
public class FlowMenuUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

	@Column
    private Integer userid;

	@Column
    private String type;

	@Column
    private Integer menuid;

	@Column
    private Integer isread;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getIsread() {
		return isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	
}