package jvm;

public class Test1 {
	
	public static void test1() throws InterruptedException{
		{
			byte[] b = new byte[6*1024*1024];
			Thread.currentThread().sleep(1000);
			byte[] c = new byte[6*1024*1024];
			Thread.currentThread().sleep(1000);
			byte[] d = new byte[6*1024*1024];
			Thread.currentThread().sleep(1000);
			byte[] e = new byte[6*1024*1024];
//			b = null;
		}
		System.gc();
		System.out.println("first gc orver");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test1.test1();
	}
	
}
