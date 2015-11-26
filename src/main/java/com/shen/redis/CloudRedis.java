package com.shen.redis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用连接池+分布式
 * 
 * 在规模较大的系统中，往往会有多个Redis实例做负载均衡。并且还实现主从备份，当主实例发生故障时，切换至从实例提供服务。
 * 类似于Memcached的客户端，Jedis也提供了客户端分布式操作的方式，采用一致性哈希算法。
 * 
 * @author shenluguo
 *
 */
public class CloudRedis {

	public static void main(String[] args) {
		// 生成多机连接信息列表
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add( new JedisShardInfo("127.0.0.1", 6379) );
		shards.add( new JedisShardInfo("10.144.25.115", 6379) );

		// 生成连接池配置信息
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(10);
		config.setMaxTotal(30);
		config.setMaxWaitMillis(3*1000);

		// 在应用初始化的时候生成连接池
		ShardedJedisPool pool = new ShardedJedisPool(config, shards);

		// 在业务操作时，从连接池获取连接
		ShardedJedis client = pool.getResource();
		try {
		    // 执行指令
		    String result = client.set("key-string", "Hello, Redis!");
		    System.out.println( String.format("set指令执行结果:%s", result) );
		    String value = client.get("key-string");
		    System.out.println( String.format("get指令执行结果:%s", value) );
		} catch (Exception e) {
		    // TODO: handle exception
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
