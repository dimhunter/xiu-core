package com.shen.collection;

import java.util.*;
/**
 * set有两个特点：
 * 元素的顺序与加入时的顺序没有关系，因为set中元素的顺序是无意义的。
 * 相同的元素不会重复加入，因为集合中元素是不重复的。
 * @author shen
 *
 */
public class SetTest {
	public static void main(String[] args){
		Set<Object> set = new HashSet<Object>(); //声明一个set类型的变量，并将其初始化成一个行的hashset对象。
		set.add("中");
		set.add("华");
		set.add("人");
		set.add("民");
		set.add("共");   
		set.add("和");
		set.add("国");
		set.add(new Integer(860));
		
		set.add("共");                //在set上添加重复元素“共”和“860”失败。 set是无序不允许重复的集合。		
		set.add(new Integer(860));
		
		System.out.println(set);
	}
}
