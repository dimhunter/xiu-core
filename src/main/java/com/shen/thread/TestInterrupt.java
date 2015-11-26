//该例子是研究sleep方法的例子。
package com.shen.thread;

import java.util.*;

public class TestInterrupt {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		try {
			Thread.sleep(10000);
		} // 主线程睡10秒。
		catch (InterruptedException e) {
		} // sleep方法会抛InterruptedException异常。
		thread.interrupt(); // 有异常时打断退出。interrupt()是thread类的方法，中断线程的意思。
	}
}

class MyThread extends Thread {
	boolean flag = true; // 最好定义个变量来控制线程的终止。不要调用stop方法来终止线程，已过时不好。

	public void run() {
		while (flag) {
			System.out.println("===" + new Date() + "==="); // 输出系统时间。
			try {
				sleep(1000); // 子线程睡1秒。就是每隔1秒输出一下系统时间的意思。
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

// 该程序的意思是主线程睡10秒。在这10秒里子线程1秒1秒的睡，每1秒输出一下系统时间。10到了后主线程退出。子
// 线程也就退出了。注意要定义一个布尔变量来控制退出，不要直接用stop方法，那样不好已过时。

