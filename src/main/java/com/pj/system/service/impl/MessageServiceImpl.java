package com.pj.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.tool.JedisTool;
import com.pj.system.mapper.MessageMapper;
import com.pj.system.mapper.MessageUserMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.Message;
import com.pj.system.pojo.MessageQuery;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.MessageService;
import com.pj.system.service.RecordService;
import com.pj.system.service.UserService;
import com.pj.utils.DateUtils;
import com.pj.utils.enums.MessageType;

@Transactional
@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	private UserService userService;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private MessageUserMapper messageUserMapper;

	@Resource
	private RecordService recordService;
	
	@Resource
	private DempService dempService;
	
	@Resource
	private JedisTool jedisUtils;
	public List<Message> findMessageList(String type) throws Exception {
		MessageQuery example = new MessageQuery();
		if(StringUtils.isNotBlank(type)){
			example.createCriteria().andTypeEqualTo(type);
		}
		List<Message> messages = messageMapper.selectByExample(example );
		return messages;
	}

	@Override
	public void insertMessage(User user, String type, List<Integer> leaderIds) throws Exception {
		Message message = new Message();
		message.setUserId(user.getId());
		
		message.setDate(new Date());
		message.setType(type);
		message.setUsername(user.getUsername());
		if(StringUtils.isNotBlank(type)){
			if(MessageType.ENTRY_MES.getValue().equals(type)){
				//入职
				message.setContent("主旨：" + user.getCompanyname() + "  " 
						+ user.getDempname() + "  " +user.getUsername() + "  已入职");
			}else if(MessageType.REGULAR_MES.getValue().equals(type)){
				//转正
				message.setContent("主旨：" + user.getCompanyname() + "  " 
						+ user.getDempname() + "  " +user.getUsername() + "  待转正");
				
			}else if(MessageType.CHANGE_MES.getValue().equals(type)){
				//异动
				message.setContent("主旨：" + user.getCompanyname() + "  " 
						+ user.getDempname() + "  " +user.getUsername() + "  异动申请已经审批完成");
			}else if(MessageType.DIMISSION_MES.getValue().equals(type)){
				//离职
				message.setContent("主旨：" + user.getCompanyname() + "  " 
						+ user.getDempname() + "  " +user.getUsername() + "  离职申请已经审批完成");
			}else if(MessageType.RENEW_MES.getValue().equals(type)){
				//续签
				message.setContent("主旨：" + user.getCompanyname() + " " 
						+ user.getDempname() + "  " + user.getUsername() + "  劳动合同于" + DateUtils.convert(user.getComppdate(), DateUtils.DATE_FORMAT_C) + "到期");
			
			}else if(MessageType.LEAVE_MES.getValue().equals(type)){
				//续签
				message.setContent("主旨：" + user.getCompanyname() + "  " 
						+ user.getDempname() + "  " + user.getUsername() + "  请假申请已经审批完成" );
			
			}
			message.setIsread(0);//未读
			message.setApplyNumber(user.getApplyNumber());
			messageMapper.insertSelective(message);
			//保存接收通知的用户表
//			savaMessageUser(user, message, leaderIds,type);
		}
		
		
	}
	/*
	private void savaMessageUser(User user, Message message, List<Integer> leaderIds,String type) {
		  //盘江公司id
		String pj_companyid = PropertiesUtil.getInstance().getProperty("pj_companyid");
		//中亚宝丰公司id
		String zybf_companyid = PropertiesUtil.getInstance().getProperty("zybf_companyid");
		//达达牛id
		String ddn_companyid = PropertiesUtil.getInstance().getProperty("ddn_companyid");
		//邮客id
		String yk_companyid = PropertiesUtil.getInstance().getProperty("yk_companyid");
		
		//胡菁菁id
		String personnel_post_staffRelation_id = PropertiesUtil.getInstance().getProperty("personnel_post_staffRelation_id");
		//李婉怡   	 岗位id		CHO
		String personnel_post_CHO_id = PropertiesUtil.getInstance().getProperty("personnel_post_CHO_id");
		//孙雪娇id
		String personnel_post_paymentPerformance_id = PropertiesUtil.getInstance().getProperty("personnel_post_paymentPerformance_id");
		//秦志浩id
		String personnel_post_ITDirector_id = PropertiesUtil.getInstance().getProperty("personnel_post_ITDirector_id");
		//孙志id
		String personnel_post_zybfIT_id = PropertiesUtil.getInstance().getProperty("personnel_post_zybfIT_id");
		//陈希id
		String personnel_post_administration_id = PropertiesUtil.getInstance().getProperty("personnel_post_administration_id");
		//	行政前台    于洋
		String personnel_post_reception_id = PropertiesUtil.getInstance().getProperty("personnel_post_reception_id");
		User personnel_user_staffRelation = null;
		User personnel_user_CHO = null;
		User personnel_user_paymentPerformance = null;
		User personnel_user_ITDirector = null;
		User personnel_user_zybfIT = null;
		User personnel_user_administration = null;
		User personnel_post_reception = null;
		if(personnel_post_staffRelation_id != null && !personnel_post_staffRelation_id.equals("")){
			personnel_user_staffRelation = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.RENSHI_DEMP ,Integer.decode(personnel_post_staffRelation_id.trim()));
		}
		if(personnel_post_reception_id != null && !personnel_post_reception_id.equals("")){
			personnel_post_reception = this.userService.findUserByCompanyAndDempAndPost(null , "" ,Integer.decode(personnel_post_reception_id.trim()));
		}
		if(personnel_post_CHO_id != null && !personnel_post_CHO_id.equals("")){
			personnel_user_CHO = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.RENSHI_DEMP ,Integer.decode(personnel_post_CHO_id.trim()));
		}
		if(personnel_post_paymentPerformance_id != null && !personnel_post_paymentPerformance_id.equals("")){
			personnel_user_paymentPerformance = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.RENSHI_DEMP ,Integer.decode(personnel_post_paymentPerformance_id.trim()));
		}
		if(personnel_post_ITDirector_id != null && !personnel_post_ITDirector_id.equals("")){
			personnel_user_ITDirector = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.RENSHI_DEMP ,Integer.decode(personnel_post_ITDirector_id.trim()));
		}
		if(personnel_post_zybfIT_id != null && !personnel_post_zybfIT_id.equals("")){
			personnel_user_zybfIT = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.RENSHI_DEMP ,Integer.decode(personnel_post_zybfIT_id.trim()));
		}
		if(personnel_post_administration_id != null && !personnel_post_administration_id.equals("")){
			personnel_user_administration = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.RENSHI_DEMP ,Integer.decode(personnel_post_administration_id));
		}

		leaderIds.add(personnel_user_staffRelation != null?personnel_user_staffRelation.getId():null);			//	胡箐箐
		leaderIds.add(personnel_user_paymentPerformance != null ?personnel_user_paymentPerformance.getId():null);			//	孙雪娇
		//员工所在公司id
		int companyid = user.getCompanyid();
		
		if(companyid == Integer.decode(pj_companyid) || pj_companyid.equals(companyid)){
			//张总
			String pj_supremo_post_id = PropertiesUtil.getInstance().getProperty("pj_supremo_post_id");
			User pj_supremo = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.ZJL_DEMP ,Integer.decode(pj_supremo_post_id));
			//石总
			String pj_supremoAid_postid = PropertiesUtil.getInstance().getProperty("pj_supremoAid_postid");
			User pj_supremoAid = this.userService.findUserByCompanyAndDempAndPost(Integer.decode(pj_companyid) , MyApplyUtils.ZJL_DEMP ,Integer.decode(pj_supremoAid_postid));
			leaderIds.add(pj_supremo != null ? pj_supremo.getId() : null);
			leaderIds.add(pj_supremoAid != null ? pj_supremoAid.getId() : null);
			if((MessageType.ENTRY_MES.getValue().equals(type) || MessageType.DIMISSION_MES.getValue().equals(type))){
				leaderIds.add(personnel_user_ITDirector != null ? personnel_user_ITDirector.getId(): null);
				leaderIds.add(personnel_user_administration != null ? personnel_user_administration.getId():null);
				
			}else if( MessageType.REGULAR_MES.getValue().equals(type)){
				leaderIds.add(personnel_user_CHO != null ? personnel_user_CHO.getId(): null);			//	李婉怡
			}else if(MessageType.LEAVE_MES.getValue().equals(type)){
				leaderIds.add(personnel_post_reception != null ? personnel_post_reception.getId():null);
				leaderIds.remove(pj_supremo);
				leaderIds.remove(pj_supremoAid);
			}
		}else if(companyid == Integer.decode(zybf_companyid) || zybf_companyid.equals(companyid)){
			//王学辉
			String zybf_vicesupremo_post_id = PropertiesUtil.getInstance().getProperty("zybf_vicesupremo_post_id");
			User zybf_vicesupremo = this.userService.findUserByCompanyAndDempAndPost(companyid , MyApplyUtils.MANAGE_DEMP ,Integer.decode(zybf_vicesupremo_post_id));
			//陈淼
			String zybf_vicemanager_post_id = PropertiesUtil.getInstance().getProperty("zybf_vicemanager_post_id");
			User zybf_vicemanager = this.userService.findUserByCompanyAndDempAndPost(companyid , MyApplyUtils.MANAGE_DEMP ,Integer.decode(zybf_vicemanager_post_id));
			leaderIds.add(zybf_vicesupremo != null ? zybf_vicesupremo.getId():null);
			leaderIds.add(zybf_vicemanager != null ? zybf_vicemanager.getId():null);
			leaderIds.add(personnel_user_CHO != null ? personnel_user_CHO.getId(): null);			//	李婉怡
			if((MessageType.ENTRY_MES.getValue().equals(type) || MessageType.DIMISSION_MES.getValue().equals(type))){
				leaderIds.add(personnel_user_ITDirector != null ? personnel_user_ITDirector.getId():null);
				leaderIds.add(personnel_user_administration != null ? personnel_user_administration.getId():null);
				leaderIds.add(personnel_user_zybfIT != null ? personnel_user_zybfIT.getId() : null);
				
			}else if(MessageType.CHANGE_MES.getValue().equals(type) || MessageType.REGULAR_MES.getValue().equals(type)){
				
			}else if(MessageType.LEAVE_MES.getValue().equals(type)){
				leaderIds.add(personnel_post_reception != null ? personnel_post_reception.getId():null);
				leaderIds.remove(zybf_vicesupremo);
				leaderIds.remove(zybf_vicemanager);
			}else if(MessageType.RENEW_MES.getValue().equals(type)){
				
			}
			
		}else if(companyid == Integer.decode(ddn_companyid) || ddn_companyid.equals(companyid)){
			//段国强
			String dgq_vicesupremo_post_id = PropertiesUtil.getInstance().getProperty("dgq_vicesupremo_post_id");
			User dgq_vicesupremo = this.userService.findUserByCompanyAndDempAndPost(companyid , MyApplyUtils.MANAGE_DEMP ,Integer.decode(dgq_vicesupremo_post_id));
			leaderIds.add(dgq_vicesupremo != null ? dgq_vicesupremo.getId() : null);
			leaderIds.add(personnel_user_CHO != null ? personnel_user_CHO.getId(): null);			//	李婉怡
			if((MessageType.ENTRY_MES.getValue().equals(type) || MessageType.DIMISSION_MES.getValue().equals(type))){
				leaderIds.add(personnel_user_ITDirector != null ? personnel_user_ITDirector.getId(): null);
				leaderIds.add(personnel_user_administration != null ? personnel_user_administration.getId():null);
			}else if(MessageType.CHANGE_MES.getValue().equals(type) || MessageType.REGULAR_MES.getValue().equals(type)){
				
			}else if(MessageType.LEAVE_MES.getValue().equals(type)){
				leaderIds.add(personnel_post_reception != null ? personnel_post_reception.getId():null);
				leaderIds.remove(dgq_vicesupremo);
			}else if(MessageType.RENEW_MES.getValue().equals(type)){
				
			}
		}else if(companyid == Integer.decode(yk_companyid) || yk_companyid.equals(companyid)){
			//邵学初
			String sxc_vicemanager_post_id = PropertiesUtil.getInstance().getProperty("sxc_vicemanager_post_id");
			User sxc_vicemanager = this.userService.findUserByCompanyAndDempAndPost(companyid , MyApplyUtils.MANAGE_DEMP ,Integer.decode(sxc_vicemanager_post_id));
			leaderIds.add(sxc_vicemanager != null ?sxc_vicemanager.getId() : null);
			leaderIds.add(personnel_user_CHO != null ? personnel_user_CHO.getId(): null);			//	李婉怡
			leaderIds.add(personnel_user_ITDirector != null ? personnel_user_ITDirector.getId(): null);
			if((MessageType.ENTRY_MES.getValue().equals(type) || MessageType.DIMISSION_MES.getValue().equals(type))){
				
			}else if(MessageType.CHANGE_MES.getValue().equals(type) || MessageType.REGULAR_MES.getValue().equals(type)){
				
			}else if(MessageType.LEAVE_MES.getValue().equals(type)){
				leaderIds.remove(sxc_vicemanager);
			}else if(MessageType.RENEW_MES.getValue().equals(type)){
				
			}
		}else{
			leaderIds.add(personnel_user_CHO != null ? personnel_user_CHO.getId(): null);			//	李婉怡
			if((MessageType.ENTRY_MES.getValue().equals(type) || MessageType.DIMISSION_MES.getValue().equals(type))){
				
			}else if(MessageType.CHANGE_MES.getValue().equals(type) || MessageType.REGULAR_MES.getValue().equals(type)){
				
			}else if(MessageType.LEAVE_MES.getValue().equals(type)){
				
			}else if(MessageType.RENEW_MES.getValue().equals(type)){
				
			}
			
		}
			
		
		Map<String,TemplateData> m = null;
		for(Integer leaderId : leaderIds){
			MessageUser messageUser = new MessageUser();
			messageUser.setUserId(leaderId);
			messageUser.setMessageId(message.getId());
			messageUserMapper.insertSelective(messageUser);
			Record record = new Record();
			record.setUserid(leaderId);
			record.setMessageid(message.getId());
			this.recordService.saveRecord(record);
//			User u = new User(leaderId);
			String openId = null;
			if(leaderId != null){
				openId = this.userService.selectById(leaderId).getOpenid();
			}
			if(StringUtils.isNotBlank(openId)){
				String accesstoken = this.jedisUtils.getAccesstoken();
				    m = new HashMap<String,TemplateData>();
			        TemplateData first = new TemplateData();
			        first.setColor("#173177");
			        first.setValue("消息通知");
			        m.put("first", first);
			        TemplateData keyword1 = new TemplateData();
			        keyword1.setColor("#173177");
			        keyword1.setValue(message.getUsername());
			        m.put("keyword1", keyword1);
			        TemplateData keyword2 = new TemplateData();
			        keyword2.setColor("#173177");
			        keyword2.setValue(DateUtils.convert(message.getDate()));
			        m.put("keyword2", keyword2);
			        TemplateData remark = new TemplateData();
			        remark.setColor("#173177");
			        remark.setValue(message.getContent());
			        m.put("remark", remark);
				WeChatTemplateUtils.send_template_message(accesstoken, openId, MyApplyUtils.WEIXIN_MESSAGE_TEMP_ID_MESSAGE,m);
			}
		}
	}
	
	public User getMessageDetails(Message message , User u) throws Exception {
		String subNumber = "";
		if(message.getApplyNumber() != null && !message.getApplyNumber().equals("")){
			subNumber = message.getApplyNumber().substring(0, 2);
		}
		User user = userMapper.selectByPrimaryKey(message.getUserId());
		if(MessageType.REGULAR_MES.getValue().equals(message.getType())){
			user.setRegularDate(this.userMapper.selectByPrimaryKey(message.getUserId()).getPbspdate());
			user.setType(MessageType.REGULAR_MES.getValue());
		}else if(MyApplyUtils.NUMBER_CHANGE.equals(subNumber)){
			Change change = this.changeService.findChangeByNumber(message.getApplyNumber());
			User us = this.userService.selectById(change.getUserid());
			ChangeDemand changeDemand = this.changeMapper.selectManyNameByChange(change);
			user.setChangeDate(change.getChangesdate());
			user.setChangeDetails(us.getDempname() + " " + us.getPostname() +" / "+ changeDemand.getDempName() +" " + changeDemand.getNowPostName() );
			user.setType(MessageType.CHANGE_MES.getValue());
		}else if(MyApplyUtils.NUMBER_LEAVE.equals(subNumber)){
			Leave leave = this.leaveService.findLeaveByNumber(message.getApplyNumber());
			user.setLeaveHours(leave.getLeavedate());
			user.setLeaveReason(leave.getLeavecause());
			user.setLeaveType(leave.getLeavetype());
			user.setType(MessageType.LEAVE_MES.getValue());
		}else if(MyApplyUtils.NUMBER_DIMISSION.equals(subNumber)){
//			Leave leave = this.leaveService.findLeaveByNumber(message.getApplyNumber());
//			user.setLeavedate(leave.getLeavedate() != null ? leave.getLeavedate():null);
			user.setType(MessageType.DIMISSION_MES.getValue());
		}else if(MessageType.ENTRY_MES.getValue().equals(message.getType())){
			user.setType(MessageType.ENTRY_MES.getValue());
		}else{
			user.setType(MessageType.RENEW_MES.getValue());
		}
//		message.setIsread(1);//设置为已读
		List<Record> records = recordService.findRecordsBymessageId(message.getId());
		for (Record record : records) {
			if(record.getUserid() != null){
				if(record.getUserid() == u.getId() || record.getUserid().equals(u.getId())){
					record.setIsfind(1);
					recordService.updateRecord(record);
				}
			}
		}
//		messageMapper.updateIsreadByPrimaryKey(message);
		return user;
	}

	public List<Message> findMessageList(String type, Integer id) {
		Message message = new Message();
		if(type != null && !type.trim().equals("")){
			message.setType(type);
		}
		message.setUserId(id);
		List<Message> list = this.messageMapper.selectMessageByUserIdAndType(message);
		return list;
	}

	public Map< String, Object> getMessageTypeAndNumber(String type, Integer userid) {
		List<Message> list = this.findMessageList(type, userid);
		Map< String, Object> typeNumber = new HashMap<>();
		for (Message message : list) {
			if(message.getIsread() != 1){
				if(typeNumber.containsKey(message.getType())){
					int number = (int) typeNumber.get(message.getType());
					typeNumber.put(message.getType(),++number );
				}else{
					typeNumber.put(message.getType(), 1);
				}
			}
		}
		return typeNumber;
	}*/

	@Override
	public List<Message> findMessageList(String type, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getMessageDetails(Message message, User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getMessageTypeAndNumber(String type, Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
