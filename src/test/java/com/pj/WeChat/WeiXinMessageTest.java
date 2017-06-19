//package com.pj.WeChat;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.pj.pojo.weixin.TemplateData;
//import com.pj.pojo.weixin.WxTemplate;
//import com.pj.utils.WeiXinUtils;
//
//import net.sf.json.JSONObject;
//
//public class WeiXinMessageTest {
//
//	public static void main(String[] args) {
//		send_template_message(null, null, "oI8ltv0M7mqzaojCOTz8Mh-vPaQY");
//	}
//	    /**
//	     * 发送模板消息
//	     * appId 公众账号的唯一标识
//	     * appSecret 公众账号的密钥
//	     * openId 用户标识
//	     */
//    public static void send_template_message(String appId, String appSecret, String openId) {
//        com.pj.pojo.weixin.AccessToken token = WeiXinUtils.getAccessToken();
//        String access_token = token.getAccess_token();
//        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
//        WxTemplate temp = new WxTemplate();
//        temp.setUrl("http://weixin.qq.com/download");
//        temp.setTouser(openId);
//        temp.setTopcolor("#000000");
////	    temp.setTemplate_id("ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY");
//        temp.setTemplate_id("eerbzwUY2DDUtpfxokGKVfxyXBXarEdU0u6F0uwlH6o");
//        Map<String,TemplateData> m = new HashMap<String,TemplateData>();
//        TemplateData first = new TemplateData();
//        first.setColor("#173177");
//        first.setValue("消息通知");
//        m.put("first", first);
//        TemplateData keyword1 = new TemplateData();
//        keyword1.setColor("#173177");
//        keyword1.setValue("李梦云");
//        m.put("keyword1", keyword1);
//        TemplateData keyword2 = new TemplateData();
//        keyword2.setColor("#173177");
//        keyword2.setValue("2016年11月17日");
//        m.put("keyword2", keyword2);
//        TemplateData remark = new TemplateData();
//        remark.setColor("#173177");
//        remark.setValue("主旨：盘江物流集团  研发部  李梦云  请假申请已经审批完成");
//        m.put("remark", remark);
//        temp.setData(m);
//        String jsonString = JSONObject.fromObject(temp).toString();
//        JSONObject jsonObject = WeiXinUtils.doPostStr(url, jsonString);
//        System.out.println(jsonObject);
//        int result = 0;
//		if (null != jsonObject) {
//			if (0 != jsonObject.getInt("errcode")) {
//				result = jsonObject.getInt("errcode");
//			}
//		}
//	}
//}
