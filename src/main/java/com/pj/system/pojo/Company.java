package com.pj.system.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;
@Table(name = "t_company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer id;

    /**
     * 公司编号
     */
    @Column(name="number")
    private String number;

    /**
     * 名称
     */
    @Column(name="name")
    private String name;

    /**
     * 地址
     */
    @Column(name="address")
    private String address;

    /**
     * 联系方式
     */
    @Column(name="contact")
    private String contact;

    @Column(name="pId")
    private Integer pId;

    /**
     * 是否删除 0未删除  1已删除
     */
    @Column(name="isdelete")
    private Integer isdelete;

    /**
     * 层级
     */
    @ApiModelProperty(value = "层级", required = false)
    @Column(name="hierarchy")
    private Integer hierarchy;

    
	@Transient
	private String choice;
	
    private static final long serialVersionUID = 1L;

    
	public Company() {}
	
	public Company(Integer id, Integer isdelete) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", contact=").append(contact);
        sb.append(", pId=").append(pId);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", hierarchy=").append(hierarchy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}