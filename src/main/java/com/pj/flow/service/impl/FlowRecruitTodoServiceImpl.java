package com.pj.flow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthMenuMapper;
import com.pj.auth.pojo.AuthMenu;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.EntryApplyResult;
import com.pj.config.base.constant.EntryApplyState;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.service.FlowRecruitTodoService;

@Transactional
@Service
public class FlowRecruitTodoServiceImpl extends AbstractBaseServiceImpl<FlowRecruitTodo, Integer> implements FlowRecruitTodoService {

	@Autowired
	private FlowRecruitTodoMapper flowRecruitTodoMapper; 

	@Autowired
	private FlowRecruitMapper flowRecruitMapper;
	
	@Autowired
	private FlowEntryMapper flowEntryMapper;
	
	@Autowired
	private AuthMenuMapper authMenuMapper;
	
	@Override
	public MyMapper<FlowRecruitTodo> getMapper() {
		return flowRecruitTodoMapper;
	}

	@Override
	public int getNumByState(Integer userId, Integer state) {
		List<FlowRecruitTodo> list = flowRecruitTodoMapper.getListByState(userId, state);
//		int num = 0;
//		for(int i = 0; i < list.size(); i ++){
//			Integer innerNum = list.get(i).getNumber();
//			if(innerNum != null){
//				num += innerNum;
//			}
//		}
		return list.size();
	}
	
	@Override
	public void insertRecruitTodo(Integer applyId, String applyType) {
		/**
		 * 如果applyType是recruit,则是招聘审批通过，
		 * 等于entry则是入职审批通过
		 * 招聘通过后保存一条待办信息
		 * 已审核，则会添加审核数据,原来已提交删除
		 */
		if(ApplyType.RECRUIT.getApplyType().equals(applyType.trim())){
//			FlowRecruitTodo todo = flowRecruitTodoMapper.selectByRecruitId(applyId, RecruitTodoState.IN_RECRUIT.getState());
//			if(todo != null){
//				int number = todo.getNumber();
//				todo.setNumber(number + 1);
//				flowRecruitTodoMapper.updateByPrimaryKeySelective(todo);
//			}else{
				FlowRecruit recruit = this.flowRecruitMapper.selectByPrimaryKey(applyId);
				FlowRecruitTodo todo = new FlowRecruitTodo();
				todo.setRecruitId(applyId);
				todo.setStatus(0);
				todo.setNeedNum(recruit.getNeedNum());
				todo.setNumber(recruit.getNeedNum());//个数
				todo.setState(RecruitTodoState.IN_RECRUIT.getState());
				flowRecruitTodoMapper.insert(todo);
//			}
		}else if(ApplyType.ENTRY.getApplyType().equals(applyType.trim())){
			//入职审批通过，查找已提交数据，更改状态为已审批
			FlowRecruitTodo flowRecruitTodo = flowRecruitTodoMapper.selectByEntryId(applyId);
			flowRecruitTodo.setState(RecruitTodoState.HAS_APPROVED.getState());
			flowRecruitTodoMapper.updateByPrimaryKeySelective(flowRecruitTodo);
			
			//根据entryId得到招聘id
//			Integer recruitId = flowEntryMapper.selectApplyInfoById(applyId).getRecruitId();
//			FlowRecruitTodo hasApproveTodo = new FlowRecruitTodo();
//			hasApproveTodo.setRecruitId(recruitId);
//			hasApproveTodo.setEntryId(applyId);
//			hasApproveTodo.setNumber(1);
//			hasApproveTodo.setState(RecruitTodoState.HAS_APPROVED.getState());
//			flowRecruitTodoMapper.insert(hasApproveTodo);
//			//根据招聘id得到已提交的招聘待办信息
//			FlowRecruitTodo hasCommitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.HAS_COMMIT.getState());
//			int num = hasCommitTodo.getNumber();
//			if(num > 1){
//				flowRecruitTodoMapper.updateByPrimaryKeySelective(hasCommitTodo);
//			}else{
//				flowRecruitTodoMapper.delete(hasCommitTodo);
//			}
		}
	}
	
	@Override
	public void changeState(Integer entryId, Integer entryState, Integer entryResult) {
		if(entryResult != null && entryResult == EntryApplyResult.ENTRY_DISAGREE.getState()){
			//入职不同意，删除已提交的数据，招聘中 number+1
			FlowRecruitTodo flowRecruitTodo = flowRecruitTodoMapper.selectByEntryId(entryId);
			flowRecruitTodoMapper.delete(flowRecruitTodo);
			//招聘中的数据
			FlowRecruitTodo inRecruitTodo = flowRecruitTodoMapper.selectByRecruitId(flowRecruitTodo.getRecruitId(), RecruitTodoState.IN_RECRUIT.getState());
			inRecruitTodo.setNumber(inRecruitTodo.getNumber() + 1);
			inRecruitTodo.setStatus(0);
			flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
			
		}else if(entryState == EntryApplyState.IN_OFFER.getState() && entryResult == null){
			//已发offer,删除已审批
			FlowRecruitTodo flowRecruitTodo = flowRecruitTodoMapper.selectByEntryId(entryId);
			flowRecruitTodoMapper.delete(flowRecruitTodo);
		}else if(entryState != null && entryState == EntryApplyState.IN_OFFER.getState() && entryResult == EntryApplyResult.ENTRY_CANCEL.getState()){
			FlowEntry flowEntry = flowEntryMapper.selectByPrimaryKey(entryId);
			//入职撤回，招聘中+1
			FlowRecruitTodo inRecruitTodo = flowRecruitTodoMapper.selectByRecruitId(flowEntry.getRecruitId(), RecruitTodoState.IN_RECRUIT.getState());
			inRecruitTodo.setNumber(inRecruitTodo.getNumber() + 1);
			inRecruitTodo.setStatus(0);
			flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
	}
		
		//状态改为招聘中
//		FlowRecruitTodo flowRecruitTodo = flowRecruitTodoMapper.selectByEntryId(entryId);
//		flowRecruitTodo.setState(RecruitTodoState.IN_RECRUIT.getState());
//		
//		
//		FlowRecruitTodo exsitTodo = flowRecruitTodoMapper.selectByRecruitId(flowRecruitTodo.getRecruitId(), RecruitTodoState.IN_RECRUIT.getState());
//		if(exsitTodo != null){
//			exsitTodo.setNumber(exsitTodo.getNumber() + 1);
//			flowRecruitTodoMapper.delete(flowRecruitTodo);
//		}else{
//			flowRecruitTodoMapper.updateByPrimaryKeySelective(flowRecruitTodo);
//		}
	
	}

	@Override
	public Map<Integer, Object> getTodoTips(Integer userId) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		//根据当前用户id得到所负责的岗位的招聘状态为招聘中的个数
		int recruitNum = getNumByState(userId, RecruitTodoState.IN_RECRUIT.getState());
		//根据当前用户id得到所负责的岗位的入职状态为已发offer，结果是null的个数
		int entryNum = flowEntryMapper.getNumByAuthResult(userId, EntryApplyState.IN_OFFER.getState(), null);
		Integer menuId = null;
		AuthMenu recruitMenu = authMenuMapper.selectByName("招聘待办");
		if(recruitMenu != null){
			menuId = recruitMenu.getId();
			map.put(menuId, recruitNum);
		}
		AuthMenu entryMenu = authMenuMapper.selectByName("建档待办");
		if(entryMenu != null){
			menuId = entryMenu.getId();
			map.put(menuId, entryNum);
		}
		return map;
	}
		

}
