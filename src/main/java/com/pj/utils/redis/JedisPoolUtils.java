package com.pj.utils.redis;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 项目名称：oa   
 * 类名称：JedisPoolUtils   
 * 类描述：jedis   
 * 创建人：limr   
 * 创建时间：2017年7月15日 下午7:09:06   
 * 修改人：limr   
 * 修改时间：2017年7月15日 下午7:09:06   
 * 修改备注：   
 * @version    
 *
 */
public class JedisPoolUtils {

	private static JedisPool pool;
    static Logger logger= LoggerFactory.getLogger(JedisPoolUtils.class);

    /**
     * 建立连接池 真实环境，一般把配置参数抽取出来。
     * 
     */
    private static void createJedisPool() {

    	//读取相关的配置   redis是配置文件名
        ResourceBundle bundle = ResourceBundle.getBundle("properties/redis");   
        if (bundle == null) {   
            throw new IllegalArgumentException(   
                    "[redis.properties] is not found!");   
        } 
    	

        // 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();

        // 设置最大连接数
        config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
        
        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait")));

        // 设置空间连接
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.maxIdle")));
        
        String ip = bundle.getString("redis.host");  
        String password = bundle.getString("redis.pass");  
        int port = Integer.parseInt(bundle.getString("redis.port"));
        int dbNumber = Integer.parseInt(bundle.getString("redis.db.number"));
      
        // 创建连接池
        pool = new JedisPool(config, ip, port, 10000, password, dbNumber);
        logger.info("redis.ip={} redis.port={},dbNumber={}", new Object[]{ip, port, dbNumber});
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (pool == null)
            createJedisPool();
    }

    /**
     * 获取一个jedis 对象
     * 
     * @return
     */
    public static Jedis getJedis() {

        if (pool == null)
            poolInit();
        return pool.getResource();
    }

    /**
     * 归还一个连接
     * 
     * @param jedis
     */
    public static void returnRes(Jedis jedis) {
        pool.returnResource(jedis);
    }

}
