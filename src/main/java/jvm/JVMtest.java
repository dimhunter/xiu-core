package jvm;

/**
 * 用jvisualvm观看，当对象大小大于10M时，直接分配到old老年代了。jdk7下测试。
 * 
 * @author shen
 *
 */
public class JVMtest {
	
	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("---------------");
		byte[] aa = new byte[10 * _1MB];
		Thread.sleep(1000000);
	}
	
}
