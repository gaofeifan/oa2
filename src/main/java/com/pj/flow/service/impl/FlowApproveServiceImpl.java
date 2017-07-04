package com.pj.flow.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.MessageType;
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
	
	@Override
	public MyMapper<FlowApprove> getMapper() {
		return flowApproveMapper;
	}

	@Override
	public List<FlowUserApplication> searchMyApproves(Integer userid, Integer checkstatus) {
		return flowUserApplicationMapper.searchMyApproves(userid, checkstatus);
	}

	@Override
	public void commitApprove(Integer userid, Integer checkstatus, String handleidea, Integer formId,
			String applyType) {
		/**
		 * 先查询中间表
		 * 	根据申请表id和申请类型查询是否存在，如存在不保存不存在则保存，
		 * 再保存审批表
		 */
		FlowApprove flowApprove = new FlowApprove();
		flowApprove.setUserid(userid);
		//根据用户查询职位
		Integer positionId = userMapper.selectByPrimaryKey(userid).getPositionid();
		flowApprove.setPositionid(positionId);
		flowApprove.setCheckstatus(checkstatus);
		flowApprove.setHandleidea(handleidea);
		flowApprove.setIsApprove(1);//审批完状态更改为不可审批
		
		FlowUserApplication flowUserApplication = flowUserApplicationMapper.selectByApplyIdAndType(formId,applyType);
		if(flowUserApplication == null){
			flowUserApplication = new FlowUserApplication();
			flowUserApplication.setFormId(formId);
			//根据申请表id和type得到申请时间和申请人信息
			//根据applyType判断是招聘还是入职
			if (applyType.equals(ApplyType.RECRUIT.getApplyType())) {
				//招聘
				FlowRecruit recruit = flowRecruitMapper.selectById(formId);
				flowUserApplication.setApplyCompanyName(recruit.getCompanyName());
				flowUserApplication.setUserId(recruit.getApplyId());;
				flowUserApplication.setApplyName(recruit.getUsername());
				//申请人部门
				Integer dempId = recruit.getApplyDempId();
				//拼接上父部门的组合
				String dempName = dempService.selectDempParentNameById(dempId);
				flowUserApplication.setApplyDempName(dempName);
				
				flowUserApplication.setApplyTime(recruit.getApplyDate());
				
			}else if(applyType.equals(ApplyType.ENTRY.getApplyType())){
				//入职
				FlowEntry entry = flowEntryMapper.selectApplyInfoById(formId);
				flowUserApplication.setApplyCompanyName(entry.getCompanyName());
				flowUserApplication.setUserId(entry.getApplyId());;
				flowUserApplication.setApplyName(entry.getUsername());
				//申请人部门
				Integer dempId = entry.getDempId();
				//拼接上父部门的组合
				String dempName = dempService.selectDempParentNameById(dempId);
				flowUserApplication.setApplyDempName(dempName);
				
				flowUserApplication.setApplyTime(entry.getApplyDate());
			}
			flowUserApplicationMapper.insertSelective(flowUserApplication);
		}
		//保存审批表
		flowApprove.setApplyId(flowUserApplication.getId());
		flowApprove.setApplyUserId(flowUserApplication.getUserId());
		
		flowApprove.setHandledate(new Date());
		
		flowApproveMapper.insertSelective(flowApprove);
		isApproveComplete(flowUserApplication,applyType);
	}

	/**
	 * 	审批完成的处理
	 *	@author 	GFF
	 *	@date		2017年7月3日下午4:54:04	
	 * 	@param flowUserApplication
	 */
	private void isApproveComplete(FlowUserApplication flowUserApplication , String applyType) {
		FlowApprove record = new FlowApprove();
		record.setApplyId(flowUserApplication.getId());
		List<FlowApprove> list = super.select(record );
		List<Boolean> collect = list.stream().map(approve -> approve.getCheckstatus() != 0).collect(Collectors.toList());
		//	判断是否所有人员都审批完成
		if(collect.contains(false)){
			return ;
		}
		/**
		 * 	保存消息通知
		 */
		
		MessageContent content = new MessageContent();
		if(applyType.equals(ApplyType.RECRUIT.getApplyType())){
			List<FlowRecruit> applyId = this.flowRecruitMapper.selectByApplyId(flowUserApplication.getFormId());
			if(applyId.size() > 0){
				FlowRecruit recruit = applyId.get(0);
				User user = this.userService.selectById(recruit.getApplyId());
				content.setApplicatId(user.getId());
				content.setApplicatName(user.getUsername());
				content.setApplicatPosition(user.getPositionname());
				if(user.getDempid() != null){
					String names = this.dempService.selectDempParentNameById(user.getDempid());
					content.setApplicatDemp(names);
				}
				content.setApplyTime(recruit.getApplyDate());
				content.setTitle(MessageType.RECRUITMENT_MES.getDesc());
				content.setType(MessageType.RECRUITMENT_MES.getValue());
			} 
		}else if(applyType.equals(ApplyType.ENTRY.getApplyType())){
			FlowEntry flowEntry = this.flowEntryMapper.selectApplyInfoById(flowUserApplication.getFormId());
			if(flowEntry != null){
				content.setApplyTime(flowEntry.getApplyDate());
				content.setApplicatName(flowEntry.getUsername());
				content.setTitle(MessageType.ENTRY_MES.getDesc());
				content.setType(MessageType.ENTRY_MES.getValue());
				content.setApplicatId(flowUserApplication.getFormId());
				String names = this.dempService.selectDempParentNameById(flowEntry.getDempId());
				content.setApplicatDemp(names);
				Position position = this.positionService.selectByPrimaryKey(flowEntry.getPositionId());
				if(position != null){
					content.setApplicatPosition(position.getName());
				}
			}
		}
		messageContentService.addApprovedMessage(content , flowUserApplication.getId());
	}

	@Override
	public List<FlowApprove> selectByApplyIdAndType(Integer applyId, String applyType) {
		return flowApproveMapper.selectByApplyIdAndType(applyId, applyType);
	}
}
