package com.pj.auth.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午10:30:30
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name= "auth_user")
public class AuthUser {

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
	private Integer id;
	
	@Column
	private Integer userid;
	
	@Column
	private Integer menuid;
	
	@Column
	private Integer companyid;
	
	@Column
	private Integer dempid;
	
	@Column
	private Integer postid;
	
	@Column
	private String postSignNum;
	
	@Column
	private String menuids;
	
	@Column
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPostSignNum() {
		return postSignNum;
	}

	public void setPostSignNum(String postSignNum) {
		this.postSignNum = postSignNum;
	}

	public String getMenuids() {
		return menuids;
	}

	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}

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

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	
	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	
	public Integer getDempid() {
		return dempid;
	}

	public void setDempid(Integer dempid) {
		this.dempid = dempid;
	}
	
	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	
}
