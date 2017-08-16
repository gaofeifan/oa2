package com.pj.config.web.timer.wechat;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowApproveService;
import com.pj.flow.service.FlowUserApplicationService;
import com.pj.utils.DateUtils;
import com.pj.weChat.utils.WeChatTemplateUtils;

/**
 *	@author		GFF
 *	@date		2017年8月16日上午10:53:24
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public class PushNotificationWeChatTimer {
	@Resource
	private FlowApproveService flowApproveService;
	@Resource
	private FlowUserApplicationService flowUserApplicationService;
	@Resource
	private WeChatTemplateUtils weChatTemplateUtils;
	
	/**
	 * 	给待审批人推送消息
	 *	@author 	GFF
	 *	@date		2017年8月16日上午11:00:13
	 */
	public void pushTheMessageToTheApprover(){
		Date date = DateUtils.getSomedate(new Date(), -1);
		List<FlowApprove> list = this.flowApproveService.selectCanApproveUserByStartTime(date);
		for (FlowApprove flowApprove : list) {
			FlowUserApplication application = this.flowUserApplicationService.selectByPrimaryKey(flowApprove.getApplyId());
			weChatTemplateUtils.approvalPending(application.getApplyType(), application.getFormId(), flowApprove.getUserid());
		}
	}
	

}
