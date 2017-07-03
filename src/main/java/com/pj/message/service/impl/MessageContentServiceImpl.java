package com.pj.message.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthMenuService;
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

/**
 * @author GFF
 * @date 2017年6月20日下午6:14:19
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Service
@Transactional
public class MessageContentServiceImpl extends AbstractBaseServiceImpl<MessageContent, Integer>
		implements MessageContentService {

	@Resource
	private MessageContentMapper messageContentMapper;

	@Resource
	private FlowApproveService flowApproveService;

	@Resource
	private UserService userService;

	@Resource
	private FormMessageTemplate formMessageTemplate;

	@Resource
	private AuthMenuService authMenuService;

	@Override
	public MyMapper<MessageContent> getMapper() {
		return messageContentMapper;
	}

	/**
	 * 添加未审批消息
	 * 
	 * @author GFF
	 * @date 2017年6月26日上午10:55:37
	 * @param messageTemplate
	 */
	@Override
	public void addUnapprovedMessage(MessageContent content) {
		// 设置为入职消息通知
		content.setNotificationType(NotificationType.INITIATE.getValue());
		saveMessageNotification(content, getMessageCenterAuthorizedPersonnel());
	}

	/**
	 * 添加已审批消息
	 * 
	 * @author GFF
	 * @date 2017年6月26日上午10:55:37
	 * @param messageTemplate
	 */
	@Override
	public void addApprovedMessage(MessageContent content, Integer applyId) {
		// 设置类型为审批消息
		content.setNotificationType(NotificationType.APPROVAL.getValue());
		// 根据表单id查询所有审批人员
		Set<Integer> ids = getAssessingOfficer(applyId);
		// 查询所有具有消息中心权限的的人员
		ids.addAll(getMessageCenterAuthorizedPersonnel());
		saveMessageNotification(content, ids);
	}

	/**
	 * 根据email与类型查询消息
	 */
	@Override
	public List<MessageContent> selectMessageAllByEamilAndNotificationType(String email, Integer notificationType) {
		User user = this.userService.selectByEamil(email);
		MessageContent mc = new MessageContent();
		mc.setNotificationType(notificationType);
		mc.setApplicatId(user.getId());
		return this.messageContentMapper.selectMessageContentByUserIdAndNotificationType(mc);
	}

	/**
	 * 查询所有具有消息中心权限的的人员
	 * 
	 * @author GFF
	 * @date 2017年6月26日上午11:44:40
	 */
	private Set<Integer> getMessageCenterAuthorizedPersonnel() {
		List<AuthUser> list = this.authMenuService.selectUserByMessageCenterId();
		return list.stream().map(user -> user.getUserid()).collect(Collectors.toSet());
	}

	/**
	 * 根据申请id获取所有的审批人员
	 * 
	 * @author GFF
	 * @date 2017年6月26日下午2:07:41
	 * @param applyId
	 * @return
	 */
	private Set<Integer> getAssessingOfficer(Integer applyId) {
		FlowApprove record = new FlowApprove();
		record.setApplyId(applyId);
		List<FlowApprove> list = this.flowApproveService.select(record);
		return list.stream().map(approve -> approve.getUserid()).collect(Collectors.toSet());
	}

	/**
	 * 保存消息通知内容与人员
	 * 
	 * @author GFF
	 * @date 2017年6月26日下午2:33:47
	 */
	private void saveMessageNotification(MessageContent content, Set<Integer> ids) {
		formMessageTemplate.addMessageContent(content);
		formMessageTemplate.addMessageViewers(ids);
		formMessageTemplate.messageNotification();
	}
}
