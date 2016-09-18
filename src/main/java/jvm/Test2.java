package jvm;

public class Test2 {
	
	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i< Integer.MAX_VALUE; i++){
			byte[] a = new byte[1*_1MB];
			Thread.sleep(200);
		}
	}
	
}
