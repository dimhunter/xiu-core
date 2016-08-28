package com.shen.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * JAVA 中无锁的线程安全整数 AtomicInteger，一个提供原子操作的Integer的类。在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，

不可避免的会用到synchronized关键字。而AtomicInteger则通过一种线程安全的加减操作接口。AtomicInteger为什么能够达到多而不乱，处理高并发应付自如呢？

这是由硬件提供原子操作指令实现的，这里面用到了一种并发技术：CAS。在非激烈竞争的情况下，开销更小，速度更快。
Java.util.concurrent中实现的原子操作类包括：
AtomicBoolean、AtomicInteger、AtomicIntegerArray、AtomicLong、AtomicReference、AtomicReferenceArray。
 * 
 * @author shen
 *
 */
public class AtomicOperationDemo2 {
	//共享变量，多个线程进行修改，不用锁的实现方式。
	static AtomicInteger count = new AtomicInteger(0);

	public static void AtomicIntShow() {
		System.out.println("AtomicIntShow() enter");
		AddThread at = new AddThread();
		for(int i=0; i<100;i++){
			new Thread(at,i+"_tt").start();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * output AtomicIntShow() enter result of acumulated sum=300000
		 * AtomicIntShow() exit
		 */

		System.out.println("result of acumulated sum=" + count);
		System.out.println("AtomicIntShow() exit");
		return;
	}

	public static void main(String[] args) {
		AtomicOperationDemo2.AtomicIntShow();
	}
}

class AddThread implements Runnable {
	@Override
	public void run() {
		for (int k = 0; k < 1000; k++) {
			//执行2次，相当于每个线程执行+3操作
			AtomicOperationDemo2.count.incrementAndGet();
			AtomicOperationDemo2.count.incrementAndGet();
			AtomicOperationDemo2.count.incrementAndGet();
		}
	}
}
