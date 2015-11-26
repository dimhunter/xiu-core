package com.shen.static_final;

/**
 * 单例模式
 * @author shen
 *
 */
public class StaticTest2 {

	private static StaticTest2 st = new StaticTest2();
	
	public static int count1;
	public static int count2 = 0;
	
	private StaticTest2(){
		count1++;
		count2++;
	}
	
	public static StaticTest2 getInstance(){
		return st;
	}
	
	public static void main(String[] args) {
//静态变量的执行顺序在程序中是从上到下顺序执行的，因此在调用StaticTest.getInstance()时执行过程是：    		
//private static StaticTest st = new StaticTest();-->public static int count1;-->public static int count2 = 0; 		
		StaticTest2 st = StaticTest2.getInstance();
		
		System.out.println("count1: "+st.count1);
		System.out.println("count2: "+st.count2);
	}

}

/*  
 * 静态变量的初始化顺序
 * 静态变量的执行顺序在程序中是从上到下顺序执行的 
 */
