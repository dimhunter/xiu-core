package com.shen.collection;

import java.util.HashMap;
import java.util.Map;

public class TestPut {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map m = new HashMap<String,String>();
		System.out.println(m.put("a", "aa"));
		System.out.println(m.put("b", "bb"));
		System.out.println(m.put("b", "cc"));
		
	}
}
