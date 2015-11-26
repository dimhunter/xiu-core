//死锁就是我锁住了你需要的，你锁住了我需要的，都执行不下去了。
package com.shen.thread;

public class TestDeadLock implements Runnable {
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object(); //两个对象
	
	public void run() {
		
		System.out.println("flag=" + flag);
		
		if(flag == 1) {
			synchronized(o1) {             //锁住了o1
				try {
					Thread.sleep(500);        //锁住后睡眠，然后另一个线程执行。
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized(o2) {          //只要它再能锁住o2，就执行下一行打印
					System.out.println("1");	
				}
			}
		}
		if(flag == 0) {
			synchronized(o2) {           //锁住了o2
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized(o1) {       //只要它再能锁住o1，就执行下一行打印
					System.out.println("0");
				}
			}
		}
	}	
	
	public static void main(String[] args) {
		TestDeadLock td1 = new TestDeadLock();
		TestDeadLock td2 = new TestDeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
		
	}
}

/*
程序执行的结果最后是停在那里不动了，不能输入命令了也就，只能强制关闭窗口了。因为互相锁住了。
小故事就是哲学家们用筷子吃饭的故事。
*/