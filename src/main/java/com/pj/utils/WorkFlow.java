package com.pj.utils;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.pj.auth.pojo.AuthAgency;
import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.RecruitApplyReason;
import com.pj.system.pojo.Position;
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
	/**
	 * 	获取招聘流程
	 *	@author 	GFF
	 *	@date		2017年6月27日下午6:54:10
	 */
	public void getRecruitmentFlow(int positionId,int isDempLeader , int isCompanyLeader, int companyId , int dempId ,int recruitApplyReason){
		Position position = getEndPosition(positionId,recruitApplyReason);
		AuthAgency authAgency = authAgencyService.selectApplicantAgency(companyId,dempId ,isCompanyLeader , isDempLeader);
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
}
