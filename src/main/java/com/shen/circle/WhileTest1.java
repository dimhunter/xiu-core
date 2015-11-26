package com.shen.circle;

/**
 * while循环-最基本的循环
 * 
 * @author shen
 *
 */
public class WhileTest1 {
	
	/**
	 * while(condition){
	 * 		//do something
	 * }
	 * 
	 * 条件condition可以是任何布尔表达式，只要为true，循环体就被执行。
	 * 为false时，程序就传递到循环体后面紧跟的语句行。
	 * 如果单个语句需要重复，大括号是不必要的。
	 * 
	 */
	void test1(){
		int n = 10;
		while(n>0){
			System.out.println(n);
			n--;
		}
	}

	
	public static void main(String[] args) {
		WhileTest1 wt = new WhileTest1();
		wt.test1();
	}

}
