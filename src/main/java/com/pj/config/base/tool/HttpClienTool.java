package com.pj.config.base.tool;

import java.io.IOException;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pj.utils.TypeConversionUtils;

import net.sf.json.JSONObject;

/**
 *	@author		GFF
 *	@date		2017年2月24日下午5:25:06
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class HttpClienTool {

	private static final Logger logger = LoggerFactory.getLogger(HttpClienTool.class);

	public static JSONObject doPostToBase(String url,Object obj){
	    CloseableHttpClient httpclient = getHttpClient();
	    JSONObject response = null;
	    CloseableHttpResponse res = null;
	    try {
	    	HttpPost post = (HttpPost)addRequestContent(new HttpPost(url));
	        Map<String, Object> map = TypeConversionUtils.objectToMap(obj);
	        List<NameValuePair> params = getUrlParams(map);
	        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
	        post.setEntity(formEntity);
	        res = httpclient.execute(post);
	    	if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	            String result = EntityUtils.toString(res.getEntity());// 返回json格式：
	            response = JSONObject.fromObject(result);
	        }
	    } catch (Exception e) {
	    	logger.error(e.getMessage());
	    } finally {
			// 关闭连接 ,释放资源
			try {
				if(httpclient != null){
					httpclient.close();
				}
				if(res != null){
					res.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    return response;
	}
	
	public static String doGetToBase(String url,Object obj){
		CloseableHttpClient httpclient = getHttpClient();
		CloseableHttpResponse res = null;
		try {
			Map<String, Object> map = TypeConversionUtils.objectToMap(obj);
			List<NameValuePair> params = getUrlParams(map);
			HttpGet get = new HttpGet(new URIBuilder(url).addParameters(params).build());
			res = httpclient.execute((HttpGet) addRequestContent(get));
			if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				String result = EntityUtils.toString(res.getEntity());// 返回json格式：
				return result;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 关闭连接 ,释放资源
			try {
				if(httpclient != null){
					httpclient.close();
				}
				if(res != null){
					res.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String doGet(String uri, Map<String, Object> map) {
		List<NameValuePair> params = getUrlParams(map);
		CloseableHttpResponse res = null;
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		try {
			HttpGet get = new HttpGet(new URIBuilder(uri).addParameters(params).build());
			res = httpclient.execute(get);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				EntityUtils.toString(res.getEntity());
				return "200";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			// 关闭连接 ,释放资源
			try {
				if(httpclient != null){
					httpclient.close();
				}
				if(res != null){
					res.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
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
	
	 private static CloseableHttpClient getHttpClient(){
		 return HttpClientBuilder.create().build();
	 }
	 
	 private static HttpRequestBase addRequestContent(HttpRequestBase base){
			// 构建请求配置信息
			RequestConfig config = RequestConfig.custom().setConnectTimeout(10000) // 创建连接的最长时间
	                .setConnectionRequestTimeout(10000) // 从连接池中获取到连接的最长时间
	                .setSocketTimeout(10 * 10000) // 数据传输的最长时间
	                .setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
	                .build();
	        // 设置请求配置信息
			base.setConfig(config);
	        // 模拟浏览器访问，加入浏览器的信息到header
			base.setHeader(
	                "User-Agent",
	                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36");
			return base;
	 }
	 
	 public static JSONObject doGetToMap(String url, Map<String, Object> map) {
			List<NameValuePair> params = getUrlParams(map);
			CloseableHttpResponse res = null;
			CloseableHttpClient httpclient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url + (params != null ? "?" + URLEncodedUtils.format(params, "UTF-8"): ""));
			try {
				res = httpclient.execute(get);
				if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					String result = EntityUtils.toString(res.getEntity());
					return JSONObject.fromObject(result);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);

			} finally {
				// 关闭连接 ,释放资源
				try {
					if(httpclient != null){
						httpclient.close();
					}
					if(res != null){
						res.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	 

		
}
