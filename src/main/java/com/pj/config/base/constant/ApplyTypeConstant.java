package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：申请类型枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum ApplyTypeConstant {

	RECRUIT("招聘申请", "recruit"),
	ENTRY("入职申请", "entry"),
	REGULAR("转正申请", "regular"),
	CHANGE("异动申请", "change"),
	LEAVE("请假申请", "leave"),
	DIMISSION("离职申请", "dimission"),
	OTHER("其他", "other");
	
	private String applyName ;
	private String applyType;
	
	private ApplyTypeConstant(String applyName, String applyType) {
		this.applyName = applyName;
		this.applyType = applyType;
	}
	
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
    
}
