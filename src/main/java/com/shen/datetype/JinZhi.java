package com.shen.datetype;

/**
 * java不显示地支持二进制数字,因为二进制的数字比较长,你可以考虑使用八进制或十六进制,这两种转换成二进制都比较方便.
 * 可以用八进制用0开头,比如:012就是十进制的10
 * 十六进制用0x开头,比如:0x12就是十进制的18
 * 八进制和十六进制的0和0x是不参加计算的，知识标识。
 * @author shen
 *
 */
public class JinZhi {
	//java中，以0开头的表示一个8进制数，但是每位最高不能超过8，否则报错。如 a = 059;
	private int a = 056;
	//java中，以0x开头的表示一个16进制数，它由0-9，A-F组成，字母不区分大小写。与10进制的对应关系是：0-9对应0-9；A-F对应10-15
	//每位不能超过F，否则报错。如b=0x5g
	private int b = 0x56;
	//
	private int c = 0x5c;
	
	public static void main(String[] args){
		JinZhi jin = new JinZhi();
		System.out.println("5*8的1次方 + 6*8的0次方 = "+jin.a);
		System.out.println("5*16的1次方 + 6*16的0次方 = "+jin.b);
		System.out.println("5*16的1次方 + 12*16的0次方 = "+jin.c);
		System.out.println("c转换为二进制 = " + Integer.toBinaryString(jin.c));
	}
	
}
