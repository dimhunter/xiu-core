package com.shen.thread;

/**
 * 说明线程的优先级。
 * @author shen
 *
 */
public class TestPriority {
	public static void main(String[] args) {
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		t1.setPriority(Thread.NORM_PRIORITY + 3); //设置该线程的优先级正常的基础上加3，得到执行的时间片会多。
		t1.start();
		t2.start();
	}
}

class T1 implements Runnable {
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("T1: " + i);
		}
	}
}

class T2 implements Runnable {
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("------T2: " + i);
		}
	}
}