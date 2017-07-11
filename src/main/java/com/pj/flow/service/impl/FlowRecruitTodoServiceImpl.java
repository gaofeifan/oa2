package com.pj.flow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.service.FlowRecruitTodoService;

@Transactional
@Service
public class FlowRecruitTodoServiceImpl extends AbstractBaseServiceImpl<FlowRecruitTodo, Integer> implements FlowRecruitTodoService {

	@Autowired
	private FlowRecruitTodoMapper flowRecruitTodoMapper; 
	
	@Autowired
	private FlowEntryMapper flowEntryMapper; 
	
	@Override
	public MyMapper<FlowRecruitTodo> getMapper() {
		return flowRecruitTodoMapper;
	}

	@Override
	public int getNumByState(Integer userId, Integer state) {
		List<FlowRecruitTodo> list = flowRecruitTodoMapper.getListByState(userId, state);
		int num = 0;
		for(int i = 0; i < list.size(); i ++){
			Integer innerNum = list.get(i).getNumber();
			if(innerNum != null){
				num += innerNum;
			}
		}
		return num;
	}
	
	@Override
	public void insertRecruitTodo(Integer applyId, String applyType) {
		/**
		 * 如果applyType是recruit,则是招聘审批通过，
		 * 等于entry则是入职审批通过
		 * 如是招聘中，则先查询同一个招聘id且待办状态是
		 * 招聘中的招聘是否已经存在
		 * 存在则number+1，不存在则新增
		 * 已审核，则会添加审核数据,原来已提交个数减一
		 */
		if("recruit".equals(applyType.trim())){
			FlowRecruitTodo todo = flowRecruitTodoMapper.selectByRecruitId(applyId, RecruitTodoState.IN_RECRUIT.getState());
			if(todo != null){
				int number = todo.getNumber();
				todo.setNumber(number + 1);
				flowRecruitTodoMapper.updateByPrimaryKeySelective(todo);
			}else{
				todo = new FlowRecruitTodo();
				todo.setRecruitId(applyId);
				todo.setNumber(1);
				todo.setState(RecruitTodoState.IN_RECRUIT.getState());
				flowRecruitTodoMapper.insert(todo);
			}
		}else if("entry".equals(applyType.trim())){
			//根据entryId得到招聘id
			Integer recruitId = flowEntryMapper.selectApplyInfoById(applyId).getRecruitId();
			FlowRecruitTodo hasApproveTodo = new FlowRecruitTodo();
			hasApproveTodo.setRecruitId(recruitId);
			hasApproveTodo.setEntryId(applyId);
			hasApproveTodo.setNumber(1);
			hasApproveTodo.setState(RecruitTodoState.HAS_APPROVED.getState());
			flowRecruitTodoMapper.insert(hasApproveTodo);
			//根据招聘id得到已提交的招聘待办信息
			FlowRecruitTodo hasCommitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.HAS_COMMIT.getState());
			int num = hasCommitTodo.getNumber();
			if(num > 1){
				flowRecruitTodoMapper.updateByPrimaryKeySelective(hasCommitTodo);
			}else{
				flowRecruitTodoMapper.delete(hasCommitTodo);
			}
		}
	}

}
