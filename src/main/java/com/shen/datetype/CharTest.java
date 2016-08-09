package com.shen.datetype;

/**
 * 字符型
 * 用来表示单个字符，一个char代表一个16位的无符号(不分正负)的Unicode字符，一个char字符必须包含在单引号内。
 * @author shen
 *
 */
public class CharTest {
		
	char a = 'b'; //表示简单的字符
	char b = '1'; //用数字也可以表示字符
	
	char c = '啊';//汉字也可以

//	char d = "a"; //只能是单引号
//	char e = 'bb';//只能是单个字符
	
	public static void main(String[] args){
		CharTest ct = new CharTest();
		System.out.println(ct.c);
	}
}
