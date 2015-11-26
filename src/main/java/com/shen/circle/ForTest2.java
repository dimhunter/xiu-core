package com.shen.circle;
/**
 * for可以省略的部分
 * @author shen
 */
public class ForTest2 {

	/**
	 * for语句里的3个部分都可以省略，但是不建议这么做。
	 * 
	 * for循环执行过程:
	 * 	首先计算表达式1，接着执行表达式2，若表达式2的值=true，则执行一次循环体语句，接着
	 * 	计算表达式3，再判断表达式2的值，依次重复下去，直到表达式2的值=false。
	 */
	public static void main(String[] args) {

// 无限循环
//		for ( ; ; ){
//			System.out.println("JAVA");
//		}

// 依然是无限循环，不断的输出：JAVA0
//		for(int i = 0; ; ){
//			System.out.println("JAVA"+ i );
//		}

// 依然是无限循环，依然不断的输出：JAVA0
//		for(int i = 0; i < 3; ){
//			System.out.println("JAVA"+ i );
//		}

// 依然是无限循环，会输出：JAVA0 一直到 JAVA9999999...... 并无限输出下去
		for(int i = 0; ; i++ ){
			System.out.println("JAVA"+ i );
		}
	}
}
