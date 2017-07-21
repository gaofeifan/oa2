package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：入职申请状态枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum EntryApplyState {

	IN_ENTRY_APPROVAL("入职审批中", 1),
	ENTRY_APPROVED("入职已审批", 2),
	IN_OFFER("已发offer", 3),
	FILING("已建档", 4);	
	
	private EntryApplyState(String stateName, int state) {
		this.stateName = stateName;
		this.state = state;
	}
	
	private String stateName ;
	private int state;
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	
}
