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
	void updateState(Integer recruitId, Integer state, String reason);

}