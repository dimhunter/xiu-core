package com.shen.circle;

/**
 * for循环
 * 
 * @author shen
 */
public class ForTest1 {

	/**
	 * for(initial初始表达式 ; condition条件表达式; iteration修改变量){
	 * 		// body
	 * }
	 * 
	 * 如果只有一条语句需要重复，大括号就没有必要。
	 * for 循环体内声明的变量的作用域仅仅是for循环体，循环完后就结束了。在for循环外，变量就不存在了。
	 */
	void test1(){
		for(int i=0; i<6; i++){
			System.out.println(i);
			int a = 1;
			System.out.println("---"+a);
		}
	}
	
	/**
	 * 对于循环被两个相互作用的变量控制的情况，如果两个变量都定义在for循环中，而让变量b不需要通过人工处理将是很有用的。
	 * java提供了一种方法：允许在for循环的初始化部分和反复部分声明多个变量，每个变量用逗号隔开，如test3();
	 */
	void test2(){
		int a,b;
		b=4;
		for(a=1;a<b;a++){
			System.out.println("a="+a);
			System.out.println("b="+b);
			b--;
		}
		
	}
	
	/**
	 * 逗号隔开变量的情况
	 */
	void test3(){
		for(int a=1,b=4; a<b; a++,b--){
			System.out.println("a="+a);
			System.out.println("b="+b);
		}
	}
	
	public static void main(String[] args){
		ForTest1 ft = new ForTest1();
//		ft.test1();
		ft.test2();
		ft.test3();
	}
}
