//这个例子是创建和启动线程的第一种方法：实现Runnable接口。和TestThread2.java比较。
package com.shen.thread;

public class TestThread1{
	public static void main(String[] args){
		Runner1 r=new Runner1(); //Runner1实现接口只表示是个线程类。和TestThread2.java比较。（重要）
		Thread t=new Thread(r);  //必须new出一个thread才说明new出了一个线程。如下面的只是方法的调用。
		t.start();
		
		for(int i=0;i<50;i++){
			System.out.println("Main 运行的次数："+i);
		}	
	}	
}


class Runner1 implements Runnable{
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println("Runner1 运行的次数："+i);
		}	
	}	
}
//这样启动一个新的线程的运行结果是main和runner1交替打印出。


/*
//下面这样"方法调用"的运行结果是先输出50个main，再输出50个runner1.

public class TestThread1{
	public static void main(String[] args){
		Runner1 r=new Runner1(); 
		r.run();            //直接就调用Runnable接口的run方法这叫方法的调用，不是启动了一个线程。运行结果是不一样的。
		
		//Thread t=new T
		//t.start();
		
		for(int i=0;i<50;i++){
			System.out.println("Main 运行的次数："+i);
		}	
	}	
}


class Runner1 implements Runnable{
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println("Runner1 运行的次数："+i);
		}	
	}	
}


*/