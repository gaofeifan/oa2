package com.pj.config.base.constant;

/**
 *  请假类型
 *	@author		GFF
 *	@date		2016年12月30日上午11:36:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public enum SalaryType {
	SY(0,"试用"),ZZ(1,"转正"),SX(2,"实习");

	private Integer index;
	private String name;
	
	private SalaryType(Integer index, String name) {
		this.index = index;
		this.name = name;
	}
	
    public static String getName(String index) {  
    	for (SalaryType leave : values()) {
			if(leave.equals(index)){
				return leave.getName();
			}
		}
    	return null;
    }  
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


