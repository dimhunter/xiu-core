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
 * 结束线程的第2种方法
 * 
 * 	 虽然可以终止线程，但使用stop方法是很危险的，就象突然关闭计算机电源，而不是按正常程序关机一样，可能会产生不可预料的结果
 * @author shen
 *
 */
public class EndThread2_Stop extends Thread{

    public void run(){ 
        System.out.println("---run---");
    } 
    
    public static void main(String[] args) throws Exception{ 
    	EndThread2_Stop thread = new EndThread2_Stop(); 
        thread.start(); 
        sleep(5000); // 主线程延迟5秒
        thread.stop(); //5秒后结束
        System.out.println("线程退出!"); 
    } 

}
