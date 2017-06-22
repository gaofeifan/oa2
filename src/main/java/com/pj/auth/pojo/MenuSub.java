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
@Table(name= "menu_sub")
public class MenuSub {

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
	private Integer id;
	
	@Column
	private Integer mid;
	
	@Column
	private String name;
	
	@Column
	private Integer auth;
	
	@Column
	private String href;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getAuth() {
		return auth;
	}

	public void setAuth(Integer auth) {
		this.auth = auth;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	
}
