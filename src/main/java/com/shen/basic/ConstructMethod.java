package com.shen.basic;
/**
 * 构造方法简介，   new调用的方法就是类的构造方法。
 * @author shen
 *
 * 规则：构造方法名必须与该类具有相同的名字，并且没有返回值，包括没有void。
 * 构造方法一般都用public类型，这样才能在程序的任意位置创建类的对象（new）。
 */

public class ConstructMethod {
	

	/**
	 * java类有一个特殊的成员方法叫构造方法，作用是创建对象并初始化成员变量。
	 * 在创建该类的对象时，会自动调用该类的构造方法，如果不创建对象，那么构造方法是没用的。
	 * 
	 * 每个类至少有一个构造方法，如果不写，java将提供一个默认的，没有参数，而且方法体为空。
	 * 就是下边这个，这就是为什么有的类不写构造方法，依然可以new一个对象，如 ConstructMethod cm = new ConstructMethod();
	 * 只需要一个括号就可以，因为默认的是没有参数且方法体为空。
	 * 
	 */
//	public ConstructMethod() {	
//	}
	
	
	/**
	 * 如果一个类已经定义了构造方法，那么系统将不再提供默认的构造方法,ConstructMethod cm = new ConstructMethod()也会报错。
	 * 比如下边这个定义了一个有参数的构造方法，那么new的时候需要带参数 
	 *  ConstructMethod cm = new ConstructMethod(a);
	 * 可以用在一些地方初始化一些值。
	 * 
	 * @param a
	 */
	public ConstructMethod(String a){
		
	}
	
	public static void main(String[] args){
		//显示提供有参数的构造方法时，不显示提供无参的，会报错。
//		ConstructMethod cm = new ConstructMethod();
	}
}
