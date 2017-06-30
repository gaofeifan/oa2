package com.pj.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<User> approvers = new ArrayList<User>();

	@Override
	public MyMapper<AuthAgency> getMapper() {
		return authAgencyMapper;
	}

	@Override
	public AuthAgency selectApplicantAgency(Integer companyId, Integer dempId, Integer isCompanyLeader, Integer isDempLeader,
			Position position , Integer recruitApplyReason) {
		//	根据直属上级信息查询所属机构
		selectAuthAgency(companyId,dempId,selectEndNode(position.getGrade(),recruitApplyReason) ,isCompanyLeader,isDempLeader);
		if(recruitApplyReason == RecruitApplyReason.STRAT.getReason()){
			addCEO();
		}
		FlowApprove approve = null;
		for (User user : approvers) {
			approve = new FlowApprove();
			approve.setUserid(user.getId());
			approve.setPositionid(user.getPositionid());
			this.flowApproveService.insertSelective(approve);
		}
		return null;
	}

	private void selectAuthAgency(Integer companyId, Integer dempId, Integer grade, Integer isCompanyLeader, Integer isDempLeader) {
		if(isCompanyLeader != 1){
			Demp demp = this.dempService.selectParentDempById(dempId);
			if(demp != null){
				dempId = demp.getId();
			}else{
				isCompanyLeader = 1;
				isDempLeader = 0;
				dempId = null;
				companyId = this.companyService.selectByPrimaryKey(companyId).getId();
			}
		}else{
			Company company = this.companyService.selectParentCompanyById(companyId);
			if(company != null){
				companyId = company.getId();
			}
		}
		AuthAgency authAgency = selectAuthAgencyByCompanyIdOrDempId(companyId, dempId, null);
		if(authAgency == null){
			if(dempId == null){
				Company company = this.companyService.selectParentCompanyById(companyId);
				if(company != null){
					companyId = company.getId();
				}
			}
			this.selectAuthAgency(companyId, dempId, grade, isCompanyLeader, isDempLeader);
		}
		User record = new User();
		record.setCompanyid(authAgency.getCompanyId());
		record.setIsCompanyBoss(isCompanyLeader);
		record.setDempid(authAgency.getDempId());
		record.setIsDepartmentHead(isCompanyLeader);
		record.setIsdelete(0);
		
		List<User> list = this.userService.select(record );
		if(approvers.size() != 0){
			approvers.add(list.get(0));
		}
		if(authAgency.getGrade() > grade ){
			this.selectAuthAgency(authAgency.getCompanyId(), authAgency.getDempId(), grade, isCompanyLeader, isDempLeader);
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
		List<User> list = this.userService.select(u);
		approvers.add(list.get(0));
	}

	/*private void SupervisorANDBelow(Integer companyId, Integer dempId, Position position, Integer grade) {
			// 存在时查询部门负责人
			User user = new User();
			user.setDempid(dempId);
			user.setCompanyid(companyId);
			user.setIsdelete(0);
			user.setIsDepartmentHead(1);
			List<User> list = this.userService.select(user);
			if(list.size() > 0){
				// 判断当前部门 是否维护到了机构权限中
				AuthAgency agency = selectGoBackAuthAgencyBy(companyId, dempId, grade+1);
				if(agency != null){
					User u = list.get(0);
					if (u.getPositionid() == position.getId()) {
						approvers.add(u);
						return;
					} else {
						Position userPosi = this.positionService.selectByPrimaryKey(user.getPositionid());
						// 判断当前用户的职位级别是否比最终审批的职位级别低
						if (userPosi.getGrade() > position.getGrade()) {
							// 继续查询上一级
							Demp demp = this.dempService.selectParentDempById(user.getDempid());
							this.isDempLeader(demp.getCompanyid(), demp.getId(), position, agency.getGrade());
						}
					}
				}
			}
			Demp demp = this.dempService.selectParentDempById(user.getDempid());
			this.isDempLeader(demp.getCompanyid(), demp.getId(), position, grade-1);
	}

	private void isDempLeader(Integer companyId, Integer dempId, Position position, Integer grade) {
		// 获取当前部门的上级
		Demp demp = this.dempService.selectParentDempById(dempId);
		// 判断上级部门是否存在
		if (demp != null) {
			AuthAgency agency = selectGoBackAuthAgencyBy(demp.getCompanyid(), demp.getId(), grade);
			// 判断当前部门的上级 是否维护到了机构权限中
			if (agency != null) {
				// 存在时查询部门负责人
				User user = new User();
				user.setDempid(demp.getId());
				user.setCompanyid(demp.getCompanyid());
				user.setIsdelete(0);
				user.setIsDepartmentHead(1);
				List<User> list = this.userService.select(user);
				// 部门负责人存在时 判断负责人是否为最终审判职位级别
				if (list.size() > 0) {
					User u = list.get(0);
					if (u.getPositionid() == position.getId()) {
						approvers.add(u);
						return;
					} else {
						Position userPosi = this.positionService.selectByPrimaryKey(user.getPositionid());
						// 判断当前用户的职位级别是否比最终审批的职位级别低
						if (userPosi.getGrade() > position.getGrade()) {
							// 继续查询上一级
							demp = this.dempService.selectParentDempById(demp.getId());
							this.isDempLeader(demp.getCompanyid(), demp.getId(), position, agency.getGrade());
						}
					}
				}
			}else{
				demp = this.dempService.selectParentDempById(demp.getpId());
				this.isDempLeader(demp.getCompanyid(), demp.getpId(), position, grade-1);
			}
		}else{
			isCompanyLeader(demp.getCompanyid(), position, grade);
		}
	}*/

	/**
	 * 	当申请为公司负责人时 查询对应的审批(通过递归  直到查询到最终的审批职位(最终的审批职位不存在对应的负责人时 继续查询上上级))
	 *	@author 	GFF
	 *	@date		2017年6月28日下午3:36:51	
	 * 	@param companyId
	 * 	@param position
	 * 	@param grade
	 */
/*	private void isCompanyLeader(Integer companyId, Position position , Integer grade) {
		//	获取当前公司的上级
		Company company = this.companyService.selectParentCompanyById(companyId);
		if (company != null) {
			//	判断上级是否维护到了机构权限中
			AuthAgency agency = selectGoBackAuthAgencyBy(company.getId(), null, grade);
			if(agency != null){
				//	查询该公司的部门负责人
				User record = new User();
				record.setCompanyid(company.getId());
				record.setIsCompanyBoss(1);
				record.setIsdelete(0);
				List<User> list = this.userService.select(record);
				//	判断是否有该用户
				if (list.size() != 0) {
					User user = list.get(0);
					//	判断该用户的职位是否为最终的审批职位
					if (user.getPositionid() == position.getId()) {
						//	添加该用户并返回
						approvers.add(user);
						return;
					} else {
						//	当前用户的职位不是最终的审批节点时
						Position userPosi = this.positionService.selectByPrimaryKey(user.getPositionid());
						//	判断当前用户的职位级别是否比最终审批的职位级别低
						if (userPosi.getGrade() > position.getGrade()) {
								company = this.companyService.selectParentCompanyById(company.getpId());
								this.isCompanyLeader(company.getId(), position, agency.getGrade());
							}
						}
						approvers.add(user);
						return;
					}
			}else{
				//	如果上级公司没有维护到机构权限中	继续查询上上级
				company = this.companyService.selectParentCompanyById(company.getpId());
				this.isCompanyLeader(company.getpId(), position, grade-1);
				
			}
			
		}
	}
	
*/
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

	/*private AuthAgency selectGoBackAuthAgencyBy(Integer companyId ,Integer dempId,Integer grade){
		AuthAgency record = new AuthAgency();
		record.setCompanyId(companyId);
		if(dempId != null){
			record.setDempId(dempId);
		}
		record.setGrade(grade-1);
		
		record.setIsdelete(0);
		List<AuthAgency> list = this.authAgencyMapper.select(record);
		return list.size() > 0 ? list.get(0) : null;
	}*/
}
