package com.shen.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map循环的几种方式
 * 
 * @author shen
 * 
 */
public class MapCircleTest {
	public static void main(String args[]) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < 10; i++) {
			map.put(i, i + "");
		}
		// 第一种:通过Map.keySet()遍历key和value
		// 这里有一个二次取值的过程,所以并不推荐
		System.out.println("----- 1 ------");
		for (Integer key : map.keySet()) {
			System.out.println("key = " + key + " and value = " + map.get(key));
		}
		System.out.println("----- 2 ------");
		// 第二种:通过Map.entrySet()使用iterator()遍历key和value
		Iterator<Map.Entry<Integer, String>> iterator = map.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println("key = " + entry.getKey() + " and value = "
					+ entry.getValue());
		}
		System.out.println("----- 3 ------");
		// 第三种:通过Map.entrySet()遍历key和value
		// JDK1.5后的遍历形式,代码看起来比较整洁,更推荐采用
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + " and value = "
					+ entry.getValue());
		}
	}
}
