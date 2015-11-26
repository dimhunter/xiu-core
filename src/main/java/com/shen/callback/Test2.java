package com.shen.callback;

public class Test2 {
	public static void main(String[] args) {
		Caller caller = new Caller();
//		caller.setCallFunc(new Client());
		//用这种方法就可以把client删掉。
		//但是刚开始没看明白，是因为把Test1中的Client类省略，直接写成匿名类了。
		caller.setCallFunc(new MyCallInterface() {
			public void printName() {
				System.out.println("This is the client printName method");
			}
		});
		caller.call();
	}
}
