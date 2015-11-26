package com.shen.callback;

public class Test1 {
	public static void main(String[] args) {
		Caller caller = new Caller();
		caller.setCallFunc(new Client());
		caller.call();
	}
}
