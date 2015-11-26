package com.shen.mem;

public class Test {
	
	public static void main(String[] args){
		int a = 0;
		Test t = new Test();
		System.out.println(a);
		t.change(a);
		//赋值不赋值会有很大区别。
//		a = t.change(a);
		System.out.println(a);
	}
	
	public int change(int i){
		i = 123;
		return i;
	}
	
}	
