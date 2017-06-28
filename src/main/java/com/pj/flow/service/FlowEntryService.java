package com.pj.flow.service;

import java.util.List;

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
	List<FlowEntry> selectById(Integer entryId);

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
	void sendOffer(String iEamil, String usernames, String hour, Integer applyId, String email);

	/**
	 * 我的招聘申请
	 * @param userId
	 * @return
	 */
	List<FlowEntry> searchEntrys(Integer userId);

}
