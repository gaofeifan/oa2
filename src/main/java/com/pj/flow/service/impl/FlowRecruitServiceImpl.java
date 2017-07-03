package com.pj.flow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.RecruitApplyResult;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.service.FlowRecruitService;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.User;

@Transactional
@Service
public class FlowRecruitServiceImpl extends AbstractBaseServiceImpl<FlowRecruit, Integer> implements FlowRecruitService {

	@Autowired
	private FlowRecruitMapper flowRecruitMapper;
	
	@Autowired
	private FlowRecruitTodoMapper flowRecruitTodoMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private DempMapper dempMapper;
	
	@Override
	public MyMapper<FlowRecruit> getMapper() {
		return flowRecruitMapper;
	}
	@Override
	public User getLeader(Integer companyId, Integer dempId, Integer isCompanyLeader, Integer isDempLeader) {
		/**
		 * 1，dempId=null,不是公司领导，找公司负责人
		 * 				    是公司领导，找上级公司的负责人
		 * 2，dempId!=null,不是部门领导，找部门负责人
		 * 				      是部门领导，找组织架构上级负责人
		 */
		User user = new User();
		if(dempId == null){
			if(isCompanyLeader == 0){
				//不是公司领导(查找user表找到该公司下的负责人)
				//（不用）查找部门表找出该公司下所有部门id,再去user表根据部门id找到公司负责人
				user = userMapper.getCompanyLeader(companyId);
			}else{
				//是公司领导
				//查找上级公司id
				int pId = companyMapper.selectByPrimaryKey(companyId).getpId();
				user = userMapper.getCompanyLeader(pId);
			}
		}else{
			if(isDempLeader == 0){
				//不是部门领导
				//查询user表根据dempId得到部门负责人
				user = userMapper.getDempLeader(dempId);
			}else{
				//部门领导
				//查找上级部门id
				int pId = dempMapper.selectByPrimaryKey(dempId).getpId();
				user = userMapper.getDempLeader(pId);
			}
		}
		
		return user;
	}
	@Override
	public FlowRecruit selectById(Integer recruitId) {
		return flowRecruitMapper.selectById(recruitId);
	}
	@Override
	public List<FlowRecruit> selectByQuery(Integer userId, Integer companyId, String username, Integer state) {
		List<FlowRecruit> list = new ArrayList<FlowRecruit>();
		if(state == 4){
			//已审核，需要查出入职时间
			list = flowRecruitMapper.selectTodoByEntryQuery(userId, companyId, username, state);
		}else{
			list = flowRecruitMapper.selectTodoByQuery(userId, companyId, username, state);
		}
		
		return list;
	}
	@Override
	public void updateState(Integer recruitId, String reason, Integer state) {
		FlowRecruit	 recruit = flowRecruitMapper.selectByPrimaryKey(recruitId);
		//0:终止,1:开始,2:提交,3:暂停
		//更新待办表状态
		if(state == 0){
			//把招聘结果改为取消且status改为已删除
			recruit.setResult(RecruitApplyResult.RECRUIT_CANCEL.getState());
			recruit.setStatus(1);
			flowRecruitMapper.updateByPrimaryKeySelective(recruit);
			//修改状态为state的待办表
			flowRecruitTodoMapper.updateState(recruitId, RecruitTodoState.HAS_CANCEL.getState(), reason);
		}else{
			if(state == 3){
				//把招聘结果改为暂停
				recruit.setResult(RecruitApplyResult.RECRUIT_PAUSE.getState());
				flowRecruitMapper.updateByPrimaryKeySelective(recruit);
				//修改状态待办表
				flowRecruitTodoMapper.updateState(recruitId, RecruitTodoState.HAS_PAUSE.getState(), reason);
			}else if(state == 2){
				//若提交，则更新到已提交栏目，招聘中状态减一
				//已提交的信息
				FlowRecruitTodo hasCommitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.HAS_COMMIT.getState());
				if(hasCommitTodo != null){
					hasCommitTodo.setNumber(hasCommitTodo.getNumber() + 1);
					flowRecruitTodoMapper.updateByPrimaryKeySelective(hasCommitTodo);
				}else{
					hasCommitTodo = new FlowRecruitTodo();
					hasCommitTodo.setRecruitId(recruitId);
					hasCommitTodo.setState(RecruitTodoState.HAS_COMMIT.getState());
					hasCommitTodo.setNumber(1);
					flowRecruitTodoMapper.insert(hasCommitTodo);
				}
				//招聘中状态的数据减一,如只有一个则删除，多个则减一
				FlowRecruitTodo inRecruitTodo = flowRecruitTodoMapper.selectByRecruitId(recruitId, RecruitTodoState.IN_RECRUIT.getState());
				int num = inRecruitTodo.getNumber();
				if(num > 1){
					inRecruitTodo.setNumber(num - 1);
					flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
				}else{
					flowRecruitTodoMapper.delete(inRecruitTodo);
				}
				
			}else if(state == 1){
				//开始
				//修改状态待办表
				flowRecruitTodoMapper.updateState(recruitId, RecruitTodoState.IN_RECRUIT.getState(), reason);
			}
		}
		
	}
	@Override
	public List<FlowRecruit> searchRecruits(Integer applyId) {
		
		return flowRecruitMapper.selectByApplyId(applyId);
	}
	@Override
	public FlowRecruit getUserInfo(Integer recruitId) {
		return flowRecruitMapper.getUserInfo(recruitId);
	}

}
