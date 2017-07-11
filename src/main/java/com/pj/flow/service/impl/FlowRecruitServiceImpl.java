package com.pj.flow.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.ActionLogOperation;
import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.MessageType;
import com.pj.config.base.constant.RecruitApplyResult;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowActionLogMapper;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowActionLog;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowRecruitService;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;

@Transactional
@Service
public class FlowRecruitServiceImpl extends AbstractBaseServiceImpl<FlowRecruit, Integer> implements FlowRecruitService {

	@Autowired
	private FlowActionLogMapper flowActionLogMapper;
	
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

	@Autowired
	private DempService dempService;
	
	@Resource
	private PositionService positionService;
	
	@Autowired
	private MessageContentService messageContentService;
	
	@Autowired
	private AuthAgencyService authAgencyService;
	
	@Autowired
	private FlowUserApplicationMapper flowUserApplicationMapper;
	
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
			//已审核，需要查出入职时间,且公司是入职人公司
			list = flowRecruitMapper.selectTodoByEntryQuery(userId, companyId, username, state);
		}else{
			list = flowRecruitMapper.selectTodoByQuery(userId, companyId, username, state);
		}
		return list;
	}
	
	@Override
	public void updateState(User loginUser, Integer recruitId, String reason, Integer state) {
		FlowRecruit	 recruit = flowRecruitMapper.selectByPrimaryKey(recruitId);
		//保存日志表
//		FlowActionLog log = new FlowActionLog();
//		log.setRecruitId(recruitId);
//		log.setOperater(loginUser.getUsername());
//		log.setOpinion(reason);
		
		//日志的操作记录
		String status = "";
		
		//0:终止,1:开始,2:提交,3:暂停
		//更新待办表状态
		
		if(state == 0){
			//把招聘结果改为取消且status改为已删除
			recruit.setResult(RecruitApplyResult.RECRUIT_CANCEL.getState());
			recruit.setStatus(1);
			flowRecruitMapper.updateByPrimaryKeySelective(recruit);
			//修改状态为state的待办表
			flowRecruitTodoMapper.updateState(recruitId, RecruitTodoState.HAS_CANCEL.getState(), reason);
			
			status = ActionLogOperation.CANCEL_RECRUIT.getValue();
		
		}else{
			if(state == 3){
				//把招聘结果改为暂停
				recruit.setResult(RecruitApplyResult.RECRUIT_PAUSE.getState());
				flowRecruitMapper.updateByPrimaryKeySelective(recruit);
				//修改状态待办表
				flowRecruitTodoMapper.updateState(recruitId, RecruitTodoState.HAS_PAUSE.getState(), reason);
				
				status = ActionLogOperation.PAUSE_RECRUIT.getValue();
			}else if(state == 1){
				//开始
				//修改状态待办表
				flowRecruitTodoMapper.updateState(recruitId, RecruitTodoState.IN_RECRUIT.getState(), reason);
				//TODO
				status = ActionLogOperation.RESTART_RECRUIT.getValue();
			}
//			state == 2在提交入职申请后保存
		}
		insertLog(loginUser, recruitId, reason, status);
		
	}
	private void insertLog(User loginUser, Integer recruitId, String reason, String status) {
		//得到招聘id为recruitId的已有日志记录的entryId(去重)，添加招聘终止的日志
		List<Integer> entryIds = flowActionLogMapper.selectByRecruitId(recruitId);
		for(Integer entryId : entryIds){
			FlowActionLog innerLog = new FlowActionLog();
			innerLog.setEntryId(entryId);
			innerLog.setRecruitId(recruitId);
			innerLog.setStatus(status);
			innerLog.setOperater(loginUser.getUsername());
			innerLog.setOpinion(reason);
			innerLog.setOperateTime(new Date());
			flowActionLogMapper.insert(innerLog);
		}
	}
	@Override
	public List<FlowRecruit> searchRecruits(Integer companyId, String username, Integer applyId) {
		
		return flowRecruitMapper.selectByApplyId(companyId, username, applyId);
	}
	@Override
	public FlowRecruit getUserInfo(Integer recruitId) {
		return flowRecruitMapper.getUserInfo(recruitId);
	}
	
	/**
	 * 	提交招聘申请
	 */
	@Override
	public int insertSelective(FlowRecruit t) {
		int i = super.insertSelective(t);
		//保存申请表和申请人的中间表
		int userId = t.getApplyId();
		//申请人
		User user = this.userMapper.selectByPrimaryKey(userId);
		//申请人部门
		String names = this.dempService.selectDempParentNameById(user.getDempid());
		Company company = companyMapper.selectByPrimaryKey(user.getCompanyid());
		
		//保存中间表
		FlowUserApplication fa = new FlowUserApplication();
		
		fa.setFormId(t.getId());
		fa.setUserId(userId);
		fa.setApplyName(t.getUsername());
		fa.setApplyTime(t.getApplyDate());
		fa.setApplyType(ApplyType.RECRUIT.getApplyType());
		fa.setApplyDempName(names);
		fa.setApplyCompanyName(company.getName());
		
		flowUserApplicationMapper.insertSelective(fa);
		/**
		 * 	保存提交申请的消息通知
		 */
		MessageContent content = new MessageContent();
		content.setApplicatDemp(names);
		Position position = this.positionService.selectByPrimaryKey(user.getPositionid());
		if(position != null){
			content.setApplicatPosition(position.getName());
		}
		content.setApplicatId(userId);
		content.setApplyTime(t.getApplyDate());
		content.setApplicatName(t.getUsername());
		content.setTitle(MessageType.RECRUITMENT_MES.getDesc());
		content.setType(MessageType.RECRUITMENT_MES.getValue());
		messageContentService.addUnapprovedMessage(content);
		
		/**
		 * 	获取审批流程人员
		 */
		Position pt = this.positionService.selectByPrimaryKey(t.getPositionId());
		authAgencyService.selectApplicantAgency(t.getCompanyId(), t.getDempId(), t.getIsCompanyLeader(), t.getIsDempLeader(), pt, t.getApplyReasonType(),fa.getId());
		return i; 
	}
	
	/**
	 * 	根据入职查询招聘
	 */
	@Override
	public FlowRecruit selectEntryNum(Integer entryId) {
		return this.flowRecruitMapper.selectEntryNum(entryId);
	}
	
	

}
