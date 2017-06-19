package com.pj.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.pj.weChat.pojo.AccessToken;
import com.pj.weChat.pojo.QRCode;

import net.sf.json.JSONObject;


public class WeChatUtils {

	public static final String APPID = "wx17f788165832cdc9";
	public static final String APPSECRET = "cdb977a39b0d58c8a0ba5a5e9fab211b";
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static final String CREATE_QR_CODE_URL= "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST"; 
	public static final String GET_QRCODE_PIC= "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET"; 
	public static final String WEIXIN_LOGIN = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public static final String WEIXIN_ACCESS_TOKEN = "WEIXIN_ACCESS_TOKEN";
	/**
	 * 	获取Access GET
	 * @param url
	 * @return
	 */
	public static JSONObject doGetStr(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			if(httpEntity != null){
				String result = EntityUtils.toString(httpEntity, "utf-8");
				jsonObject = JSONObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(response != null){
				try {
					response.close();
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObject;
	}
	
	/**
	 * 	获取Access POST
	 * @param url
	 * @return
	 */
	public static JSONObject doPostStr(String url , String outStr){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(outStr,"utf-8"));
		JSONObject jsonObject = null;
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(), "utf-8");
			jsonObject = JSONObject.fromObject(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(response != null){
				try {
					response.close();
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObject;
	}
	
	/**
	 * 	获取Access token
	 * @return
	 */
	public static AccessToken getAccessToken(){
		AccessToken accessToken = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject != null){
			accessToken.setAccess_token(jsonObject.getString("access_token"));
			accessToken.setExpires_in(jsonObject.getInt("expires_in"));
		}
		return accessToken;
	}
	
	/**
	 * 	获取二维码token
	 * @param parameter		生成二维码的参数 json格式数据
	 * @param token			用户accesss
	 * @return
	 */
	public static QRCode getQRCodeToken(String parameter,String token){
		QRCode code = new QRCode();
		String url = CREATE_QR_CODE_URL.replace("TOKENPOST",token);
		JSONObject jsonObject = doPostStr(url, 	parameter);
		if(jsonObject != null){
			code.setTicket(jsonObject.getString("ticket"));
			code.setUrl(jsonObject.getString("url"));
			code.setExpire_seconds(jsonObject.getInt("expire_seconds"));
		}
		return code;
	}
	
	public static String doGetPic(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity httpEntity = response.getEntity();
				String result = EntityUtils.toString(httpEntity, "utf-8");
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("f://11.jpg")));
				 byte bytes[]=new byte[1024];
				   bytes=result.getBytes();   //新加的
				   int b=result.length();   //改
				  bos.write(bytes,0,b);
				  bos.close();
				return result;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(response != null){
				try {
					response.close();
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 	根据二维码Token获取二维码图片
	 * @param QRCodeToken	二维码token
	 */
	public static void getQRCode_Pic(String QRCodeToken){
		try {
			QRCodeToken = new String(QRCodeToken.getBytes(), "utf-8").toString();
			String url = GET_QRCODE_PIC.replace("TICKET",QRCodeToken);
		doGetPic(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
