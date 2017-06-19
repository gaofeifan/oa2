package com.pj.config.base.timer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.config.base.tool.JedisTool;
import com.pj.system.pojo.User;
import com.pj.system.service.MessageService;
import com.pj.system.service.UserService;
import com.pj.utils.DateUtils;
import com.pj.utils.enums.MessageType;

@Component(value = "messageTimer")
public class MessageTimer {
	@Resource
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Resource
	private JedisTool jedisTool;
	

	private static final Logger logger = LoggerFactory.getLogger(MessageTimer.class);
	
	public void messageDetails(){
		logger.info("定时器执行start....................");
		regular();
		renew();
		logger.info("定时结束......");
    } 
	public void approveMessageTime(){
		logger.info("定时器执行start....................");
//		approveMessageTimeDetails();
		logger.info("定时结束......");
    } 
	
/*	public void approveMessageTimeDetails() {
		List<Approve> approves = this.approveService.findApproveTimeOutmoded(DateUtils.getSomeDate(new Date(), -3,DateUtils.DATE_TIME_FORMAT));
		String accesstoken = this.jedisUtils.getAccesstoken();
		Map<String, TemplateData> m = null;
		UserApply userApply = null;
		for (Approve approve : approves) {
//			User u = this.userService.findUserByCondition(user, false, false);
			User u = this.userService.selectByPrimaryKey(approve.getUserid());
			userApply = this.userApplyService.findMyapplyDetailsByNumber(approve.getApplynumber());
			m = new HashMap<>();
			TemplateData first = new TemplateData();
	        first.setColor("#173177");
	        first.setValue("逾期审批消息提示");
	        m.put("first", first);
	        TemplateData keyword1 = new TemplateData();
	        keyword1.setColor("#173177");
	        keyword1.setValue(userApply != null && userApply.getType() != null ? MessageType.getEnum(userApply.getType()).getDesc()+"申请": "未指定类型");
	        m.put("keyword1", keyword1);
	        TemplateData keyword2 = new TemplateData();
	        keyword2.setColor("#173177");
	        keyword2.setValue(DateUtils.convert(userApply.getApplyDate()));
	        m.put("keyword2", keyword2);
	        TemplateData remark = new TemplateData();
	        remark.setColor("#173177");
	        remark.setValue(userApply.getContent());
	        m.put("remark", remark);
			//	考虑到在执行方法期间accesstoken失效的处理
	        if(StringUtils.isNotBlank(u.getOpenid())){
	        	WeChatTemplateUtils.send_template_message(accesstoken != null ?accesstoken :this.jedisUtils.getAccesstoken(), u.getOpenid() != null ?u.getOpenid() :null ,  MyApplyUtils.WEIXIN_MESSAGE_TEMP_ID_APPROVE, m);
	        	this.approveService.updateApproveMessageStatus(approve);
	        }
		}	
			
			
		System.out.println(approves.size());
	}*/
	//转正
	public void regular(){
		logger.info("转正....................");
		//得到当前时间
		Date date = new Date();
		//当前时间7天后的时间
		String nextDate = DateUtils.getSomeDate(date, 7);
		
		List<User> userList = userService.selectByPbspdate(nextDate);
		for(User user : userList){
			try {
				messageService.insertMessage(user, MessageType.REGULAR_MES.getValue(), new ArrayList<Integer>());
			} catch (Exception e) {
				logger.error("转正异常信息：" + e.getMessage());
			}
		}
	}
	//续签
	public void renew(){
		logger.info("续签....................");
		//得到当前时间
		Date date = new Date();
		//当前日期下一个月的日期
		String nextMonth = DateUtils.getNextMonth(date, 1);
		
		List<User> userList = userService.selectByComppdate(nextMonth);
		for(User user : userList){
			try {
				messageService.insertMessage(user, MessageType.RENEW_MES.getValue(), null);
			} catch (Exception e) {
				logger.error("续签异常信息：" + e.getMessage());
			}
		}
	}
	
	//	清除项目中的二维码
	public void deleteQRCode(HttpServletRequest request){
		String ctxPath = request.getSession().getServletContext().getRealPath("tempPic");
		try {
			FileUtils.deleteDirectory(new File(ctxPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
