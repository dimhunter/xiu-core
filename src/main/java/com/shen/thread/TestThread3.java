package com.shen.thread;

public class TestThread3{
	public static void main(String args[]) {
		Runner3 r = new Runner3();
		Thread t = new Thread(r);
		t.start();
	}
}

class Runner3 implements Runnable {
	public void run() {
		for(int i=0; i<30; i++) {	
			if(i%10==0 && i!=0) {
				try{
					Thread.sleep(2000); //遇到能被10整除且不为0的数是停顿2000毫秒。
				}catch(InterruptedException e){}
			}
			System.out.println("No. " + i);
		}
	}
}

