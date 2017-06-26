package com.pj.message.mapper;

import java.util.List;

import com.pj.config.base.mapper.MyMapper;
import com.pj.message.pojo.MessageContent;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:05:50
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface MessageContentMapper extends MyMapper<MessageContent> {

	/**
	 * 	根据用户与申请的类型查询消息
	 *	@author 	GFF
	 *	@date		2017年6月26日下午4:29:56	
	 * 	@param mc
	 * 	@return
	 */
	List<MessageContent> selectMessageContentByUserIdAndNotificationType(MessageContent mc);

}
