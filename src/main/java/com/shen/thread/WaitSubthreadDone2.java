package com.shen.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WaitSubthreadDone2 {

	static ExecutorService executorService = Executors.newFixedThreadPool(1);

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		SubThread thread = new SubThread();
		// thread.start();
		Future future = executorService.submit(thread);
		mainThreadOtherWork();
		System.out.println("now waiting sub thread done.");
		future.get();
		System.out.println("now all done.");
		executorService.shutdown();
	}

	private static void mainThreadOtherWork() {
		System.out.println("main thread work start");
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread work done.");

	}

	public static class SubThread extends Thread {

		@Override
		public void run() {
			working();
		}

		private void working() {
			System.out.println("sub thread start working.");
			busy();
			System.out.println("sub thread stop working.");
		}

		private void busy() {
			try {
				sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
