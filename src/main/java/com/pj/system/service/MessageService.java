package com.pj.system.service;

import java.util.List;
import java.util.Map;

import com.pj.system.pojo.Message;
import com.pj.system.pojo.User;
/**
 * 类名称：MessageService   
 * 类描述： 消息相关  
 * 创建人：limr   
 * 创建时间：2016年8月2日 上午10:37:46   
 * 修改人：limr   
 * 修改时间：2016年8月2日 上午10:37:46   
 * 修改备注：   
 * @version    
 *
 */
public interface MessageService {
	/**
	 * 根据查询条件查询
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	List<Message> findMessageList(String type, Integer id);
	
	/**
	 * 添加
	 * @param user
	 * @param type 
	 * @param leaderIds 
	 * @throws Exception 
	 */
	void insertMessage(User user, String type, List<Integer> leaderIds) throws Exception;

	/**
	 * 消息详情
	 * @param message
	 * @param user 
	 * @return 
	 * @throws Exception 
	 */
	User getMessageDetails(Message message, User user) throws Exception;

	/**
	 * 根据查询条件查询未读消息的类型与数量
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	Map<String, Object> getMessageTypeAndNumber(String type, Integer userid);

}
