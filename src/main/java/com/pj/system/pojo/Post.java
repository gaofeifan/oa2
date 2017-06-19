package com.pj.system.pojo;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	private Integer id;

	/**
	 * 岗位编号
	 */
	@Column(name = "number")
	@ApiModelProperty(value = "岗位编号", required = false)
	private String number;

	/**
	 * 岗位名称
	 */
	@Column(name = "name")
	@ApiModelProperty(value = "岗位名称", required = false)
	private String name;

	/**
	 * 公司id
	 */
	@Column(name = "companyId")
	@ApiModelProperty(value = "公司id", required = false)
	private Integer companyId;

	/**
	 * 部门id
	 */
	@Column(name = "dempId")
	@ApiModelProperty(value = "部门id", required = false)
	private Integer dempId;

	/**
	 * 描述
	 */
	@Column(name = "description")
	@ApiModelProperty(value = "描述", required = false)
	private String description;

	/**
	 * 职位id
	 */
	@Column(name = "positionid")
	@ApiModelProperty(value = " 职位id", required = false)
	private Integer positionid;

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

	
	public Post() {}

	
	public Post(Integer id, Integer isdelete) {
		this.id = id;
		this.isdelete = isdelete;
	}


	public Post(String name, Integer positionid, Integer isdelete) {
		super();
		this.name = name;
		this.positionid = positionid;
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

	public Integer getPositionid() {
		return positionid;
	}

	public Integer getDempId() {
		return dempId;
	}

	public void setDempId(Integer dempId) {
		this.dempId = dempId;
	}

	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", number=").append(number);
		sb.append(", name=").append(name);
		sb.append(", description=").append(description);
		sb.append(", positionid=").append(positionid);
		sb.append(", isdelete=").append(isdelete);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}