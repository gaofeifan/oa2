package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：招聘待办状态枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum RecruitTodoState {

	//招聘待办状态（0:已终止,1:招聘中,2:已提交,3:已暂停,4:已审批）
	HAS_CANCEL("已终止", 0),
	IN_RECRUIT("招聘中", 1),
	HAS_COMMIT("已提交", 2),
	HAS_PAUSE("已暂停", 3),
	HAS_APPROVED("已审批", 4);	
	
	private RecruitTodoState(String stateName, int state) {
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
