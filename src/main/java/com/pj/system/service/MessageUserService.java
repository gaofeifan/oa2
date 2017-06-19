package com.pj.system.service;

import com.pj.system.pojo.MessageUser;
/**
 * 类名称：MessageUserService   
 * 类描述：通知接收人信息   
 * 创建人：limr   
 * 创建时间：2016年8月4日 上午11:37:03   
 * 修改人：limr   
 * 修改时间：2016年8月4日 上午11:37:03   
 * 修改备注：   
 * @version    
 *
 */
public interface MessageUserService {
	/**
	 * 添加
	 * @param messageUser
	 */
	void insertMessageUser(MessageUser messageUser);

}
