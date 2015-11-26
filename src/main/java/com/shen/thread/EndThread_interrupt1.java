package com.shen.thread;

/**
 * 本例创建了一个线程，并且试图使用Thread.interrupt方法停止该线程。Thread.sleep()方法的调用，为线程的初始化和中止提供了充裕的时间。
 * 线程本身并不参与任何有用的操作。
 * 
 * @author shen
 *
 */
public class EndThread_interrupt1 extends Thread {
	boolean stop = false;

	public static void main(String args[]) throws Exception {
		EndThread_interrupt1 thread = new EndThread_interrupt1();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
		//甚至，在Thread.interrupt()被调用后，线程仍然继续运行。
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit(0);
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			//保持1秒间隔输出
			while ((System.currentTimeMillis() - time < 1000)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}

}
