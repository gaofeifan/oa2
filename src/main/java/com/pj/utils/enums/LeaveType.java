package com.pj.utils.enums;

/**
 *  请假类型
 *	@author		GFF
 *	@date		2016年12月30日上午11:36:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public enum LeaveType {
	SJ("1","事假"),BJ("2","病假"),NJ("3","年假"),HJ("4","婚假"),TX("5","调休"),
	BRJ("6","哺乳假"),CJJ("7","产检假"),SANGJ("8","丧假"),PCJ("9","陪产假"),CJ("10","产假"),QT("11","其他");

	private String index;
	private String name;
	
	private LeaveType(String index, String name) {
		this.index = index;
		this.name = name;
	}
	
	 // 普通方法  
    public static String getName(String index) {  
    	for (LeaveType leave : values()) {
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


