package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：入职申请结果枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum EntryApplyResult {

	ENTRY_AGREE("入职同意", 1),
	ENTRY_DISAGREE("入职不同意", 2),
	ENTRY_SUCCESS("入职完结", 3);	
	
	private EntryApplyResult(String resultName, int result) {
		this.resultName = resultName;
		this.result = result;
	}
	
	private String resultName ;
	private int result;
	public String getStateName() {
		return resultName;
	}
	public void setStateName(String resultName) {
		this.resultName = resultName;
	}
	public int getState() {
		return result;
	}
	public void setState(int result) {
		this.result = result;
	}

	
}
