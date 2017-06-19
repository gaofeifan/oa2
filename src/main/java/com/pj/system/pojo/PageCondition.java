package com.pj.system.pojo;

import io.swagger.annotations.ApiModelProperty;

public class PageCondition {
	@ApiModelProperty(value = "公司id", required = false)
	private Integer companyid;
	@ApiModelProperty(value = "部门id", required = false)
	private Integer dempid;
	@ApiModelProperty(value = "通过用户名模糊查询", required = false)
	private String username;
	@ApiModelProperty(value = "激活状态", required = false)
	private Integer isstatus;
	@ApiModelProperty(value = "页码", required = false)
	private Integer pageNo;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getIsstatus() {
		return isstatus;
	}
	public void setIsstatus(Integer isstatus) {
		this.isstatus = isstatus;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
