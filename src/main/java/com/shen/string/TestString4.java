package com.shen.string;

public class TestString4 {
	public static void main(String[] args){
		
		int j = 1234567;
		//public static String valueOf(...) 是个静态重载方法，表示把其他基本数据类型转换为字符串
		String sNumber = String.valueOf(j);
		System.out.println("j 是" + sNumber.length() + "位数"); //j 是7位数
		

		String s = "Mary,F,1985";
		//public String[] split(String regex)表示根据给定的正则表达式的匹配来拆分此字符串，返回的是个字符串数组，这里是个逗号
		String[] sPlit = s.split(","); 		
		for(int i=0; i<sPlit.length; i++){
			System.out.println(sPlit[i]); //分别换行输出：Mary  F  1985
		}
		
	}
}
