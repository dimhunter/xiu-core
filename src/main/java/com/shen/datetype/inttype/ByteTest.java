package com.shen.datetype.inttype;

/**
 * 字节型
 * 整数型的值，就是没有小数点的数据，如果没有特别指明，默认是int类型。
 * 长度8位，范围是 -2的7次方到2的7次方。默认值0。
 * 
 * @author shen
 */
public class ByteTest {
	
	byte abc = 15;

	public static void main(String[] args){
		ByteTest bt = new ByteTest();
		System.out.println(bt.abc);
	}
	
}
