package com.pj.message.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.message.mapper.MessageContentMapper;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;

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
	
	@Override
	public MyMapper<MessageContent> getMapper() {
		return messageContentMapper;
	}

	

}
