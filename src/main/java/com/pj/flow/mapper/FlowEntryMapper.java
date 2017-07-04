package com.pj.flow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;

public interface FlowEntryMapper extends MyMapper<FlowEntry> {

	/**
	 * 组合查询得到详情
	 * @param id
	 * @return
	 */
	FlowEntry selectById(@Param(value = "id") Integer id);
	
	/**	根据表单id查询offer详情
	 *	@author 	GFF
	 *	@date		2017年6月26日下午7:35:00	
	 * 	@param applyId
	 */
	FlowOffer selectOfferDetailsByApplyId(@Param(value = "id") Integer id);

	/**
	 * 申请查询
	 * @param companyId 申请人公司
	 * @param username 申请人姓名
	 * @param applyId 申请人id
	 * @return
	 */
	List<FlowEntry> searchEntrys(@Param(value = "companyId") Integer companyId, @Param(value = "username") String username, @Param(value = "applyId") Integer applyId);

	void insertEntry(FlowEntry flowEntry);

	/**
	 * 根据主键得到入职表的申请人信息
	 * @param formId
	 * @return
	 */
	FlowEntry selectApplyInfoById(Integer formId);

	/**
	 * 根据当前用户id得到所负责的岗位
	 * 入职结果为已同意的个数
	 * @param userId
	 * @param result
	 * @return
	 */
	int getNumByAuthResult(@Param(value = "userId") Integer userId, @Param(value = "result") Integer result);

	/**
	 * 根据负责的公司和入职人姓名
	 * 以及登录用户所负责的岗位查询
	 * @param userId 当前用户
	 * @param companyId 入职人公司
	 * @param name 入职人姓名
	 * @return
	 */
	List<FlowEntry> selectByTodo(@Param(value = "userId") Integer userId, @Param(value = "companyId") Integer companyId, @Param(value = "name") String name);

}