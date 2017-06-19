package com.pj.system.pojo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
@Table(name="t_rank")
public class Rank implements Serializable {
	@ApiModelProperty(value = "id", required = false)
	@Id
    private Integer id;

	@ApiModelProperty(value = "编号", required = false)
	@Column(name="number")
    private String number;

	@ApiModelProperty(value = "名称", required = false)
	@Column(name="name")
    private String name;

    /**
     * 是否删除 0未删除  1已删除
     */
	@Column(name="isdelete")
	@ApiModelProperty(value = "是否删除 0未删除  1已删除", required = false)
	private Integer isdelete;

    private static final long serialVersionUID = 1L;

    
    public Rank() {}
    

	public Rank(Integer id, String number, String name, Integer isdelete) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
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

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
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
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}