package com.shen.collection;

import java.util.*;

/**
 * list的两个特点：
 * 元素的顺序是按照输入时的顺序。
 * 元素可以重复。
 * 
 * 注意下边迭代器Iterator的用法
 * 
 * @author shen
 *
 */
public class ListTest {
	public static void main(String[] args){
	List<Object> list =new ArrayList<Object>();
		list.add("中"); 
		list.add("华");
		list.add("人");
		list.add("民");
		list.add("共");   
		list.add("和");
		list.add("国");
		list.add(new Integer(860));
	
		list.add("共");                //在list上添加重复元素“共”和“860”成功。 set是允许重复的集合。		
		list.add(new Integer(860));
		
		System.out.println(list);
		
		//定义一个迭代器对象
		Iterator<?> elements = list.iterator();
		while(elements.hasNext()){
			System.out.println(elements.next());
		}
	}
}
