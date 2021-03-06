package com.pj.message.service.impl;

import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthMenuService;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.constant.NotificationType;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.config.template.FormMessageTemplate;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.service.FlowApproveService;
import com.pj.message.mapper.MessageContentMapper;
import com.pj.message.pojo.MessageContent;
import com.pj.message.pojo.MessageContentUser;
import com.pj.message.service.MessageContentService;
import com.pj.message.service.MessageContentUserService;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

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

	@Resource
	private AuthUserService authUserService;
	
	@Resource
	private MessageContentUserService messageContentUserService;
	
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
//		mc.setNotificationType(notificationType);
		mc.setApplicatId(user.getId());
		MessageContentUser record = new MessageContentUser();
		record.setIsFind(1);
		Example example = new Example(MessageContent.class);
		example.createCriteria().andCondition("user_id = ", user.getId());
		this.messageContentUserService.updateByExampleSelective(record ,  example);
		return this.messageContentMapper.selectMessageContentByUserIdAndNotificationType(mc);
	}

	/**
	 * 查询所有具有消息中心权限的的人员
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
	
	
	/**
	 * 添加消息通知人员
	 * 
	 * @author GFF
	 * @date 2017年6月26日上午10:55:37
	 * @param messageTemplate
	 */
	@Override
	public void addMessageNotifyingPeople(MessageContent content, Integer applicantId,Integer postId) {
		
		// 根据表单id查询所有审批人员
//		Set<Integer> ids = getAssessingOfficer(applyId);
		// 查询所有具有消息中心权限的的人员
		Set<Integer> ids = getMessageCenterAuthorizedPersonnel();
		User user = selectPostprincipal(postId);
		if(user != null){
			ids.add(user.getId());
		}
		ids.add(applicantId);
		saveMessageNotification(content, ids);
	}
	
	
	/**
	 * 	获取当前岗位的招聘负责人
	 */
	private User selectPostprincipal(Integer postId){
		return authUserService.getAuthUserByPost(postId, "recruit");
	}

	/**
	 * 
	 * 	查询消息(分页展示)
	 * 
	 */
	@Override
	public Pagination selectQueryMessage(String email, Integer pageNo) {
		User user = this.userService.selectByEamil(email);
		MessageContent mc = new MessageContent();
		mc.setApplicatId(user.getId());
		MessageContentUser record = new MessageContentUser();
		record.setIsFind(1);
		Example example = new Example(MessageContent.class);
		example.createCriteria().andCondition("user_id = ", user.getId());
		this.messageContentUserService.updateByExampleSelective(record ,  example);
		Page<MessageContent> page = PageHelper.startPage(Pagination.cpn(pageNo), 12, true);
		List<MessageContent> list = this.messageContentMapper.selectMessageContentByUserIdAndNotificationType(mc);
		return new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), list);
	}
}
