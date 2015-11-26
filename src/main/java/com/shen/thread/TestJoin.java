package com.shen.thread;

/**
 * join方法定义在Thread类中，调用者必须是一个线程。
 *  	我们称当前调用join的线程为“子线程”，生成子线程的线程为“主线程”。
 *  
 *  为什么要用join()方法？
 *  	主线程生成并起动了子线程，而子线程里要进行大量的耗时的运算(这里可以借鉴下线程的作用)，当主线程处理完其他的事务后，需要用到子线程的处理结果，
 *   	这个时候就要用到join()方法了。
 *   
 *  join方法的作用
 *  	在网上看到有人说“将两个线程合并”。这样解释我觉得理解起来还更麻烦。不如就借鉴下API里的说法：“等待该线程终止。”
 *  	解释一下，是【主线程等待子线程】的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。(Waits for this thread to die.)
 * 
 * @author shen
 *
 */
public class TestJoin {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("abcde");
		t1.start();
		try {
			t1.join(); // 相当于方法的调用。合并线程t1
		} catch (InterruptedException e) {
		}

		for (int i = 1; i <= 10; i++) {
			System.out.println("i am main thread");
		}
	}
}

class MyThread2 extends Thread {
	MyThread2(String s) {
		super(s); // 调用父类的构造方法给他起个名字。
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("i am " + getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
