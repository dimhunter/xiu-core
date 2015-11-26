package com.shen.string;

public class StringTest3 {
	public static void main(String args[]){
		String s1 = "000";
		String s2 = "111";
		
//		StringBuffer sb = "123" ;   //错误，StringBuffer是不能用这种方法设置初始值的。
		StringBuffer sb1 = new StringBuffer("222");
		
		String s3 = s1 + s2 ;      //正确，字符串可直接用加号连接，输出000111。
		String s4 = s1 + sb1 ;     //正确，任何东西和字符串用加号连接后就是字符串了。
//		String s5 = sb1 + sb2 ;    //错误，StringBuffer是不能用加号连接的，连接后不知道算什么类型。
//		StringBuffer s6 = sb1 + sb2 ;//错误。
		System.out.println(s3);
		System.out.println(s4);
	}
}
