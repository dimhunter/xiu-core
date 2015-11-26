package com.shen.math;
/**
 * Math.round():Java中的四舍五入函数
 * @author shen
 *
 */
public class RoundTest {

	public static void main(String[] args) {

		System.out.println("Case1：小数点后第一位 = 5");
		System.out.println("正数：Math.round(11.5) = " + Math.round(11.5));
		System.out.println("负数：Math.round(-11.5) = " + Math.round(-11.5));
	
		System.out.println("Case2：小数点后第一位 < 5");
		System.out.println("正数：Math.round(11.49) = " + Math.round(11.49));
		System.out.println("负数：Math.round(-11.49) = " + Math.round(-11.49));
	
		System.out.println("Case3：小数点后第一位 > 5");
		System.out.println("正数：Math.round(11.69) = " + Math.round(11.69));
		System.out.println("负数：Math.round(-11.69) = " + Math.round(-11.69));
	
		System.out.println("结论：正数小数点后大于5则进位；负数小数点后小于以及等于5都舍去，大于5的则进位");
		System.out.println("也就是说：小数点后大于5全部加，等于5正数加，小于5全不加");
	
	}
}

