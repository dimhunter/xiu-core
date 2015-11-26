package com.shen.redis;

import redis.clients.jedis.Jedis;

/**
 * 使用单连接,此方式仅建议用于开发环境做调试用。
 * @author shenluguo
 *
 */
public class FirstRedis {
	
	public static void main(String[] args){
		
		// 创建连接
		String host = "127.0.0.1";
		int port = 6379;
		Jedis client = new Jedis(host, port);
//		client.connect();

		// 执行set指令
		String result = client.set("key-string", "Hello, Redis!");
		System.out.println( String.format("set指令执行结果:%s", result) );

		// 执行get指令
		String value = client.get("key-string");
		System.out.println( String.format("get指令执行结果:%s", value) );
		
	}
	
}
