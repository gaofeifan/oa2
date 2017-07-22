package com.pj.flow.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.ApprovalResults;
import com.pj.config.base.constant.EntryApplyResult;
import com.pj.config.base.constant.EntryApplyState;
import com.pj.config.base.constant.MessageType;
import com.pj.config.base.constant.RecruitApplyResult;
import com.pj.config.base.constant.RecruitApplyState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.mapper.FlowApproveMapper;
import com.pj.flow.mapper.FlowEntryMapper;
import com.pj.flow.mapper.FlowRecruitMapper;
import com.pj.flow.mapper.FlowUserApplicationMapper;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowUserApplication;
import com.pj.flow.service.FlowApproveService;
import com.pj.flow.service.FlowRecruitTodoService;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;
import com.pj.system.service.UserService;

/**
 *	@author		GFF
 *	@date		2017年6月26日下午2:15:05
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class FlowApproveServiceImpl extends AbstractBaseServiceImpl<FlowApprove, Integer>
									implements FlowApproveService {
	@Resource
	private MessageContentService messageContentService;
	
	@Resource
	private DempService dempService;

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private FlowApproveMapper flowApproveMapper;
	
	@Resource
	private FlowUserApplicationMapper flowUserApplicationMapper;
	
	@Resource
	private FlowRecruitMapper flowRecruitMapper;
	
	@Resource
	private FlowEntryMapper flowEntryMapper;

	@Resource
	private PositionService positionService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private FlowRecruitTodoService flowRecruitTodoService;
	
	@Override
	public MyMapper<FlowApprove> getMapper() {
		return flowApproveMapper;
	}

	@Override
	public List<FlowUserApplication> searchMyApproves(Integer userid, Integer checkstatus) {
		return flowUserApplicationMapper.searchMyApproves(userid, checkstatus);
	}

//	public void commitApprove(Integer userid, Integer checkstatus, String handleidea, Integer formId,
//			String applyType) {
//		/**
//		 *  更新审批人状态
//		 * 	根据申请表id和申请类型查询是否存在，如存在不保存不存在则保存，
//		 * 再更新审批表，如果是不同意，则审批表的当前用户下面所有流程的审批人都删除
//		 */
//		FlowApprove flowApprove = new FlowApprove();
//		flowApprove.setUserid(userid);
//		//根据用户查询职位
//		Integer positionId = userMapper.selectByPrimaryKey(userid).getPositionid();
//		flowApprove.setPositionid(positionId);
//		flowApprove.setCheckstatus(checkstatus);
//		flowApprove.setHandleidea(handleidea);
//		flowApprove.setIsApprove(1);//审批完状态更改为不可审批
//		
//		FlowUserApplication flowUserApplication = flowUserApplicationMapper.selectByApplyIdAndType(formId,applyType);
//		if(flowUserApplication == null){
//			flowUserApplication = new FlowUserApplication();
//			flowUserApplication.setFormId(formId);
//			//根据申请表id和type得到申请时间和申请人信息
//			//根据applyType判断是招聘还是入职
//			if (applyType.equals(ApplyType.RECRUIT.getApplyType())) {
//				//招聘
//				FlowRecruit recruit = flowRecruitMapper.selectById(formId);
//				flowUserApplication.setApplyCompanyName(recruit.getCompanyName());
//				flowUserApplication.setUserId(recruit.getApplyId());;
//				flowUserApplication.setApplyName(recruit.getUsername());
//				//申请人部门
//				Integer dempId = recruit.getApplyDempId();
//				//拼接上父部门的组合
//				String dempName = dempService.selectDempParentNameById(dempId);
//				flowUserApplication.setApplyDempName(dempName);
//				
//				flowUserApplication.setApplyTime(recruit.getApplyDate());
//				
//			}else if(applyType.equals(ApplyType.ENTRY.getApplyType())){
//				//入职
//				FlowEntry entry = flowEntryMapper.selectApplyInfoById(formId);
//				flowUserApplication.setApplyCompanyName(entry.getCompanyName());
//				flowUserApplication.setUserId(entry.getApplyId());;
//				flowUserApplication.setApplyName(entry.getUsername());
//				//申请人部门
//				Integer dempId = entry.getDempId();
//				//拼接上父部门的组合
//				String dempName = dempService.selectDempParentNameById(dempId);
//				flowUserApplication.setApplyDempName(dempName);
//				
//				flowUserApplication.setApplyTime(entry.getApplyDate());
//			}
//			flowUserApplicationMapper.insertSelective(flowUserApplication);
//		}
//		//保存审批表
//		flowApprove.setApplyId(flowUserApplication.getId());
//		flowApprove.setApplyUserId(flowUserApplication.getUserId());
//		
//		flowApprove.setHandledate(new Date());
//		
//		flowApproveMapper.insertSelective(flowApprove);
//		isApproveComplete(flowUserApplication,applyType);
//	}
	@Override
	public void commitApprove(FlowUserApplication flowUserApplication, Integer userid, Integer checkstatus, String handleidea, Integer formId,
			String applyType) {
		/**
		 *  更新审批人状态
		 * 	根据申请表id和申请类型出所有审批人，再根据审批人得到一条数据
		 * 更新审批表审批意见，如果是不同意，则审批表的当前用户下面所有流程的审批人都删除
		 */
//		//根据申请表id和申请类型得到中间表
//		FlowUserApplication flowUserApplication = flowUserApplicationMapper.selectByApplyIdAndType(formId,applyType);
		//所有该申请表的审核人
		List<FlowApprove> list = flowApproveMapper.selectListByApplyId(flowUserApplication.getId());
		//记录删除开始的位置，不同意时用
		int delStartIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			FlowApprove innerApprove = list.get(i);
			if(userid.equals(innerApprove.getUserid())){//当前审批人
				delStartIndex = i + 1;
				innerApprove.setCheckstatus(checkstatus);
				innerApprove.setHandledate(new Date());
				innerApprove.setHandleidea(handleidea);
				innerApprove.setIsApprove(1);//审批完状态更改为不可审批
				flowApproveMapper.updateByPrimaryKeySelective(innerApprove);
				if(checkstatus .equals(ApprovalResults.NO_AGREE.getValue())){
					//不同意，则接下来流程的审批人信息删除
					for(int j = delStartIndex; j < list.size(); j++){
						flowApproveMapper.delete(list.get(j));
					}
				}else if(checkstatus.equals(ApprovalResults.AGREE.getValue())){
					FlowApprove flowApprove = flowApproveMapper.selectNextApproval(innerApprove.getId(),innerApprove.getApplyId());
					if(flowApprove != null){
						flowApprove.setIsApprove(0);
						this.flowApproveMapper.updateByPrimaryKeySelective(flowApprove);
					}
				}
			}
		}
		isApproveComplete(flowUserApplication,applyType);
	}


	/**
	 * 	审批完成的处理
	 *	@author 	GFF
	 *	@date		2017年7月3日下午4:54:04	
	 * 	@param flowUserApplication
	 */
	private void isApproveComplete(FlowUserApplication flowUserApplication , String applyType) {
		Integer entryState = null;
		Integer entryResult = null;
		Integer entryReResult = null;
		Integer entryReState = null;
		Integer recruitState = null;
		Integer recruitResult = null;
		FlowApprove record = new FlowApprove();
		record.setApplyId(flowUserApplication.getId());
		List<FlowApprove> list = super.select(record );
		List<Boolean> collect = list.stream().map(approve -> approve.getCheckstatus() != 0).collect(Collectors.toList());
		//	判断是否所有人员都审批完成
		if(collect.contains(false)){
			return ;
		}
		List<Boolean> agrees = list.stream().map(approve -> approve.getCheckstatus() == 2).collect(Collectors.toList());
		List<Boolean> disagree = list.stream().map(approve -> approve.getCheckstatus() == 1).collect(Collectors.toList());
		//	审批人员都同意 修改
		Integer formId = flowUserApplication.getFormId();
		if(!agrees.contains(false)){
			//更新待办信息
			flowRecruitTodoService.insertRecruitTodo(formId, applyType);
			//更新申请状态
			entryResult = EntryApplyResult.ENTRY_AGREE.getState();
			entryState = EntryApplyState.ENTRY_APPROVED.getState();
			entryReResult = RecruitApplyResult.ENTRY_AGREE.getState();
			entryReState = RecruitApplyState.ENTRY_APPROVED.getState();
			recruitState = RecruitApplyState.RECRUIT_APPROVED.getState();
			recruitResult = RecruitApplyResult.RECRUIT_AGREE.getState();
			updateForm(applyType, entryState, entryResult, entryReResult, entryReState, recruitState, recruitResult,
					formId);
		}
		if(disagree.contains(true)){
			//更新申请状态
			entryResult = EntryApplyResult.ENTRY_DISAGREE.getState();
			entryState = EntryApplyState.ENTRY_APPROVED.getState();
			entryReResult = RecruitApplyResult.ENTRY_DISAGREE.getState();
			entryReState = RecruitApplyState.ENTRY_APPROVED.getState();
			recruitState = RecruitApplyState.RECRUIT_APPROVED.getState();
			recruitResult = RecruitApplyResult.RECRUIT_DISAGREE.getState();
			updateForm(applyType, entryState, entryResult, entryReResult, entryReState, recruitState, recruitResult,
					formId);
			if(ApplyType.ENTRY.getApplyType().equals(applyType)){
				//入职不同意，删除已提交的数据，招聘中number+1
				flowRecruitTodoService.changeState(flowUserApplication.getFormId(), entryState, entryResult);
			}
		}
		
		/**
		 * 	保存消息通知
		 */
		FlowRecruit recruit = null;
		MessageContent content = new MessageContent();
		if(applyType.trim().equals(ApplyType.RECRUIT.getApplyType())){
			recruit = this.flowRecruitMapper.selectById(flowUserApplication.getFormId());
			User user = this.userService.selectById(recruit.getApplyId());
			content.setApplicatName(user.getUsername());
			content.setApplicatPosition(recruit.getPositionName());
			if (recruit.getApplyDempId() != null) {
				String names = this.dempService.selectDempParentNameById(recruit.getApplyDempId());
				content.setApplicatDemp(names);
			}
			content.setApplyTime(recruit.getApplyDate());
			content.setTitle(MessageType.RECRUITMENT_MES.getDesc());
			content.setType(MessageType.RECRUITMENT_MES.getValue());
			content.setCompanyName(recruit.getCompanyName());
		}else if(applyType.trim().equals(ApplyType.ENTRY.getApplyType())){
			FlowEntry flowEntry = this.flowEntryMapper.selectApplyInfoById(flowUserApplication.getFormId());
			if(flowEntry != null){
				content.setApplyTime(flowEntry.getApplyDate());
				content.setApplicatName(flowEntry.getUsername());
				content.setTitle(MessageType.ENTRY_MES.getDesc());
				content.setType(MessageType.ENTRY_MES.getValue());
				content.setCompanyName(flowEntry.getCompanyName());
				String names = this.dempService.selectDempParentNameById(flowEntry.getDempId());
				content.setApplicatDemp(names);
				Position position = this.positionService.selectByPrimaryKey(flowEntry.getPositionId());
				if(position != null){
					content.setApplicatPosition(position.getName());
				}
				recruit = this.flowRecruitMapper.selectByPrimaryKey(flowEntry.getRecruitId());
			}
		}
		if(recruit.getResult() != null){
			String resultName = RecruitApplyResult.getResultName(recruit.getResult());
			resultName = StringUtils.isNoneBlank(resultName) ? resultName : null;
			content.setResult(resultName);
		}
		if(recruit.getState() != null){
			String stateName = RecruitApplyState.getResultName(recruit.getState());
			stateName = StringUtils.isNoneBlank(stateName) ? stateName : null;
			content.setState(stateName);
		}
		content.setApplicatId(flowUserApplication.getFormId());
		content.setPostName(recruit.getPostName());
		messageContentService.addMessageNotifyingPeople(content ,flowUserApplication.getUserId(), recruit.getPostId());
	}

	/**
	 * 	修改状态
	 */
	private void updateForm(String applyType, Integer entryState, Integer entryResult, Integer entryReResult,
			Integer entryReState, Integer recruitState, Integer recruitResult, Integer formId) {
		if(applyType.equals(ApplyType.ENTRY.getApplyType())){
			FlowEntry flowEntry = flowEntryMapper.selectByPrimaryKey(formId);
			flowEntry.setState(entryState);
			flowEntry.setResult(entryResult);
			flowEntryMapper.updateByPrimaryKeySelective(flowEntry);
			
			FlowRecruit flowRecruit = flowRecruitMapper.selectByPrimaryKey(flowEntry.getRecruitId());
			flowRecruit.setState(entryReState);
			flowRecruit.setResult(entryReResult);
			flowRecruitMapper.updateByPrimaryKeySelective(flowRecruit);
		}else if(applyType.equals(ApplyType.RECRUIT.getApplyType())){
			FlowRecruit flowRecruit = flowRecruitMapper.selectByPrimaryKey(formId);
			flowRecruit.setState(recruitState);
			flowRecruit.setResult(recruitResult);
			flowRecruitMapper.updateByPrimaryKeySelective(flowRecruit);
		}
	}

	@Override
	public List<FlowApprove> selectByApplyIdAndType(Integer applyId, String applyType) {
		return flowApproveMapper.selectByApplyIdAndType(applyId, applyType);
	}

	@Override
	public int selectByCheckstatus(Integer userid, Integer checkstatus) {
		return flowApproveMapper.selectByApprove(userid, checkstatus);
	}

	@Override
	public int selectByUserid(Integer userid) {
		return flowApproveMapper.selectByUserid(userid);
	}

	@Override
	public List<FlowApprove> selectNoApprovalAll() {
		return this.flowApproveMapper.selectNoApprovalAll();
	}
}
