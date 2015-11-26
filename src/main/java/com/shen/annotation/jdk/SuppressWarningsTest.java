package com.shen.annotation.jdk;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


/**
 * SuppressWarnings注解的使用。多个类型的不检查用数组形式：SuppressWarnings({"unchecked","deprecation"})
 * @author shen
 *
 */
public class SuppressWarningsTest {
	
	@SuppressWarnings({"unchecked","deprecation"})
	public static void main(String[] args){
		Map map = new TreeMap();	
		map.put("hello",new Date());
		
		System.out.println(map.get("hello"));
		
		DeprecatedTest test = new DeprecatedTest();
		test.doSomething();
	}
}
