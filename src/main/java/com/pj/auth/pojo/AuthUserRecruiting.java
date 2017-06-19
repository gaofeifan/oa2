package com.pj.auth.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午10:37:44
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="auth_user_recruiting")
public class AuthUserRecruiting {

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
	private Integer id;
	
	private Integer companyId;
	
	private Integer dempId;
	
	private Integer postId;
	
	@Column(name="pId")
	private Integer pId;
	
	private String name;
	
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getDempId() {
		return dempId;
	}

	public void setDempId(Integer dempId) {
		this.dempId = dempId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
