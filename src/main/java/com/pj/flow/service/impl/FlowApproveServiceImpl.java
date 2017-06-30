package com.pj.flow.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.constant.ApplyType;
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
import com.pj.system.mapper.UserMapper;
import com.pj.system.service.DempService;

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
	}
}
