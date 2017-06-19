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
@Table(name= "auth_menu")
public class AuthMenu {

	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String href;
	
	@Column(name="pId")
	private Integer pId;

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

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}
	
}
