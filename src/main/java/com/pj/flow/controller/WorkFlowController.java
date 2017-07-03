package com.pj.flow.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.auth.pojo.AuthAgency;
import com.pj.auth.service.AuthAgencyService;
import com.pj.config.base.constant.RecruitApplyReason;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;
import com.pj.system.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *	@author		GFF
 *	@date		2017年6月27日下午6:48:45
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Controller
@RequestMapping("/work")
@Api(value="work", description="工作流", position=1)
public class WorkFlowController {

	@Autowired
	private PositionService positionService;
	@Autowired
	private AuthAgencyService authAgencyService;
	@Autowired
	private DempService dempService;
	@Autowired
	private CompanyService companyService;
	@Resource
	private UserService userService;
	/**
	 * 	获取招聘流程
	 *	@author 	GFF
	 *	@date		2017年6月27日下午6:54:10
	 */
	@ApiOperation(value = "招聘待办查询", httpMethod = "GET", response=MappingJacksonValue.class, notes ="招聘待办查询")
	@RequestMapping(value = "/getRecruitmentFlow.do", method = RequestMethod.GET)
	@ResponseBody
	public void getRecruitmentFlow(){
		User user = this.userService.selectByPrimaryKey(2);
		Position position = this.positionService.selectByPrimaryKey(user.getPositionid());
		authAgencyService.selectApplicantAgency(user.getCompanyid(), user.getDempid(), user.getIsCompanyBoss(),user.getIsDepartmentHead(), position, RecruitApplyReason.REPLACE.getReason());
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
