package com.pj.system.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
@Table(name="t_position")
public class Position implements Serializable {
    /**
     * 职位id
     */
	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "职位id", required = false)
    private Integer id;

    /**
     * 职位编号
     */
	@Column(name="number")
	@ApiModelProperty(value = "职位编号", required = false)
    private String number;

    /**
     * 职位名称
     */
	@Column(name="name")
	@ApiModelProperty(value = "职位名称", required = false)
    private String name;

    /**
     * 描述
     */
	@Column(name="description")
	@ApiModelProperty(value = "描述", required = false)
    private String description;

    /**
     * 是否删除 0未删除  1已删除
     */
	@Column(name="isdelete")
	@ApiModelProperty(value = "是否删除 0未删除  1已删除", required = false)
    private Integer isdelete;

    /**
     * 父节点
     */
	@Column(name="pid")
	@ApiModelProperty(value = "父节点", required = false)
    private Integer pid;

	/**
	 * 父节点
	 */
	@Column(name="grade")
	@ApiModelProperty(value = "级别", required = false)
	private Integer grade;

    private static final long serialVersionUID = 1L;

    
    public Position() {}

    public Position(Integer id, Integer isdelete) {
		super();
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

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
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
        sb.append(", isdelete=").append(isdelete);
        sb.append(", pid=").append(pid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}