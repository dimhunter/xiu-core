package com.shen.thread.condition;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock Conditon，实现生产者和消费者模型
 * 
 * @author shenluguo
 *
 */
public class ConditonDemo {
	
	public static Lock lock = new ReentrantLock();;
	/** 容器已满  绑定 product 线程 **/
	public static Condition full = lock.newCondition();
	/** 容器为空  绑定 consumer 线程 **/
	public static Condition empty = lock.newCondition();

	public static void main(String[] args) {
		List<?> list = new ArrayList(12); //12个元素的仓库
		Product product = new Product(list, 10);
		Consumer consumer = new Consumer(list, 0);
		
		Thread t1 = new Thread(product);
		Thread t2 = new Thread(consumer);
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 生产线程
	 * @author shenluguo
	 */
	static class Product implements Runnable {
		private List list;
		private int maxCount;
		
		/**
		 * @param list 当前仓库中元素个数
		 * @param maxCount 仓库中元素最大值
		 */
		public Product(List list, int maxCount) {
			super();
			this.list = list;
			this.maxCount = maxCount;
		}

		public void run() {
			while(true){
				if (lock.tryLock()) {
					try {
						//如果当前仓库中list多于最大值，就不生产。
						if (getSize() >= maxCount) {
							System.out.println("容器已满，product线程加入池中...");
							full.await();
						}
						//else没有写，如果当前仓库中list少于最大值，就开始生产。
						System.out.println("开始生产....");
						list.add(new Object());
						//唤醒消费者线程
						empty.signal();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println("未获取生产资格...");
				}
			}
		}
		
		/**
		 * 获取仓库list中当前元素个数
		 * @return
		 */
		public int getSize() {
			return list.size();
		}
	}

	/**
	 * 消费线程
	 * @author shenluguo
	 *
	 */
	static class Consumer implements Runnable {

		private List list;
		private int minCount;
		
		/**
		 * @param list 当前仓库中元素个数
		 * @param minCount 仓库中要求元素最小值
		 */
		public Consumer(List list, int minCount) {
			super();
			this.list = list;
			this.minCount = minCount;
		}

		public void run() {
			while(true){
				if (lock.tryLock()) {
					try {
						if (getSize() <= minCount) {
							System.out.println("容器已空，consumer线程加入池中...");
							empty.await();
						}
						System.out.println("开始消费....");
						list.remove(0);//while死循环中不停地移除第一个元素，代表在消费。
						//唤醒生产者线程
						full.signal();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println("未获取消费资格...");
				}
			}
		}
		
		public int getSize() {
			return list.size();
		}
	}
	
}