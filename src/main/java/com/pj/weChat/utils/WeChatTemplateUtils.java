package com.pj.weChat.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pj.config.base.constant.ApplyType;
import com.pj.config.base.constant.Constant;
import com.pj.config.base.tool.JedisTool;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.service.FlowEntryService;
import com.pj.flow.service.FlowRecruitService;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;
import com.pj.utils.DateUtils;
import com.pj.weChat.pojo.TemplateData;
import com.pj.weChat.pojo.WxTemplate;

import net.sf.json.JSONObject;

@Component
public class WeChatTemplateUtils {
	@Resource
	private JedisTool jedisTool;
	@Resource
	private FlowRecruitService flowRecruitService;
	@Resource
	private FlowEntryService flowEntryService;
	@Resource
	private UserService userService;

	private Map<String, TemplateData> m;
	{
		m = new HashMap<>();
	}

	// 日志对象
	private static final Logger logger = LoggerFactory.getLogger(WeChatTemplateUtils.class);
	/**
	 * 发送模板消息 appId 公众账号的唯一标识 appSecret 公众账号的密钥 openId 用户标识
	 * @param wxUrl 
	 */
	public void send_template_message(String access_token, Integer userId, String templateMessage_id,
			Map<String, TemplateData> m, String wxUrl) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
		User user = userService.selectByPrimaryKey(userId);
		if(StringUtils.isBlank(user.getOpenid())){
			logger.info("【"+user.getUsername()+" 的openid为null不进行消息的推送】");
			return;
		}
		WxTemplate temp = new WxTemplate();
		if(StringUtils.isNoneBlank(wxUrl)){
			temp.setUrl(wxUrl);
		}else{
			temp.setUrl("http://weixin.qq.com/download");
		}
		temp.setTouser(user.getOpenid());
		temp.setTopcolor("#000000");
		temp.setTemplate_id(templateMessage_id);
		temp.setData(m);
		String jsonString = JSONObject.fromObject(temp).toString();
		JSONObject jsonObject = WeChatUtils.doPostStr(url, jsonString);
		logger.info("微信推送模板消息返回的数据：【"+jsonObject+"】");
		if (null != jsonObject) {
			if (0 == jsonObject.getInt("errcode")) {
				logger.info(user.getUsername()+":的审批消息推送成功");
			}else{
				logger.error(user.getUsername()+":的审批消息推送失败    "+jsonObject.getInt("errcode"));
			}
		}
	}

	/**
	 * 流程待审批提醒
	 * 
	 * @author GFF
	 * @date 2017年8月15日下午3:38:32
	 */
	public void approvalPending(String type, Integer formId, Integer userId) {
		String wxUrl = "http://211.144.1.50:82/approveDetail.html?type=TYPE&applyUserid=APPLYUSERID&formId=FORMID&checkstatus=0&applyType=FORMID";
		String accesstoken = jedisTool.getAccesstoken();
		TemplateData first = new TemplateData();
		first.setColor("#173177");
		first.setValue("您好，您有新的申请待您审批。");
		m.put("first", first);
		TemplateData remark = new TemplateData();
		remark.setColor("#173177");
		remark.setValue("请您及时处理，若未处理将在一天后再次提醒。");
		m.put("remark", remark);
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#173177");
		keyword1.setValue("暂无编号");
		m.put("keyword1", keyword1);
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#173177");
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#173177");
		TemplateData keyword4 = new TemplateData();
		keyword4.setColor("#173177");
		if (type.equals(ApplyType.ENTRY.getApplyType())) {
			FlowEntry flowEntry = this.flowEntryService.selectById(formId);
			keyword2.setValue(flowEntry.getName());
			m.put("keyword2", keyword2);
			keyword3.setValue(DateUtils.convert(flowEntry.getApplyDate()));
			m.put("keyword3", keyword3);
			keyword4.setValue(ApplyType.ENTRY.getApplyName());
			m.put("keyword4", keyword4);
			wxUrl = wxUrl.replaceAll("TYPE", "1")
				 .replaceAll("APPLYUSERID", flowEntry.getApplyId()+"")
				 .replaceAll("FORMID", flowEntry.getId()+"")
				 .replaceAll("applyType", ApplyType.ENTRY.getApplyType());
		} else if (type.equals(ApplyType.RECRUIT.getApplyType())) {
			FlowRecruit flowRecruit = this.flowRecruitService.selectById(formId);
			keyword2.setValue(flowRecruit.getUsername());
			m.put("keyword2", keyword2);
			keyword3.setValue(DateUtils.convert(flowRecruit.getApplyDate()));
			m.put("keyword3", keyword3);
			keyword4.setValue(ApplyType.RECRUIT.getApplyName());
			m.put("keyword4", keyword4);
			wxUrl = wxUrl.replaceAll("TYPE", "6")
			     .replaceAll("APPLYUSERID", flowRecruit.getApplyId()+"")
			     .replaceAll("FORMID", flowRecruit.getId()+"")
			     .replaceAll("applyType", ApplyType.RECRUIT.getApplyType());
		}
		this.send_template_message(accesstoken, userId, Constant.WECHAT_TEMPLATE_APPROVAL_PENDING, m,wxUrl);

	}
}
