package com.shen.thread;

/**
 *  
 *  使用synchronized关键字解决线程的同步问题会带来一些执行效率上的问题。
　　JDK1.4及之前是无法避免这些问题的。
　　JDK 5.0引入了这样一个包：java.util.concurrent

 * @author shen
 *
 */
public class TestSync implements Runnable {
	Timer timer = new Timer();

	public static void main(String[] args) {
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");// 定义两个线程
		t1.start();
		t2.start(); // 同时启动两个线程，然后两个线程就会同时访问下面的run方法，就会用到synchronized。
	}

	public void run() { // 把获得当前线程名字的方法放在该线程执行的run方法体里，
		timer.add(Thread.currentThread().getName()); // 这样当这个线程执行时就会把这个名字通过下面的add方法传递给打印的地方。
	}
}

class Timer {
	private static int num = 0; // num只是计数用的。

	public synchronized void add(String name) {
		// synchronized(this){
		// //这里把synchronized写在这里加this也表示锁定当前对象，和写在方法的定义里是一样的。只是两种方式而已。
		num++; // 每次add方法被执行，num就加一。
		try {
			Thread.sleep(1);
		} // 重要!!!，这里让线程执行到这里时睡眠一下是为了让第二个线程执行。看下面执行结果的分析。
		catch (InterruptedException e) {
		}
		System.out.println(name + ", 你是第" + num + "个使用timer的线程"); // num递增完后打印谁谁是第几个使用..的线程。
		// }
	}
}

/*
 * 执行结果如下： 可能是： t1，你是第1个使用timer的线程 t2，你是第2个使用timer的线程 也可能是： t2，你是第1个使用timer的线程
 * t1，你是第2个使用timer的线程 反正不是同时执行的。
 * 
 * 
 * 如果把21行的关键字synchronized去掉，则执行的结果是： t1，你是第2个使用timer的线程 t2，你是第2个使用timer的线程
 * 
 * 两个就都是2了，因为当第一个线程执行到 num++，然后就睡着了，此时换成第二个线程执行，这里用到sleep方
 * 法就是为了让两个线程交换一下。此时的num已经是1了，然后第二个线程执行到这里也睡着，这是num就成2了，
 * 然后就会换成第一个线程醒来执行，所以就都输出是第二个使用timer的线程了
 * 这就是不使用synchronized的结果。使用它的目的就是锁定，这个线程执行的过程中就不会被别的打断了。
 */