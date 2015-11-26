package com.shen.circle;

/**
 * 
 * do-while 循环
 * 
 * while在条件表达式是false时，是不会执行的，有时需要循环至少执行一次，就要用do-while。
 * do-while总是执行它的循环体至少一次，因为它的条件表达式在循环的结尾。
 * 
 * @author shen
 *
 */
public class DoWhileTest1 {

	/**
	 *  do {
	 * 		//do something
	 *  }while(condition);
	 * 
	 */
	private void test1() {
		int n = 10;
		do{
			System.out.println(n);
		}while(n<0);
	}
	
	
	public static void main(String[] args) {
		DoWhileTest1 dt = new DoWhileTest1();
		dt.test1();
	}

}
