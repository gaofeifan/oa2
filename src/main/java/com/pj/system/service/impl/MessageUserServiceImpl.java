package com.pj.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.system.mapper.MessageUserMapper;
import com.pj.system.pojo.MessageUser;
import com.pj.system.service.MessageUserService;

@Transactional
@Service
public class MessageUserServiceImpl implements MessageUserService {

	@Resource
	private MessageUserMapper messageUserMapper;
	
	@Override
	public void insertMessageUser(MessageUser messageUser) {
		messageUserMapper.insertSelective(messageUser);
	}

}
