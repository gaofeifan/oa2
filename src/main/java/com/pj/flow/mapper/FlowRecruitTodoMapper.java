package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowRecruitTodo;

public interface FlowRecruitTodoMapper extends MyMapper<FlowRecruitTodo> {

	/**
	 * 根据当前用户id得到所负责的岗位的招聘状态为招聘中的list
	 * @param userId
	 * @param state
	 * @return
	 */
	List<FlowRecruitTodo> getListByState(@Param(value = "userId") Integer userId, @Param(value = "state") Integer state);

	/**
	 * 更新状态
	 * @param recruitId
	 * @param state
	 * @param reason
	 */
	void updateState(@Param(value = "recruitId")Integer recruitId, @Param(value = "state")Integer state, @Param(value = "reason")String reason);

	/**
	 * 根据招聘id和招聘待办状态查询招聘待办
	 * @param recruitId
	 * @param todoState 
	 * @return
	 */
	FlowRecruitTodo selectByRecruitId(@Param(value = "recruitId") Integer recruitId, @Param(value = "todoState") Integer todoState);

}