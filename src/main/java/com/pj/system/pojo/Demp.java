package com.pj.system.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

@Table(name="t_demp")
public class Demp implements Serializable {
   
	public Demp() {}

	
	public Demp(Integer id, Integer companyid) {
		this.id = id;
		this.companyid = companyid;
	}

	
	public Demp(Integer id, Integer companyid, Integer isdelete) {
		this.id = id;
		this.companyid = companyid;
		this.isdelete = isdelete;
	}




	public Demp(Integer id, String name, Integer companyid, String number, Integer isdelete , Integer pId) {
		this.id = id;
		this.name = name;
		this.companyid = companyid;
		this.number = number;
		this.isdelete = isdelete;
		this.pId = pId;
	}




	/**
     * id
     */
	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
    private Integer id;

    /**
     * 名称
     */
	@Column(name="name")
	@ApiModelProperty(value = "部门名称", required = false)
    private String name;

    /**
     * 上级部门
     */
	@Column(name="frontrank")
	@ApiModelProperty(value = "上级部门", required = false)
    private Integer frontrank;

    /**
     * 企业id
     */
	@Column(name="companyid")
	@ApiModelProperty(value = "企业id", required = false)
    private Integer companyid;

    /**
     * 部门编号
     */
	@Column(name="number")
	@ApiModelProperty(value = "部门编号", required = false)
    private String number;

    /**
     * 父节点
     */
	@Column(name="pId")
	@ApiModelProperty(value = "父节点", required = false)
    private Integer pId;

    /**
     * 是否删除 0未删除  1已删除
     */
	@Column(name="isdelete")
	@ApiModelProperty(value = "是否删除 0未删除  1已删除", required = false)
    private Integer isdelete;

   /**
     * 层级
     */
	@Column(name="hierarchy")
    @ApiModelProperty(value = "层级", required = false)
    private Integer hierarchy;

	@Transient
	private String choice;
	@Transient
	private Boolean open;
	
    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getFrontrank() {
        return frontrank;
    }

    public void setFrontrank(Integer frontrank) {
        this.frontrank = frontrank;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }


    public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choice == null) ? 0 : choice.hashCode());
		result = prime * result + ((companyid == null) ? 0 : companyid.hashCode());
		result = prime * result + ((frontrank == null) ? 0 : frontrank.hashCode());
		result = prime * result + ((hierarchy == null) ? 0 : hierarchy.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isdelete == null) ? 0 : isdelete.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demp other = (Demp) obj;
		if (choice == null) {
			if (other.choice != null)
				return false;
		} else if (!choice.equals(other.choice))
			return false;
		if (companyid == null) {
			if (other.companyid != null)
				return false;
		} else if (!companyid.equals(other.companyid))
			return false;
		if (frontrank == null) {
			if (other.frontrank != null)
				return false;
		} else if (!frontrank.equals(other.frontrank))
			return false;
		if (hierarchy == null) {
			if (other.hierarchy != null)
				return false;
		} else if (!hierarchy.equals(other.hierarchy))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isdelete == null) {
			if (other.isdelete != null)
				return false;
		} else if (!isdelete.equals(other.isdelete))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		return true;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", frontrank=").append(frontrank);
        sb.append(", companyid=").append(companyid);
        sb.append(", number=").append(number);
        sb.append(", pId=").append(pId);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}