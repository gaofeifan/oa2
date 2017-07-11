package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowRecruit;

public interface FlowRecruitMapper extends MyMapper<FlowRecruit> {

	/**
	 * 根据主键得到组合数据
	 * @param id
	 * @return
	 */
	FlowRecruit selectById(@Param(value = "id") Integer id);
	/**
	 * 招聘待办查询
	 * @param userId
	 * @param companyId
	 * @param username
	 * @param state
	 * @return
	 */
	List<FlowRecruit> selectTodoByQuery(@Param(value = "userId") Integer userId, @Param(value = "companyId") Integer companyId, @Param(value = "username") String username, @Param(value = "state") Integer state);
	List<FlowRecruit> selectTodoByEntryQuery(@Param(value = "userId") Integer userId, @Param(value = "companyId") Integer companyId, @Param(value = "username") String username, @Param(value = "state") Integer state);
	/**
	 * 删除
	 * @param id
	 */
	void updateStatus(@Param(value = "id") Integer id);
	
	/**
	 * 申请查询
	 * @param companyId 申请人公司
	 * @param username 申请人姓名
	 * @param applyId 申请人id
	 * @return
	 */
	List<FlowRecruit> selectByApplyId(@Param(value = "companyId") Integer companyId, @Param(value = "username") String username, @Param(value = "applyId") Integer applyId);
	/**
	 * 待办提交回显数据
	 * @param recruitId
	 * @return
	 */
	FlowRecruit getUserInfo(@Param(value = "id")Integer id);
	
	
	FlowRecruit selectEntryNum(Integer entryId);
}