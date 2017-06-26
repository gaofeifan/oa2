package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：招聘申请结果枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum RecruitApplyResultConstant {

	RECRUIT_AGREE("招聘同意", 1),
	RECRUIT_DISAGREE("招聘不同意", 2),
	RECRUIT_PAUSE("招聘暂停", 3),
	RECRUIT_CANCEL("招聘取消", 4),
	ENTRY_AGREE("入职同意", 5),
	ENTRY_DISAGREE("入职不同意", 6),
	ENTRY_SUCCESS("入职完结", 7);	
	
	private RecruitApplyResultConstant(String resultName, int result) {
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
