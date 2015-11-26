package com.shen.thread;

public class TestThread6 {	
	public static void main(String args[]){
		Thread t = new Runner6();
   	t.start();
		
		for(int i=0; i<50; i++) {
			System.out.println("MainThread: " + i);
		}
  }
}

class Runner6 extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().isAlive());//currentThread()是获取当前线程的引用并判断是否还活着。
		for(int i=0;i<50;i++) {
			System.out.println("SubThread: " + i);
		}
	}
}

//本例仅仅是多了个方法，也是主线程和sub线程交替打出，偶尔交替判断一下，没什么特别意义。