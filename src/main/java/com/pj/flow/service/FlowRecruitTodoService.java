package com.pj.flow.service;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowRecruitTodo;
/**
 * 项目名称：oa   
 * 类名称：FlowRecruitTodoService   
 * 类描述：   
 * 创建人：limr   
 * 创建时间：2017年6月26日 上午11:24:58   
 * 修改人：limr   
 * 修改时间：2017年6月26日 上午11:24:58   
 * 修改备注：   
 * @version    
 *
 */
public interface FlowRecruitTodoService extends BaseService<FlowRecruitTodo, Integer> {

	/**
	 * 根据当前用户id得到所负责的岗位的招聘状态为招聘中的个数
	 * @param userId
	 * @param state
	 * @return
	 */
	int getNumByState(Integer userId, Integer state);

	/**
	 * 审批通过后保存招聘待办表
	 * @param applyId 招聘表id
	 * @param applyType(申请类型,招聘:recruit,入职:entry)
	 */
	void insertRecruitTodo(Integer applyId, String applyType);

}
