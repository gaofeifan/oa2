package com.pj.utils;
import java.util.Map;

import com.pj.weChat.pojo.TemplateData;
import com.pj.weChat.pojo.WxTemplate;

import net.sf.json.JSONObject;
public class WeChatTemplateUtils {
	 /**
     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
     */
	 @SuppressWarnings("unused")
	public static void send_template_message(String access_token , String openId ,String templateMessage_id, Map<String,TemplateData> m){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
        WxTemplate temp = new WxTemplate();
        temp.setUrl("http://weixin.qq.com/download");
        temp.setTouser(openId);
        temp.setTopcolor("#000000");
        temp.setTemplate_id(templateMessage_id);
        temp.setData(m);
        String jsonString = JSONObject.fromObject(temp).toString();
        JSONObject jsonObject = WeChatUtils.doPostStr(url, jsonString);
        System.out.println(jsonObject);
        int result = 0;
        if (null != jsonObject) {  
             if (0 != jsonObject.getInt("errcode")) {  
                 result = jsonObject.getInt("errcode");
			}
		}
	}
}
