package com.pj.flow.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.service.BaseService;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowOffer;

public interface FlowEntryService extends BaseService<FlowEntry, Integer> {

	/**
	 * 提交申请
	 * @param flowEntry 
	 * @param salarys
	 */
	void insertEntryAndSalary(FlowEntry flowEntry, String salarys);

	/**
	 * 组合查询得到详情
	 * @param entryId
	 * @return
	 */
	FlowEntry selectById(Integer entryId);

	/**
	 * 	根据表单id查询offer详情
	 *	@author 	GFF
	 *	@date		2017年6月26日下午7:31:12	
	 * 	@param applyId
	 * 	@return
	 */
	FlowOffer selectOfferDetailsByApplyIdAndEmail(Integer applyId, String email);

	/**
	 * 	发送offer
	 *	@author 	GFF
	 *	@date		2017年6月27日上午11:01:03	
	 * 	@param iEamil  个人邮箱
	 * 	@param CC	         抄送人
	 * 	@param hour	         时
	 * @param email    当前操作人员的邮箱
	 * @param applyId  申请表单id
	 */
	void sendOffer(String iEamil, String usernames, String hour, Integer applyId, String email , String timeDivision);

	/**
	 * 申请查询
	 * @param companyId 申请人公司
	 * @param username 申请人姓名
	 * @param applyId 申请人id
	 * @return
	 */
	List<FlowEntry> searchEntrys(@Param(value = "companyId") Integer companyId, @Param(value = "username") String username, @Param(value = "applyId") Integer applyId);

	/**
	 * 根据当前用户id得到所负责的岗位
	 * 入职结果为已同意的个数
	 * @param userId
	 * @param result
	 * @return
	 */
	int getNumByAuthResult(Integer userId, int result);
	
	/**
	 * 根据负责的公司和入职人姓名
	 * 以及登录用户所负责的岗位查询
	 * @param userId 当前用户
	 * @param companyId 入职人公司
	 * @param name 入职人姓名
	 * @return
	 */
	List<FlowEntry> selectByTodo(Integer userId, Integer companyId, String name);

}
