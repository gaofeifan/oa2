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
	 * @param user当前登录人
	 * @param recruitId
	 * @param reason 
	 * @param state
	 */
	void updateState(User user, Integer recruitId, String reason, Integer state);

	/**
	 * 申请查询
	 * @param companyId 申请人公司
	 * @param username 申请人姓名
	 * @param applyId 申请人id
	 * @return
	 */
	List<FlowRecruit> searchRecruits(Integer companyId, String username, Integer applyId);

	/**
	 * 待办提交回显数据
	 * @param recruitId
	 * @return
	 */
	FlowRecruit getUserInfo(Integer recruitId);

}
