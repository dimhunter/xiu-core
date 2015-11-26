package com.shen.callback;

public class Caller {
	
	private MyCallInterface callInterface;
	
	public void setCallFunc(MyCallInterface callInterface) {
		this.callInterface = callInterface;
	}
	
	public void call() {
		callInterface.printName();
	}
}
