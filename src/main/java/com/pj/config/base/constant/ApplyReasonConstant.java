package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：招聘原因枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum ApplyReasonConstant {

	STRAT("新增战略类需求", 1),
		STRAT_ADD("业务板块增加", 11),
		STRAT_STORE("储备人力", 12),
	BUSSNESS("新增战略类需求", 2),
		BUSSNESS_EXPAND("业务扩大", 21),
		BUSSNESS_ADD("职能增加", 22),
		BUSSNESS_OTHER("other", 23),
	REPLACE("新增战略类需求", 3),
		REPLACE_LEAVE("离职补充", 31),
		REPLACE_EXIST("现有人员替换", 32),
		REPLACE_OTHER("其他", 33);
	
	private String reasonName ;
	private int reason;
	private ApplyReasonConstant(String reasonName, int reason) {
		this.reason = reason;
		this.reasonName = reasonName;
	}
	public String getReasonName() {
		return reasonName;
	}
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}
    
}
