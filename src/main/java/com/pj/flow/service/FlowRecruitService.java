package com.pj.flow.service;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.system.pojo.User;

public interface FlowRecruitService extends BaseService<FlowRecruit, Integer> {

	/**
	 * 得到直接领导
	 * @param companyId
	 * @param dempId
	 * @param isCompanyLeader
	 * @param isDempLeader
	 * @return
	 */
	User getLeader(Integer companyId, Integer dempId, Integer isCompanyLeader, Integer isDempLeader);

	/**
	 * 根据主键得到组合数据
	 * @param recruitId
	 * @return
	 */
	FlowRecruit selectById(Integer recruitId);

}
