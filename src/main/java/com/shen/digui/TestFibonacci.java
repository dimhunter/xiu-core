package com.shen.digui;

/**
 * Fibonacci数列
 * 
 * F1=1，F2=1  Fn = F(n-1) + F(n-2) (n>2)
 */
public class TestFibonacci {

	public static void main(String[] args) {
		System.out.println(f(5));
	}
	
	public static int f(int n){
		if( n==1 || n==2 ){
			return 1;
		}else{
			return f(n-1)+f(n-2);
		}
	}
}
