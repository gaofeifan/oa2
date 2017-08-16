package com.pj.weChat.service.impl;

import java.net.URLEncoder;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pj.config.base.tool.HttpClienTool;
import com.pj.system.service.UserService;
import com.pj.weChat.pojo.OAuthAccessToken;
import com.pj.weChat.pojo.UseValue;
import com.pj.weChat.pojo.UserEntity;
import com.pj.weChat.service.WeiXinService;
import com.pj.weChat.utils.MySSLSocketFactory;

@SuppressWarnings("deprecation")
@Service
@Transactional
public class WeiXinServiceImpl implements WeiXinService {
//	public static CloseableHttpClient httpclient;
	@Resource
	private UserService userService;
	
	private static Logger log = Logger.getLogger(WeiXinServiceImpl.class.getName());
/*	static {
		httpclient = HttpClientBuilder.create().build();
	}
*/
	public static DefaultHttpClient httpclient;
	static {
		httpclient = new DefaultHttpClient();
		ClientConnectionManager ccm = httpclient.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", MySSLSocketFactory.getInstance(), 443));
		httpclient =  new DefaultHttpClient(ccm, httpclient.getParams());
		
	}
	/**
	 * 微信OAuth2.0授权（目前微信只支持在微信客户端发送连接，实现授权）
	 */
	public String getCodeUrl(String appid, String redirect_uri, String scope, String state) throws Exception {
		redirect_uri = URLEncoder.encode(redirect_uri, "utf-8");
		String getCodeUrl = UseValue.getCodeUrl.replace("APPID", appid).replace("REDIRECT_URI", redirect_uri)
				.replace("SCOPE", scope).replace("STATE", state);
		log.info("getCodeUrl Value:" + getCodeUrl);
		return getCodeUrl;
	}

	/**
	 * 微信OAuth2.0授权-获取accessToken(这里通过code换取的网页授权access_token,
	 * 与基础支持中的access_token不同）
	 */
	public OAuthAccessToken getOAuthAccessToken(String appid, String secret, String code) throws Exception {
		String getOAuthAccessToken = UseValue.getOAuthAccessToken.replace("APPID", appid).replace("SECRET", secret)
				.replace("CODE", code);
		log.info("getOAuthAccessToken Value:" + getOAuthAccessToken);
		HttpGet get = HttpClienTool.getGetMethod(getOAuthAccessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		log.info("jsonObject Value:" + jsonObject);
		OAuthAccessToken accessToken = new OAuthAccessToken();
		accessToken.setAccessToken(jsonObject.getString("access_token"));
		accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
		accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
		accessToken.setOpenid(jsonObject.getString("openid"));
		accessToken.setScope(jsonObject.getString("scope"));
		return accessToken;
	}

	/**
	 * 微信OAuth2.0授权-刷新access_token（如果需要）
	 */
	public OAuthAccessToken refershOAuthAccessToken(String appid, String refresh_token) throws Exception {
		String getreferAccessUrl = UseValue.getreferAccessUrl.replace("APPID", appid).replace("REFRESH_TOKEN",
				refresh_token);
		log.info("getreferAccessUrl Value:" + getreferAccessUrl);
		HttpGet get = HttpClienTool.getGetMethod(getreferAccessUrl);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		OAuthAccessToken accessToken = new OAuthAccessToken();
		accessToken.setAccessToken(jsonObject.getString("access_token"));
		accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
		accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
		accessToken.setOpenid(jsonObject.getString("openid"));
		accessToken.setScope(jsonObject.getString("scope"));
		return accessToken;
	}

	/**
	 * 微信OAuth2.0授权-检验授权凭证（access_token）是否有效
	 */
	public boolean isAccessTokenValid(String accessToken, String openId) throws Exception {
		String isOAuthAccessToken = UseValue.isOAuthAccessToken.replace("ACCESS_TOKEN", accessToken).replace("OPENID",
				openId);
		log.info("isOAuthAccessToken Value:" + isOAuthAccessToken);
		HttpGet get = HttpClienTool.getGetMethod(isOAuthAccessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		int returnNum = jsonObject.getIntValue("errcode");
		if (returnNum == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 微信OAuth2.0授权-获取用户信息（网页授权作用域为snsapi_userinfo，
	 * 则此时开发者可以通过access_token和openid拉取用户信息）
	 */
	public UserEntity acceptOAuthUserNews(String accessToken, String openId) throws Exception {
		String getOAuthUserNews = UseValue.getOAuthUserNews.replace("ACCESS_TOKEN", accessToken).replace("OPENID",
				openId);
		log.info("getOAuthUserNews Value:" + getOAuthUserNews);
		HttpGet get = HttpClienTool.getGetMethod(getOAuthUserNews);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		UserEntity entity = new UserEntity();
		entity.setOpenid(jsonObject.getString("openid"));
		entity.setNickname(jsonObject.getString("nickname"));
		entity.setSex(jsonObject.getIntValue("sex"));
		entity.setProvince(jsonObject.getString("province"));
		entity.setCity(jsonObject.getString("city"));
		entity.setCountry(jsonObject.getString("country"));
		entity.setHeadimgurl(jsonObject.getString("headimgurl"));
		return entity;
	}

	/**
	 * 	更新用户微信的openId
	 */
	@Override
	public void updateUserWeChatOpenId(String code, String email) throws Exception {
		OAuthAccessToken token = getOAuthAccessToken(UseValue.AppId, UseValue.AppSecret, code);
		this.userService.updateUserOpenIdByEmail(email,token.getOpenid());
	}

}
