package com.shen.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapTest {
	
	public static void main(String[] args) {
//		Map<String,String> m1 = new LinkedHashMap<>();
		//为true时，是LRU算法。
		Map<String,String> m1 = new LinkedHashMap<String,String>(16,0.75f,true);
		m1.put("a", "a");
		m1.put("d", "a");
		m1.put("c", "a");
		m1.put("b", "a");
		//get一次a后，a会放到key顺序的最后一个，链表尾部。
		m1.get("a");
		Iterator<Entry<String, String>> itor = m1.entrySet().iterator();
		while(itor.hasNext()){
			System.out.println(itor.next().getKey());
		}
		
	}
	
}
