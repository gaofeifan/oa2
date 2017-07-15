package com.pj.spider;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.pj.utils.TypeConversionUtils;

import net.sf.json.JSONObject;

/**
 *	@author		GFF
 *	@date		2017年6月9日下午2:29:11
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class Spider {

	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
		requestSimulate();
	}
	
	public static void requestSimulate(){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://www.zhihu.com/login/phone_num");
		RequestConfig config = RequestConfig.custom().setConnectTimeout(10000) // 创建连接的最长时间
                .setConnectionRequestTimeout(10000) // 从连接池中获取到连接的最长时间
                .setSocketTimeout(10 * 10000) // 数据传输的最长时间
                .setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
                .build();
		post.setConfig(config);
		post.setHeader(
				"User-Agen",
				"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Mobile Safari/537.36"
		);
		Map<String,Object> map = new HashMap<>();
		map.put("_xsrf", "bdbdec3247a867cbac0743968b8f0c4e");
		map.put("password", "gao19950901");
		map.put("phone_num", "13716164118");
		map.put("captcha_type", "cn");
		List<NameValuePair> params = getUrlParams(map);
		 UrlEncodedFormEntity formEntity;
		try {
			formEntity = new UrlEncodedFormEntity(params);
			post.setEntity(formEntity);
			CloseableHttpResponse res = httpclient.execute(post);
			if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	            String result = EntityUtils.toString(res.getEntity());// 返回json格式：
	            JSONObject jsonObject = JSONObject.fromObject(result);
	            Map<String, Object> toMap = TypeConversionUtils.jsonToMap(jsonObject);
	            Set<Entry<String,Object>> entrySet = toMap.entrySet();
	            for (Entry<String, Object> entry : entrySet) {
	            	System.out.println(entry.getKey()+"："+entry.getValue());
				}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<NameValuePair> getUrlParams(Map<String, Object> map){
		Set<Entry<String,Object>> entrySet = map.entrySet();
		List<NameValuePair> pairs = new ArrayList<NameValuePair>(); 
		for (Entry<String, Object> entry : entrySet) {
			if(entry.getValue() != null){
				if(!(entry.getValue() instanceof Date)){
					pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}else{
					pairs.add(new BasicNameValuePair(entry.getKey(), com.pj.utils.DateUtils.convert((Date) entry.getValue(),  com.pj.utils.DateUtils.DATE_TIME_FORMAT)));
				}
			}
		}
		return pairs;
	}
}
