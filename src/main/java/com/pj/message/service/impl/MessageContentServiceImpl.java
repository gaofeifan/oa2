package com.pj.message.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.NotificationType;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.config.template.FormMessageTemplate;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.service.FlowApproveService;
import com.pj.message.mapper.MessageContentMapper;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:14:19
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class MessageContentServiceImpl extends AbstractBaseServiceImpl<MessageContent, Integer> implements MessageContentService {

	@Resource
	private MessageContentMapper messageContentMapper;
	
	@Resource
	private FlowApproveService flowApproveService;
	
	@Resource
	private UserService userService;
	
	@Override
	public MyMapper<MessageContent> getMapper() {
		return messageContentMapper;
	}

	
	/**
	 * 	添加未审批消息
	 *	@author 	GFF
	 *	@date		2017年6月26日上午10:55:37	
	 * 	@param messageTemplate
	 */
	@Override
	public void addUnapprovedMessage(MessageContent content){
		//	设置为入职消息通知
		content.setNotificationType(NotificationType.INITIATE.getValue());
		saveMessageNotification(content, getMessageCenterAuthorizedPersonnel());
	}

	
	/**
	 * 	添加已审批消息
	 *	@author 	GFF
	 *	@date		2017年6月26日上午10:55:37	
	 * 	@param messageTemplate
	 */
	@Override
	public void addApprovedMessage(MessageContent content , int applyId){
		//	设置类型为审批消息
		content.setNotificationType(NotificationType.APPROVAL.getValue());
		//	根据表单id查询所有审批人员
		List<Integer> assessingOfficers = getAssessingOfficer(applyId);
		//	查询所有具有消息中心权限的的人员
		assessingOfficers.addAll(getMessageCenterAuthorizedPersonnel());
		saveMessageNotification(content, assessingOfficers);
	}

	/**
	 * 	根据email与类型查询消息
	 */
	@Override
	public List<MessageContent> selectMessageAllByEamilAndNotificationType(String email, Integer notificationType) {
		User user = this.userService.selectByEamil(email);
		if(notificationType == 0){
			//	TODO 根据当前用户查询权限 是否分配了消息中心权限
			if(true){
				//	分配了查询所有的消息
				Example example = new Example(MessageContent.class);
				example.createCriteria().andCondition("notification_type" , notificationType);
				example.orderBy("apply_time").desc();
				return super.selectByExample(example );
			}
		}
		//	未分配权限 查询与其相关的消息
		MessageContent mc = new MessageContent();
		mc.setNotificationType(notificationType);
		mc.setApplicatId(user.getId());
		return this.messageContentMapper.selectMessageContentByUserIdAndNotificationType(mc);
	}
	
	
	/**
	 * 	TODO 未完成
	 * 	查询所有具有消息中心权限的的人员
	 *	@author 	GFF
	 *	@date		2017年6月26日上午11:44:40
	 */
	private List<Integer> getMessageCenterAuthorizedPersonnel() {
		return null;
	}
	
	/**
	 * 	根据申请id获取所有的审批人员
	 *	@author 	GFF
	 *	@date		2017年6月26日下午2:07:41	
	 * 	@param applyId
	 * 	@return
	 */
	private List<Integer> getAssessingOfficer(int applyId) {
		Example example = new Example(FlowApprove.class);
		example.createCriteria().andCondition("apply_id" , applyId);
		List<FlowApprove> list = this.flowApproveService.selectByExample(example );
		List<Integer> ids = list.stream().map(approve -> approve.getUserid()).collect(Collectors.toList());
		return ids;
	}
	
	/**
	 * 	保存消息通知内容与人员
	 *	@author 	GFF
	 *	@date		2017年6月26日下午2:33:47
	 */
	private void saveMessageNotification(MessageContent content , List<Integer> ids){
		FormMessageTemplate messageTemplate = new FormMessageTemplate();
		messageTemplate.addMessageContent(content);
		messageTemplate.addMessageViewers(ids);
		messageTemplate.messageNotification();
	}



}
