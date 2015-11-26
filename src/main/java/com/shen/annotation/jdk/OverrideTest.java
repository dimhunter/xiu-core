package com.shen.annotation.jdk;

/**
 * Override注解使用。重写父类方法。
 * 
 * @author shen
 *
 */
public class OverrideTest {
	
	@Override
	public String toString(){
		return "This is override";
	}

	public static void main(String[] args){
		OverrideTest test = new OverrideTest();
		System.out.println(test.toString());
	}
}
