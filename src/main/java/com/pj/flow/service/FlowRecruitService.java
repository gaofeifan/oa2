package com.pj.flow.service;

import java.util.List;

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

	/**
	 * 招聘待办查询
	 * @param userId
	 * @param companyId
	 * @param username
	 * @param state
	 * @return
	 */
	List<FlowRecruit> selectByQuery(Integer userId, Integer companyId, String username, Integer state);

	/**
	 * 修改招聘待办状态
	 * @param recruitId
	 * @param reason 
	 * @param state
	 */
	void updateState(Integer recruitId, String reason, Integer state);

	/**
	 * 我的招聘申请
	 * @param applyId
	 * @return
	 */
	List<FlowRecruit> searchRecruits(Integer applyId);

}
