package com.pj.auth.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthAgencyMapper;
import com.pj.auth.pojo.AuthAgency;
import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.RecruitApplyReason;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.flow.pojo.FlowApprove;
import com.pj.flow.service.FlowApproveService;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.UserService;

/**
 * @author GFF
 * @date 2017年6月22日下午3:44:49
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Service
@Transactional
public class AuthAgencyServiceImpl extends AbstractBaseServiceImpl<AuthAgency, Integer> implements AuthAgencyService {

	@Autowired
	private AuthAgencyMapper authAgencyMapper;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private UserService userService;
	@Autowired
	private DempService dempService;
	@Autowired
	private FlowApproveService flowApproveService;
	
	private Set<User> approvers = new HashSet<User>();

	@Override
	public MyMapper<AuthAgency> getMapper() {
		return authAgencyMapper;
	}

	@Override
	public AuthAgency selectApplicantAgency(Integer companyId, Integer dempId, Integer isCompanyLeader, Integer isDempLeader,
			Position position , Integer recruitApplyReason) {
		 AuthAgency authAgency = selectAuthAgencyByCompanyIdOrDempId(companyId, dempId, null);
		 Integer isCEO = 0;
		 if(authAgency.getGrade() == 1){
			isCEO = 1;
		 }
		//	根据直属上级信息查询所属机构
		selectAuthAgency(companyId,dempId,selectEndNode(position.getGrade(),recruitApplyReason) ,isCompanyLeader,isDempLeader,isCEO);
		if(recruitApplyReason == RecruitApplyReason.STRAT.getReason()){
			addCEO();
		}
		for (User user : approvers) {
			FlowApprove approve = new FlowApprove();
			approve.setUserid(user.getId());
			approve.setPositionid(user.getPositionid());
			System.out.println(approve.toString());
			this.flowApproveService.insertSelective(approve);
		}
		approvers.clear();
		
		return null;
	}

	private void selectAuthAgency(Integer companyId, Integer dempId, Integer grade, Integer isCompanyLeader, Integer isDempLeader ,Integer isCEO) {
		if(isDempLeader == 1){
			Demp demp = this.dempService.selectParentDempById(dempId);
			if(demp != null){
				dempId = demp.getId();
			}else{
				isCompanyLeader = 1;
				isDempLeader = 0;
				dempId = null;
				companyId = this.companyService.selectByPrimaryKey(companyId).getId();
			}
		}else if(isCompanyLeader == 1){
			Company company = this.companyService.selectParentCompanyById(companyId);
			if(company != null){
				companyId = company.getId();
			}
		}else{
			if(dempId != null){
				isDempLeader = 1;
			}else{
				isCompanyLeader = 1;
			}
		}
		if(companyId == 1 && isCompanyLeader == 1 && isCEO == 1){
			addCEO();
		}else{
			AuthAgency authAgency = selectAuthAgencyByCompanyIdOrDempId(companyId, dempId, null);
			if(authAgency == null){
				if(dempId == null){
					Company company = this.companyService.selectByPrimaryKey(companyId);
					if(company != null){
						isCompanyLeader = 1;
						isDempLeader = 0;
						companyId = company.getId();
					}
					
					
				}
				this.selectAuthAgency(companyId, dempId, grade, isCompanyLeader, isDempLeader , isCEO);
			}else{
				User record = new User();
				record.setCompanyid(authAgency.getCompanyId());
				record.setIsCompanyBoss(isCompanyLeader);
				record.setDempid(authAgency.getDempId());
				record.setIsDepartmentHead(isDempLeader);
				record.setIsdelete(0);
				
				List<User> list = this.userService.select(record );
				if(list.size() != 0){
					approvers.add(list.get(0));
				}
				if(authAgency.getGrade() > grade ){
					this.selectAuthAgency(authAgency.getCompanyId(), authAgency.getDempId(), grade, isCompanyLeader, isDempLeader , isCEO);
				}
			}
		}
	}

	
	private Integer selectEndNode(Integer posiGrade ,Integer recruitApplyReason) {
		if(recruitApplyReason == RecruitApplyReason.REPLACE.getReason()){
			posiGrade = posiGrade > 4 ? 3 : posiGrade - 1;
			posiGrade = posiGrade > 1 ? posiGrade : 1;
			return posiGrade;
		}else{
			return 1;
		}
	}

	/**
	 * 	TODO 添加CEO 审批
	 *	@author 	GFF
	 *	@date		2017年6月28日下午6:20:51
	 */
	private void addCEO() {
		User u = new User();
		u.setIsCompanyBoss(1);
		u.setCompanyid(com.pj.config.base.constant.Company.PJWL);
		List<User> list = this.userService.select(u);
		approvers.add(list.get(0));
	}


	/**
	 * 	根据公司部门查询机构
	 */
	@Override
	public AuthAgency selectAuthAgencyByCompanyIdOrDempId(Integer companyId ,Integer dempId ,Integer grade){
		AuthAgency record = new AuthAgency();
		record.setCompanyId(companyId);
		record.setDempId(dempId);
		record.setGrade(grade);
		return this.authAgencyMapper.selectAuthAgencyByCompanyIdOrDempId(record);
	}

	/**
	 * 	查询所有机构权限
	 */
	@Override
	public Map<Integer,Object> selectAuthAgencyALL() {
		Map<Integer,Object> map = new HashMap<>();
		AuthAgency authAgency = this.authAgencyMapper.selectAuthAgencyMaxGrade();
		Integer grade = authAgency.getGrade();
		for (int i = 1; i <= grade; i++) {
			AuthAgency record = new AuthAgency();
			record.setGrade(i);
			record.setIsdelete(0);
			List<AuthAgency> list = this.authAgencyMapper.select(record );
			map.put(i, list);
		}
		return map;
	}
}
