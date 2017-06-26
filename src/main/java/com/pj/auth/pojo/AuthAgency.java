package com.pj.auth.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年6月22日下午3:40:32
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="auth_agency")
public class AuthAgency {
	
	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "权限id  新增时不需要传递,其他操作时需要传递", required = false)
	private Integer id;

	@Column
	@ApiModelProperty(value = "公司id", required = false)
	private Integer companyId;
	
	@Column
	@ApiModelProperty(value = "部门id", required = false)
	private Integer dempId;
	
	@Column
	@ApiModelProperty(value = "所属级别", required = false)
	private Integer grade;

	@Column
	@ApiModelProperty(value = "是否删除", required = false)
	private Integer isdelete;

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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
}
