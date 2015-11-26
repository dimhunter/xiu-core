package com.shen.operator;

/**
 * 三目运算符
 * 
 * expression1 ? expression2 : expression3
 * 
 * expression1是个布尔表达式，如果为真，结果就是expression2，如果是假，结果就是expression3。
 * 
 * @author shen
 *
 */
public class ThreeOperator {
	
	public static void main(String[] args){
		int x = 5;
		int y = 2;
		System.out.println( x>y ? "a" : "b");
	}
	
}
