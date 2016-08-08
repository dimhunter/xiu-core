package com.shen.basic;

/**
 * 赋值测试，基本数据类型和引用数据类型的参数传递？内存是如何分配的？？？
 * @author shen
 *
 */
public class TestAssign {
	
	public static void main(String[] args){
		int a = 0;
		TestAssign t = new TestAssign();
		System.out.println(a);
		t.change(a);
		//赋值不赋值结果会有很大区别。
		a = t.change(a);
		System.out.println(a);
	}
	
	public int change(int i){
		i = 123;
		return i;
	}
	
}	
