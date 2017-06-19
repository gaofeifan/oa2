package com.pj.system.service;

public interface JedisService {
	
	public static final String WEI_XIN_QR_CODE_VERSION = "WEI_XIN_QR_CODE_VERSION";
	//	获取申请单号
	public String getNumber();
	
	//	获取流程单号
	public String getFlowNumber();
	
	//	获取流程指定单号
	public String getFlowAppointNumber();

	//	保存单号
	public void setNumber(String number);

	public void setNumber2(String number);
	
	public void setFlowNumber();
	

}
