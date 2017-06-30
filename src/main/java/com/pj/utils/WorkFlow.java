package com.pj.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pj.auth.pojo.AuthAgency;
import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.RecruitApplyReason;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Position;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;

/**
 *	@author		GFF
 *	@date		2017年6月27日下午6:48:45
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class WorkFlow {

	@Autowired
	private PositionService positionService;
	@Autowired
	private AuthAgencyService authAgencyService;
	@Autowired
	private DempService dempService;
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 	获取招聘流程
	 *	@author 	GFF
	 *	@date		2017年6月27日下午6:54:10
	 */
	public void getRecruitmentFlow(int positionId,int isDempLeader , int isCompanyLeader, int companyId , int dempId ,int recruitApplyReason){
		Position position = getEndPosition(positionId,recruitApplyReason);
		AuthAgency authAgency = authAgencyService.selectApplicantAgency(companyId,dempId ,isCompanyLeader , isDempLeader,position ,recruitApplyReason);
		
		
	}

	/**
	 * 	获取最终的职位节点 
	 *	@author 	GFF
	 *	@date		2017年6月27日下午7:30:18	
	 * 	@param positionId
	 * 	@param recruitApplyReason
	 *  @return 
	 */
	private Position getEndPosition(int positionId, int recruitApplyReason) {
		
		if(recruitApplyReason == RecruitApplyReason.REPLACE.getReason()){
			return positionService.selectSuperiorPositionById(positionId);
		}else{
			return positionService.selectPositionByGrade(1);
		}
	}

	/**
	 * 	查询直属上级所在的机构
	 *	@author 	GFF
	 *	@date		2017年6月29日上午10:59:18	
	 * 	@param userId
	 * 	@return
	 */
//	private AuthAgency selectDirectSupervisor(Integer userId){
//		
//	}
	
	/**
	 * 	根据公司部门获取最终的节点
	 *	@author 	GFF
	 *	@date		2017年6月29日上午11:01:54	
	 * 	@return
	 */
	private AuthAgency selectEndNode(Integer companyId , Integer dempId ,Integer isCompanyLeader,Integer isDempLeader, Position position){
		
		if(isCompanyLeader == 1){
			selectParentCompanyById(companyId);
			Company company = this.companyService.selectParentCompanyById(companyId);
			if(company != null){
				companyId = company.getId();
			}
		}else if(isDempLeader == 1){
			return selectParentDempById(companyId, dempId);
		}
		AuthAgency record = new AuthAgency();
		record.setCompanyId(companyId);
		record.setDempId(dempId);
		List<AuthAgency> list = this.authAgencyService.select(record );
		if(list.size() > 0){
			return list.get(0);
		}
		return this.selectParentDempById(companyId, dempId);
		
	}

	/**
	 * 	查询为公司负责人时最终的机构审批级别
	 *	@author 	GFF
	 *	@date		2017年6月29日下午2:22:03	
	 * 	@param companyId
	 */
	private AuthAgency selectParentCompanyById(Integer companyId) {
		Company company = this.companyService.selectParentCompanyById(companyId);
		if(company != null){
			AuthAgency authAgency = this.authAgencyService.selectAuthAgencyByCompanyIdOrDempId(company.getId(), null, null);
			if(authAgency == null){
				selectParentCompanyById(company.getId());
			}
			return authAgency;
		}
		return null;
	}

	/**
	 * 	查询为部门负责人时最终的审批机构级别
	 *	@author 	GFF
	 *	@date		2017年6月29日下午2:19:54	
	 * 	@param companyId
	 * 	@param dempId
	 * 	@return
	 */
	private AuthAgency selectParentDempById(Integer companyId, Integer dempId) {
		Demp demp = this.dempService.selectParentDempById(dempId);
		if(demp != null){
			dempId = demp.getId();
		}else{
			dempId = null;
			companyId = this.companyService.selectByPrimaryKey(companyId).getId();
		}
		AuthAgency authAgency = this.authAgencyService.selectAuthAgencyByCompanyIdOrDempId(companyId, dempId, null);
		if(authAgency == null){
			if(dempId == null){
				Company company = this.companyService.selectParentCompanyById(companyId);
				if(company != null){
					companyId = company.getId();
				}
			}
			this.selectParentDempById(companyId, dempId);
		}
		return authAgency;
	}
}
