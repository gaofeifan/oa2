package com.pj.auth.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午10:30:30
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name= "auth_menu")
public class AuthMenu {

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String img;
	
	@Column
	private String href;
	
	@Column
	private Integer fid;
	
	@Column
	private Integer grade;
	
	@Column
	private Integer auth;
	
	@Column
	private Integer post;
	
	@Transient
	private String choice;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	public Integer getFid() {
		return fid;
	}
	
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public Integer getAuth() {
		return auth;
	}
	
	public void setAuth(Integer auth) {
		this.auth = auth;
	}
	public Integer getPost() {
		return post;
	}
	
	public void setPost(Integer post) {
		this.post = post;
	}
	
	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
}
