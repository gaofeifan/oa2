package com.pj.system.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.message.controller.MessageContentController;
import com.pj.system.service.SessionProvider;

import net.sf.json.JSONObject;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2016年9月1日 上午9:17:40 
* 类说明 
*/
@Service
@Transactional
public class SessionProviderImpl implements SessionProvider {

	private Logger logger = LoggerFactory.getLogger(MessageContentController.class); 
	public static final String oa_session = "OA_SESSION";
	
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	private Integer exp = 30;
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	@Override
	public void setAttribute(String key, String value) {
		//保存session到reis中
		this.redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] keys = serializer.serialize(key + ":" + oa_session);
				connection.set(keys, value.getBytes());
				connection.expire(keys, 60*exp);
				return null;
			}
		});
	}

	@Override
	public String getAttibute(String key) {
		return this.redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				logger.info("【SessionProviderImpl.getAttibute】  redis key ：="+key + ":" + oa_session);
				byte[] keys = serializer.serialize(key + ":" + oa_session);
				byte[] bs = connection.get(keys);
				String result = serializer.deserialize(bs);
				logger.info("【SessionProviderImpl.getAttibute】  redis value ：=" + result);
				if(StringUtils.isNotBlank(result)){
					JSONObject jsonObject = JSONObject.fromBean(result);
					logger.info("【SessionProviderImpl.getAttibute】  redis value json ：=" + jsonObject);
					Object object = jsonObject.get("email");
					if(object != null){
						return object.toString();
					}
				}
				return null;
			}
		});
	}
}
 