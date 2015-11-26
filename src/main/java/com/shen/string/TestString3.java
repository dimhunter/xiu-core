package com.shen.string;

public class TestString3 {
	public static void main(String[] args){
		
		String s = "Welcome to Java World!";
		String s1 = "  sun java  ";
		
		//public boolean startsWith(String str)表示测试字符串是否以指定字符串开头
		System.out.println(s.startsWith("Welcome")); //true
		//public boolean endsWith(String str)表示测试字符串是否以指定字符串开头
		System.out.println(s.endsWith("World")); //false，最后还有个叹号
		
		//public String toLowerCase()表示全部转换成小写
		String sL = s.toLowerCase(); 
		//public String toUpperCase()表示全部转换成大写
		String sU = s.toUpperCase(); 
		System.out.println(sL); //welcome to java world!
		System.out.println(sU); //WELCOME TO JAVA WORLD!
		
		//public String substring(int beginIndex)表示从下标(0开始)为几的字符开始截取，一直到最后
		String subS = s.substring(11);
		System.out.println(subS); //Java World!
		
		//public String trim()表示去掉前后的空格，中间的不能去。
		String sp = s1.trim();
		System.out.println(sp); //sun java
	}
}
