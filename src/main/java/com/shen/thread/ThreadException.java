package com.shen.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadException implements Runnable{

	public void run() {
		//Runnable接口的run方法没有抛异常，所以只能抛RuntimeException。
		throw new RuntimeException("可以抛RuntimeException");
		//抛出Exception(非RuntimeException会编译失败)
//		throw new Exception("不可抛Exception");
	}
	
	public static void main(String[] args) {
		try{
			new Thread(new ThreadException(),"aa").start();	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("主线程捕获到了子线程的异常。");
		}
		System.out.println("子线程仅可抛出RuntimeException，但是主线程捕获不到，且主线程不会终止，只有子线程自己终止了。");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==============");
//		每个Thread都会有一个ThreadGroup对象，可以通过Thread.getThreadGroup()方法得到，提供了上述默认的uncaught异常处理方法。 
		Thread tb = new Thread(new ThreadException(),"bb");
		tb.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName());
				System.out.println("主线程捕获到子线程异常"+e.getMessage());
			}
		});
		tb.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
