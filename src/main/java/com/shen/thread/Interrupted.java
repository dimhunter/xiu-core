package com.shen.thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {
	public static void main(String[] args) {
		// sleepThread不停的尝试睡眠
		Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
		sleepThread.setDaemon(true);
		// busyThread不停的运行
//		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
//		busyThread.setDaemon(true);
		sleepThread.start();
		
//		busyThread.start();
		// 休眠5秒，让sleepThread和busyThread充分运行
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("SleepThread interrupted is 1 " + sleepThread.isInterrupted());
		sleepThread.interrupt();
//		busyThread.interrupt();
		System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
//		System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
		// 防止sleepThread和busyThread立刻退出
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SleepThread interrupted is 3 " + sleepThread.isInterrupted());
	}

	static class SleepRunner implements Runnable {
		public void run() {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

 class BusyRunner implements Runnable {
		public void run() {
			System.out.println("88888888888");
//			while (true) {
//			}
		}
	}
}
