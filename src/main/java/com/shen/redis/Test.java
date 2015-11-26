package com.shen.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class Test {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		try {
			jedis.connect();
			jedis.ping();
			jedis.quit();
		} catch (JedisConnectionException e) {
			e.printStackTrace();
		}
	}

}
