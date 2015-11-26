package com.shen.annotation.jdk;


/**
 * 复写废弃的方法。应该有警告，但是可以通过eclipse的设置而取消。
 * 
 * @author shen
 *
 */
public class DeprecatedSubTest extends DeprecatedTest {
	
	@Override
	public void doSomething(){
		System.out.println("do something in sub class");
	}
	
	public static void main(String[] args){
		DeprecatedSubTest sub = new DeprecatedSubTest();
		sub.doSomething();
	}
}
