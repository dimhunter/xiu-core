package com.shen.innerclass;

public class InterfaceInnerclass {
	public static void main(String[] args){
		
	}
}

interface itt{
	int a = 1;
	static int b = 2;
	
//	声明在接口中的内部类自动成为public和static???
	class Inner{
		public void test(){
			System.out.println(a);
		}
	}	
}