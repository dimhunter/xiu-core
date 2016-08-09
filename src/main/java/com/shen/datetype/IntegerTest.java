package com.shen.datetype;

/**
 * int 包含 byte，short，int，long 4种
 * 
 * @author shen
 */
public class IntegerTest {
	
	/**
	 * 1. 字节型byte
	 * 整数型的值，就是没有小数点的数据，如果没有特别指明，默认是int类型。
	 * 长度8位，范围是 -2的7次方到2的7次方。默认值0。
	 */
	byte abc = 15;

	/**
	 * 2. 短整型short
	 * 整数型的值，就是没有小数点的数据，如果没有特别指明，默认是int类型。
	 * 长度16位，范围是 -2的15次方到2的15次方。默认值0。
	 */
	short s = 1;
	
	
	/**
	 * 3. 整型int
	 * 整数型的值，就是没有小数点的数据，如果没有特别指明，默认是int类型。
	 * 
	 * 长度32位，范围是 -2的31次方到2的31次方。默认值0。
	 */
	int a = 1;
	
	/**
	 * 4. 长整型long
	 * 整数型的值，就是没有小数点的数据，如果没有特别指明，默认是int类型。
	 * 长度64位，范围是 -2的64次方到2的64次方。默认值0。
	 * 如果要明确表示long型的值，可以在后边加L或l（最好大写）
	 */
	long m = 1;
	long n = 2L;
	
	
	public static void main(String[] args){
		IntegerTest bt = new IntegerTest();
		System.out.println(bt.abc);
	}
}
