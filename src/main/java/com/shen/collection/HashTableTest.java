package com.shen.collection;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableTest {
	
	public static void main(String[] args) {
		//Hashtable不允许key是 null。
		Hashtable tb = new Hashtable();
//		tb.put(null, null);
		
		HashMap m = new HashMap();
		m.put(null, null);
		m.put(null, "aaa");
		System.out.println(m.get(null));
	}
	
}
