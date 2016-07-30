package com.shen.thread;

/**
 * 真正地中断一个线程,中断线程最好的，最受推荐的方式是，使用共享变量（shared variable）发出信号，告诉线程必须停止正在运行的任务。
 * 线程必须周期性的核查这一变量（尤其在冗余操作期间），然后有秩序地中止任务。
 * 
 * 
 * @author shen
 * 
 */
public class EndThread_interrupt3 extends Thread {
	volatile boolean stop = false;

	public static void main(String args[]) {
		EndThread_interrupt3 thread = new EndThread_interrupt3();
		System.out.println("Starting thread...");
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Asking thread to stop...");
		thread.stop = true;// 如果线程阻塞，将不会检查此变量
		//给wait，join，sleep等阻塞的线程一个信号，使他们退出阻塞状态，就会立马开始检查中断变量stop，从而不必等阻塞
		//结束，就提前达到立马中断线程的效果。
		System.out.println("isInterrupted1 = "+thread.isInterrupted());
		thread.interrupt();
		System.out.println("isInterrupted2 = "+thread.isInterrupted());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stopping application...");
		// System.exit( 0 );
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread running...");
			try {
				//睡很长时间，如果没有显示的调用thread.interrupt();那么会等睡完了才会改变stop变量达到中断线程的作用
				//如果显示的调用thread.interrupt(),立马会抛出一个InterruptedException，从而提前退出睡眠状态，达到
				//立马终止线程的作用。
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Thread interrupted...");
			}
		}
		System.out.println("Thread exiting under request...");
	}

}
