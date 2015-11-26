package com.shen.thread.condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock接口里定义了一些抽象的锁操作，有无条件、可轮询、定时、可中断的锁获取操作，ReentrantLock实现了Lock接口。
 * Lock提供了一些其他方法，比如tryLock()：如果当前锁可用则获取并返回true，如果不可用则返回false。在方法前加上while(true)就可以实现轮询获取锁。
 * 
 * 通过使用tryLock方法就可以让那些等待线程可以不用再无限期等待，可以继续轮询获取锁或者做其他操作。
 * tryLock还有一个指定时间获取锁的方法，在指定时间内如果锁可用则返回，不可用则线程处于休眠状态。lock.tryLock(3, TimeUnit.SECONDS).
 * 
 * 该例展示了2个线程争抢去进行tryLock操作获取锁。
 * 
 * @author shenluguo
 *
 */
public class TryLockDemo {

	// 锁
	private final Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		TryLockDemo t = new TryLockDemo();
		Take take = new Take(t);
		Put put = new Put(t);
		Thread t1 = new Thread(take);
		Thread t2 = new Thread(put);

		t1.start();
		t2.start();
	}

	public void take() {
//		if (lock.tryLock(3, TimeUnit.SECONDS)) {
		if (lock.tryLock()) {
			try {
				System.out.println("take获取到锁...");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println("take没有获取到锁...");
		}
	}

	public void put() {
		if (lock.tryLock()) {
			try {
				System.out.println("put获取到锁...");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println("put没有获取到锁...");
		}
	}

}

/**
 * take线程死循环调用take方法去进行tryLock操作获取锁。
 * @author shenluguo
 *
 */
class Take implements Runnable {
	private TryLockDemo t;

	public Take(TryLockDemo t) {
		this.t = t;
	}
	public void run() {
		while (true) {
			try {
				//睡眠1秒，死循环达到每秒执行一次效果。
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.take();
		}
	}
}

/**
 * put线程死循环调用put方法去进行tryLock操作获取锁。
 * @author shenluguo
 *
 */
class Put implements Runnable {
	private TryLockDemo t;

	public Put(TryLockDemo t) {
		this.t = t;
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.put();
		}
	}
}