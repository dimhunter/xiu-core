package com.shen.select;

/**
 * switch 语句是java的多路分支语句。它提供了一种基于一个表达式的值来使程序执行不同部分的简单方法。
 * 提供了一个比一系列 if-else-if 语句更好的选择。
 * 
 * @author shen
 */
public class SwitchTest1 {

	/**
	 * switch(expression){
	 * 		case value1 : statement1 ;
	 * 			break;
	 * 		case value2 : statement2 ;
	 * 			break;
	 * 		......
	 * 		case valueN : statementN ;
	 * 			break;
	 * 		default : statement ;
	 * }
	 * 
	 * 表达式expression必须是byte，short，int 或 char 类型,或者enum类型的常量值。
	 * 每个case语句后的值value必须是与表达式类型兼容的特定的一个常量，必须是常量，不能是变量。
	 * 重复的case值是不允许的。
	 * 
	 * 执行过程如下：表达式的值与每个case语句中的常量作比较，如果发现一个与之相匹配，则执行该case语句后的代码。
	 * 如果没有一个case常量与表达式的值相匹配，则执行default语句，default语句是可选的。
	 * 如果没有相匹配的case语句，也没有default语句，则什么也不执行。
	 * 
	 */
	public static void main(String[] args) {
		SwitchTest1 st = new SwitchTest1();
		st.test1();
	}
	
	
	/**
	 * 如果没有break语句作为某一个case代码段的结束句，则程序的执行将继续这个case之后的所有case代码段和default，而不检查以后的case表达式的值是否符合。
	 * 可做断点跟一下试试。所有case一般必须带。
	 */
	void test1() {
		for(int i=0; i<3; i++){
			switch(i){
				case 0:{
					System.out.println("0");
				};
					//break;
				case 1:{
					System.out.println("1");
				}
					//break;
				default : {
					System.out.println("------");
				}
			}
		}
		
	}
	
	
}
