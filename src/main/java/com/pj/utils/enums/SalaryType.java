package com.pj.utils.enums;

/**
 *  请假类型
 *	@author		GFF
 *	@date		2016年12月30日上午11:36:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public enum SalaryType {
	SY("0","试用"),ZZ("1","转正"),SX("2","实习");

	private String index;
	private String name;
	
	private SalaryType(String index, String name) {
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
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


