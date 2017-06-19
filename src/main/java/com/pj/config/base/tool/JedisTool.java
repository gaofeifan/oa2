package com.pj.config.base.tool;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.pj.utils.WeChatUtils;
import com.pj.weChat.pojo.AccessToken;

/**
 *	@author		GFF
 *	@date		2017年6月6日下午2:26:14
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public class JedisTool {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	public static final String WEI_XIN_QR_CODE_VERSION = "WEI_XIN_QR_CODE_VERSION";
	
	/**
	 * 	根据key获取redis中的数据
	 *	@author 	GFF
	 *	@date		2017年6月7日上午11:00:36	
	 * 	@param 		key		redis中的key
	 * 	@param 		time	当time不为null时设置当前redis中的生命周期
	 * 	@return
	 */
	public String getStringData(String key , Integer time){
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] keyByte = serializer.serialize(key);
				byte[] bs = connection.get(keyByte);
				String string = serializer.deserialize(bs);
				if(time != null){
					connection.expire(key.getBytes(), time);
				}
				return string;
			}
		});
	}
	
	/**
	 * 	将数据添加到redis中  
	 *	@author 	GFF
	 *	@date		2017年6月7日上午11:03:18	
	 * 	@param key		redis  key
	 * 	@param value	redis  value
	 * 	@param time		当time不为null时设置当前数据的生命周期
	 */
	public void setStringData(String key , String value ,Integer time){
		this.redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] keyByte = serializer.serialize(key);
				connection.set(key.getBytes(), keyByte);
				if(time != null){
					connection.expire(key.getBytes(), time);
				}
				return null;
			}
		});
	}
	
	public String getAccesstoken() {
		String execute = this.redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] keyByte = serializer.serialize(WeChatUtils.WEIXIN_ACCESS_TOKEN);
				byte[] bs = connection.get(keyByte);
				String access_token = serializer.deserialize(bs);
				if(StringUtils.isNotBlank(access_token)){
					return access_token;
				}else {
					AccessToken accessToken = WeChatUtils.getAccessToken();
					saveLifeTimeData(accessToken.getAccess_token(),WeChatUtils.WEIXIN_ACCESS_TOKEN);
					return accessToken.getAccess_token();
					
				}
			}
		});
		return execute;
	}
	
	public void saveLifeTimeData(String data , String key){
		this.redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] keyByte = serializer.serialize(data);
				connection.set(key.getBytes(), keyByte);
				connection.expire(key.getBytes(), 7200);
				return null;
			}
	});
	}
}

