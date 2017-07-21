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
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
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
		 * 如是招聘中，则先查询同一个招聘id且待办状态是
		 * 招聘中的招聘是否已经存在
		 * 存在则number+1，不存在则新增
		 * 已审核，则会添加审核数据,原来已提交个数减一
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
				todo.setNumber(recruit.getNeedNum());
				todo.setState(RecruitTodoState.IN_RECRUIT.getState());
				flowRecruitTodoMapper.insert(todo);
//			}
		}else if(ApplyType.ENTRY.getApplyType().equals(applyType.trim())){
			FlowRecruitTodo flowRecruitTodo = flowRecruitTodoMapper.selectByEntryId(applyId);
			flowRecruitTodo.setState(RecruitTodoState.HAS_APPROVED.getState());
			//修改状态为state的待办表
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
	public void changeState(Integer entryId) {
		//状态改为招聘中
		FlowRecruitTodo flowRecruitTodo = flowRecruitTodoMapper.selectByEntryId(entryId);
		flowRecruitTodo.setState(RecruitTodoState.IN_RECRUIT.getState());
		
		
		FlowRecruitTodo exsitTodo = flowRecruitTodoMapper.selectByRecruitId(flowRecruitTodo.getRecruitId(), RecruitTodoState.IN_RECRUIT.getState());
		if(exsitTodo != null){
			exsitTodo.setNumber(exsitTodo.getNumber() + 1);
			flowRecruitTodoMapper.delete(flowRecruitTodo);
		}else{
			flowRecruitTodoMapper.updateByPrimaryKeySelective(flowRecruitTodo);
		}
	
	}

	@Override
	public Map<Integer, Object> getTodoTips(Integer userId) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		//根据当前用户id得到所负责的岗位的招聘状态为招聘中的个数
		int recruitNum = getNumByState(userId, RecruitTodoState.IN_RECRUIT.getState());
		//根据当前用户id得到所负责的岗位的入职结果为已同意的个数
		int entryNum = flowEntryMapper.getNumByAuthResult(userId, EntryApplyResult.ENTRY_AGREE.getState());
		Integer menuId = null;
		AuthMenu recruitMenu = authMenuMapper.selectByName("管理招聘待办");
		if(recruitMenu != null){
			menuId = recruitMenu.getId();
			map.put(menuId, recruitNum);
		}
		AuthMenu entryMenu = authMenuMapper.selectByName("管理建档待办");
		if(entryMenu != null){
			menuId = entryMenu.getId();
			map.put(menuId, entryNum);
		}
		return map;
	}
		

}
