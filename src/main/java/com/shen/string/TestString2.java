package com.shen.string;

/**
 * String常用方法介绍
 * @author Administrator
 *
 */
public class TestString2 {
	public static void main(String[] args){
		
		String s1 = "sun java";
		String s2 = "Sun java";
		
		//public char charAt(int index)表示返回字符串的第index个字符(下标是从0开始的)
		System.out.println(s1.charAt(1));  //u
		System.out.println(s2.length());   //8   --- 返回字符串长度，包括空格
		
		//public int indexOf(String str)表示返回第一次出现的指定子字符串str的位置(下标从0开始)
		System.out.println(s1.indexOf("java")); //4
		//如果指定的字符串不存在，统统返回-1
		System.out.println(s1.indexOf("Java")); //-1
		
		
		System.out.println(s1.equals(s2));  //false
		//比较字符串是否相等，忽略大小写
		System.out.println(s1.equalsIgnoreCase(s2)); //true
		
		String s = "我是程序员，我在学java";
		//public String replace(char oldChar,char newChar)表示用新字符替换旧字符
		String sr = s.replace('我', '你');
		System.out.println(sr); //你是程序员，你在学java		
		
		//public boolean startsWith(String str)表示测试字符串是否以指定字符串开头
				
				//public String trim()表示去掉前后的空格，中间的不能去。
				String sp = s1.trim();
				System.out.println(sp); //sun java
	}
}
