package com.shen.operator;

/**
 * 算术运算符。
 * 
 * 用在数学表达式中，用法和功能与数学中一样。
 * 运算数必须是数字类型，但是可以用在char类型上，因为实质上在java中，char类型是int类型的一个子集。
 * 
 * @author shen
 *
 */
public class ArithmeticOperator {

	public static void main(String[] args) {
		
		// +
		System.out.println(1+2);
		
		// - 也可用作表示单个操作数的负号。
		System.out.println(5-2);
		
		// *
		System.out.println(3*2);
		
		// / 对整数进行除法运算，不保留小数点后的。实数要保留，有一个有小数点的结果就保留小数点。
		System.out.println(8/3);
		System.out.println(8/3.0);
		System.out.println(8.0/3.0);
		
		// % 求余  有一个有小数点的结果就保留小数点.。
		System.out.println(8 % 3);
		System.out.println(8.0 % 3);
		System.out.println(8.0 % 3.0);
		
		// = 赋值运算符
		int a = 7;
		a %= 3;
		System.out.println(a);
		
		// ++ -- 递增，递减
		// 递增是对其运算数加1，递减就是减1。
		// x++ 就是 x=x+1，x-- 就是x=x-1
		// 但最终x的值都是+1。
		int x1 = 5;
		int x2 = 5;
		
		// 它和 x1=x1+1; y1=x1 这两句是等价的,++在前就是先加再等于。
		int y1 = ++x1; 
		
		// 它和 y2=x2; x2=x2+1 这两句是等价的，++在后就是先等于再加。
		int y2 = x2++;
		
		System.out.println("x1="+x1 + ",x2="+x2);
		System.out.println("y1="+y1 + ",y2="+y2);
		
		// char的运算,??????
		char c = 'a';
		System.out.println(c+6);
		
	}

}
