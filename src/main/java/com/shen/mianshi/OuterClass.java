package com.shen.mianshi;

public class OuterClass {
	
	private class InterClass{
		public InterClass(){
			System.out.println("Inner ");
		}
	}
	
	public OuterClass(){
		InterClass in = new InterClass();
		System.out.println("Outer");
	}
	
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
	}
	
}
