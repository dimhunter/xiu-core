package com.shen.thread;

/**
 * 
 *  有三种方法可以使终止线程。 
    1.  线程正常退出，也就是当run方法完成后线程自动终止。 注意while(true)的情况，就需要设置boolean变量来控制退出。
    2.  使用stop方法强行终止线程（这个方法不推荐使用，因为stop和suspend、resume一样，也可能发生不可预料的结果）。 
    3.  使用interrupt方法中断线程
 * 
 * 
 * 
 * 结束线程的第3种方法（第一种情况）
 * 
 * 	 使用interrupt方法来中断线程可分为两种情况： 
    	（1）线程处于阻塞状态，如使用了sleep方法。 
    	（2）使用while（！isInterrupted（））{……}来判断线程是否被中断。 
 * @author shen
 *
 */
public class EndThread3_interrupt1 extends Thread {
	public void run(){ 
        try{ 
            sleep(50000);  // 延迟50秒 
        }catch (InterruptedException e){ 
            System.out.println("异常了="+e.getMessage()); 
        } 
    } 
    public static void main(String[] args) throws Exception { 
        Thread thread = new EndThread3_interrupt1(); 
        thread.start(); 
        System.out.println("在50秒之内按任意键中断线程!"); 
        System.in.read(); //等待用户输入 
        thread.interrupt(); 
        
        //合并到main主线程,如果不join的话，main方法会立即执行完，打印最后一行"线程已经退出!"，5秒后EndThread3才结束。
        //join了以后，就会合并到main线程里，5秒后才会输出最后一句话"线程已经退出!"
        thread.join(); 
        System.out.println("线程已经退出!"); 
    } 

}
