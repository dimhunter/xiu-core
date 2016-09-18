package jvm;

import java.util.HashMap;

public class StopWorldTest {
	
	public static class Mythread extends Thread{
		HashMap map = new HashMap();

		@Override
		public void run() {
			try {
				while(true){
					if(map.size()*512/1024/1024>=400){
						map.clear();
						System.out.println("map clear !");
					}
					byte[] b1;
					for(int i=0;i<100;i++){
						b1 = new byte[512];
						map.put(System.nanoTime(), b1);
					}
						Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class PrintThread extends Thread{
		public static final long startTime = System.currentTimeMillis();

		@Override
		public void run() {
			try {
				while(true){
					long t = System.currentTimeMillis() - startTime;
					System.out.println(t/1000+ "."+t%1000);
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Mythread m = new Mythread();
		PrintThread p = new PrintThread();
		m.start();
		p.start();
	}
	
}
