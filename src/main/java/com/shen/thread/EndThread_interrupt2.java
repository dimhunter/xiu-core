package com.shen.thread;

/**
 * 真正地中断一个线程,中断线程最好的，最受推荐的方式是，使用共享变量（sharedariab vle）发出信号，告诉线程必须停止正在运行的任务。
 * 线程必须周期性的核查这一变量（尤其在冗余操作期间），然后有秩序地中止任务。
 * 
 * 虽然该方法要求一些编码，但并不难实现。同时，它给予线程机会进行必要的清理工作，这在任何一个多线程应用程序中都是绝对需要的。
 * 请确认将共享变量定义成volatile 类型或将对它的一切访问封入同步的块/方法（synchronized blocks/methods）中。
 * 
 * 到目前为止一切顺利!但是，当线程等待某些事件发生而被阻塞，又会发生什么？当然，如果线程被阻塞，它便不能核查共享变量，也就不能停止。
 * 这在许多情况下会发生，例如调用Object.wait()、ServerSocket.accept()和DatagramSocket.receive()时，这里仅举出一些。
 * 他们都可能永久的阻塞线程。即使发生超时，在超时期满之前持续等待也是不可行和不适当的，所以，要使用某种机制使得线程更早地退出
 * 被阻塞的状态。很不幸运，不存在这样一种机制对所有的情况都适用，但是，根据情况不同却可以使用特定的技术。在EndThread_interrupt3，
 * 我将解答一下最普遍的例子。使用Thread.interrupt()中断线程
 * 
 * @author shen
 * 
 */
public class EndThread_interrupt2 extends Thread {
	volatile boolean stop = false;
	
	public static void main(String args[]) throws Exception {
		EndThread_interrupt2 thread = new EndThread_interrupt2();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		thread.stop = true;
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		// System.exit( 0 );
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000) && (!stop)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}

}
