package com.pj.system.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "t_post")
public class Post implements Serializable {
	/**
	 * 岗位序号
	 */
	@ApiModelProperty(value = "岗位序号", required = false)
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 岗位编号
	 */
	@Column(name = "number")
	@ApiModelProperty(value = "岗位编号", required = false)
	private String number;
	
	/**
	 * 机构编号
	 */
	@Column(name = "sign_num")
	private String signNum;

	/**
	 * 岗位名称
	 */
	@Column(name = "name")
	@ApiModelProperty(value = "岗位名称", required = false)
	private String name;

	/**
	 * 公司id
	 */
	@Column(name = "company_id")
	@ApiModelProperty(value = "公司id", required = false)
	private Integer companyId;

	/**
	 * 部门id
	 */
	@Column(name = "demp_id")
	@ApiModelProperty(value = "部门id", required = false)
	private Integer dempId;

	/**
	 * 描述
	 */
	@Column(name = "description")
	@ApiModelProperty(value = "描述", required = false)
	private String description;

	/**
	 * 是否删除 0未删除 1已删除
	 */
	@Column(name = "isdelete")
	@ApiModelProperty(value = "是否删除 0未删除  1已删除", required = false)
	private Integer isdelete;

	/**
	 * 职位信息
	 */
	@Transient
	private List<Position> positions = new ArrayList<Position>();

	/**
	 * 前台查询使用
	 */
	@Transient
	private String companyname;
	@Transient
	private String dempname;
	@Transient
	private String positionname;
	private static final long serialVersionUID = 1L;
	
	@Transient
	private String choice;
	public Post() {}

	
	public Post(Integer id, Integer isdelete) {
		this.id = id;
		this.isdelete = isdelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDempname() {
		return dempname;
	}

	public void setDempname(String dempname) {
		this.dempname = dempname;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}


	public Integer getDempId() {
		return dempId;
	}

	public void setDempId(Integer dempId) {
		this.dempId = dempId;
	}


	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSignNum() {
		return signNum;
	}


	public void setSignNum(String signNum) {
		this.signNum = signNum;
	}
	
}

