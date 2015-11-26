package com.shen.select;

/**
 * 嵌套switch语句。
 * 
 * 可以将一个switch语句作为一个外部switch语句的语句序列的一部分，称为嵌套switch语句。
 * 外部switch语句和内部switch语句的case常量不会产生冲突。
 * 
 * @author shen
 *
 */
public class SwitchTest2 {

	/**
	 * 
	 */
	void test1(){
		int count = 1;
		int target = 0;
		switch(count){
			case 1 : switch(target){
						case 0 : System.out.println("0");break; 
						case 1 : System.out.println("1");break;
					 }
			break;
			case 2 : System.out.println("1");
			break;
		}
	}
	
	public static void main(String[] args) {
		SwitchTest2 st = new SwitchTest2();
		st.test1();
	}

}
