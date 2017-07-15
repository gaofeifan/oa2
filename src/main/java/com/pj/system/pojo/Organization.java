package com.pj.system.pojo;

import java.io.Serializable;

/**
 * 项目名称：oa   
 * 类名称：Organization   
 * 类描述： 公司，部门或岗位
 * 创建人：limr   
 * 创建时间：2017年7月8日 下午2:25:33   
 * 修改人：limr   
 * 修改时间：2017年7月8日 下午2:25:33   
 * 修改备注：   
 * @version    
 *
 */
public class Organization implements Serializable {
   
	/**
     * id
     */
    private Integer id;
    /**
     * id
     */
	
    private Integer pId;

    /**
     * 名称
     */
    
    private String name;


    /**
     * 编号
     */
    
    private String number;

    /**
     * 父节点,记录number
     */
    
    private String pNum;
    
    /**
     * 组织机构num
     */
    
    private String signNum;

    /**
     * 是否删除 0未删除  1已删除
     */
    
    private Integer isdelete;

   /**
     * 层级
     */
    
    private Integer level;
    
    /**
     * 类型（company,demp,post）
     */
    
    private String type;

    /**
     * 是否选中（0：未选中，1：选中）
     */
    
	private String choice;
	
	
	private String hasChilds;
	
	
    public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	private static final long serialVersionUID = 1L;

	public String getHasChilds() {
		return hasChilds;
	}

	public void setHasChilds(String hasChilds) {
		this.hasChilds = hasChilds;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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