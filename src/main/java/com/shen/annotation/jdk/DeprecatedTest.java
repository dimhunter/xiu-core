package com.shen.annotation.jdk;
/**
 * Deprecated注解使用。
 * @author shen
 *
 */
public class DeprecatedTest {
	@Deprecated
	public void doSomething(){
		System.out.println("do something");
	}
	
	public static void main(String[] args){
		DeprecatedTest test = new DeprecatedTest();
		test.doSomething();
	}
}
