package com.pj.flow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.service.FlowRecruitTodoService;

@Transactional
@Service
public class FlowRecruitTodoServiceImpl extends AbstractBaseServiceImpl<FlowRecruitTodo, Integer> implements FlowRecruitTodoService {

	@Autowired
	private FlowRecruitTodoMapper flowRecruitTodoMapper; 
	
	@Override
	public MyMapper<FlowRecruitTodo> getMapper() {
		return flowRecruitTodoMapper;
	}

	@Override
	public int getNumByState(Integer userId, Integer state) {
		List<FlowRecruitTodo> list = flowRecruitTodoMapper.getListByState(userId, state);
		int num = 0;
		for(int i = 0; i < list.size(); i ++){
			num += list.get(i).getNumber();
		}
		return num;
	}

}
