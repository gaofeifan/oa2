package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：ApplyReasonConstant   
 * 类描述：操作枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:00:12   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:00:12   
 * 修改备注：   
 * @version    
 *
 */
public enum ActionLogOperation {
	COMMIT_ENTRY("提出入职申请"),
	CANCEL_RECRUIT("中止招聘需求"),
	PAUSE_RECRUIT("暂停招聘需求"),
	RESTART_RECRUIT("重新开始招聘需求"),
	SEND_OFFER("发送offer"),
	ENTRY_END("员工建档");

    private String operation;

    ActionLogOperation(String operation){
        this.operation = operation;
    }

    public String getValue(){
        return operation;
    }
	
}
