package com.shen.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 使用连接池,此方式适用于仅使用单个Redis实例的场景。
 * @author shenluguo
 *
 */
public class PoolRedis {
	public static void main(String[] args) {
		// 生成连接池配置信息
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(10);
		config.setMaxTotal(30);
		config.setMaxWaitMillis(3*1000);

		// 在应用初始化的时候生成连接池
		JedisPool pool = new JedisPool(config, "127.0.0.1", 6379);

		// 在业务操作时，从连接池获取连接
		Jedis client = pool.getResource();
		try {
		    // 执行指令
		    String result = client.set("key-string", "Hello, Redis!");
		    System.out.println( String.format("set指令执行结果:%s", result) );
		    String value = client.get("key-string");
		    System.out.println( String.format("get指令执行结果:%s", value) );
		} catch (Exception e) {
		    // TODO: handle exception
			e.printStackTrace();
		} finally {
		    // 业务操作完成，将连接返回给连接池
		    if (null != client) {
		        pool.returnResource(client);
		    }
		} // end of try block

		// 应用关闭时，释放连接池资源
		pool.destroy();
	}
}
