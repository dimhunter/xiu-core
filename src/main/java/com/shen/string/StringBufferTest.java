package com.shen.string;

public class StringBufferTest {

	/**
	 * @param args
	 * StringBuffer最常用的方法恐怕就是append方法和toString方法了
	 * 还有一个处理可变字符串的类就是StringBuilder，只是线程不安全，StringBuffer是线程安全的
	 */
	public static void main(String[] args) {
		StringBuffer b = new StringBuffer();
		b.append("这里");
		b.append("是");
		b.append("java的世界");
		System.out.println("b == " + b.toString());
	}
}
