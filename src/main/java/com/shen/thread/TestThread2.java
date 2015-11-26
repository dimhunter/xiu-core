//这个例子是创建和启动线程的第二种方法：继承Thread类。和TestThread1.java比较。

package com.shen.thread;

public class TestThread2{
	public static void main(String[] args){	
		Runner2 r=new Runner2();   //Runner1继承Thread类就表示是个线程了。和TestThread1.java比较。（重要）
		//Thread t=new Thread(r);  //就不需要再new一个thread了。
		//t.start();
		r.start();                 //直接r.start()启动该线程就行了。
		
		for(int i=0;i<50;i++){
			System.out.println("Main 运行的次数："+i);
		}	
	}
}

class Runner2 extends Thread{
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println("Runner2 运行的次数："+i);
		}	
	}	
}


//重要总结：经过比较1和2.得出要启动一个线程，如果采用实现接口类的就必须再new出一个Thread来。如果采用继承Thread的
//方法的就直接调用start启动就行了。