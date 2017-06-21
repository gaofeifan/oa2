package com.pj.message.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.message.mapper.MessageContentUserMapper;
import com.pj.message.pojo.MessageContentUser;
import com.pj.message.service.MessageContentUserService;

/**
 *	@author		GFF
 *	@date		2017年6月20日下午6:18:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class MessageContentUserImpl extends AbstractBaseServiceImpl<MessageContentUser, Integer>
		implements MessageContentUserService {

	@Resource
	private MessageContentUserMapper messageContentUserMapper;
	
	@Override
	public MyMapper<MessageContentUser> getMapper() {
		return messageContentUserMapper;
	}

}
