package com.pj.message.service;

import java.util.List;

import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.BaseService;
import com.pj.message.pojo.MessageContent;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:13:21
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface MessageContentService extends BaseService<MessageContent,Integer>{

	/**
	 * 	添加以审批的消息
	 *	@author 	GFF
	 *	@date		2017年6月26日下午5:22:00	
	 * 	@param content
	 * 	@param applyId
	 */
	public void addApprovedMessage(MessageContent content , Integer applyId);
	
	/**
	 * 	添加未审批消息
	 *	@author 	GFF
	 *	@date		2017年6月26日下午5:21:07	
	 * 	@param content
	 */
	public void addUnapprovedMessage(MessageContent content);
	
	/**
	 * 	根据email与类型查询消息
	 *	@author 	GFF
	 *	@date		2017年6月26日下午4:14:17	
	 * 	@param email
	 * 	@param notificationType
	 * 	@return
	 */
	List<MessageContent> selectMessageAllByEamilAndNotificationType(String email, Integer notificationType);

	/**
	 * 	
	 *	@author 	GFF
	 *	@date		2017年7月21日下午5:42:50	
	 * 	@param content
	 * 	@param applicantId
	 * 	@param postId
	 */
	public void addMessageNotifyingPeople(MessageContent content, Integer applicantId, Integer postId);

	/**
	 * 	查询消息(进行分页)
	 *	@author 	GFF
	 *	@date		2017年7月27日上午11:13:21	
	 * 	@param email
	 * 	@param pageNo
	 * 	@return
	 */
	public Pagination selectQueryMessage(String email, Integer pageNo);

}
