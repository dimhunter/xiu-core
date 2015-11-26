package com.shen.basic;


/**
 * 在同一个包下，类名是唯一的。即使是在不同的源文件中。
 * 比如这个Hello.java源文件中有个类是A，那么在同一包下比如HelloWold源文件中就不能有 class A 这么一个类。
 * @author shen
 */
class A{
	public static void main(String[] args) {
		//Java中文标识符测试，可以编译和执行，是把中文当做Unicode字符集中的符号来对待了。不建议这么做
//		String Java中文标识符 = "中文标识符测试";
//		System.out.println("Java中文标识符 = " + Java中文标识符);
	}
}

class B{
	public static void main(String[] args) {
	}
}
