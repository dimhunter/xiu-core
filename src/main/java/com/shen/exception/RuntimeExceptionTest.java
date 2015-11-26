package com.shen.exception;

public class RuntimeExceptionTest {
	
	void test1() throws Exception{
		System.out.println("test1");
	}
	
	void test2(){
//		throw new Exception(); //编译不通过，必须抛出异常，或try...catch
	}
	
	void test3(){
		System.out.println("test3---1");
		throw new RuntimeException();//编译通过，不必在方法上抛出改异常。
//		System.out.println("test3---2");//编译不通过，在throw Exception 后的代码是不会执行的，无论是否runtimeException，因为它也是Exception的子类。
	}
	
	
	public static void main(String[] args){
		RuntimeExceptionTest rt = new RuntimeExceptionTest();
//		rt.test1();//必须抛出异常或try...catch处理
		rt.test3();//不需要抛出或处理。但是运行的时候还是会抛出该异常，程序依然会中断。所以一般写api往外抛runtimeException就可以了。有Exception的，
					//捕获到以后new一个相关的runtimeException往外抛就可以了，别人调用的时候还不用try...catch处理，但是该抛的时候依然会抛出。
	}
}
