package com.shen.thread;

/**
 * 
 *  有三种方法可以使终止线程。 
    1.  线程正常退出，也就是当run方法完成后线程自动终止。 注意while(true)的情况，就需要设置boolean变量来控制退出。
    2.  使用stop方法强行终止线程（这个方法不推荐使用，因为stop和suspend、resume一样，也可能发生不可预料的结果，不可预料的结果
    		就是调用这些方法后，不会释放资源和锁，所以可能会导致不可预料的结果）。 
    3.  使用interrupt方法中断线程
 * 
 * 
 * 
 * 结束线程的第1种方法
 * 	
 *  run方法完成后线程自动终止，但有时run方法是永远不会结束的。在这种情况下，一般是将这些任务放在一个循环中，如while循环。
 *  如果想让循环永远运行下去，可以使用while（true）{……}来处理。但要想使while循环在某一特定条件下退出，最直接的方法就是
 *  设一个boolean类型的标志，并通过设置这个标志为true或false来控制while循环是否退出。如本例。
 * @author shen
 *
 */
public class EndThread1_Flag extends Thread{
	
	//使用了一个Java关键字volatile，这个关键字的目的是使exit同步，也就是说在同一时刻只能由一个线程来修改exit的值。
	public volatile boolean exit = false; 

    public void run(){ 
    	System.out.println("---run---");
        while (!exit); 
    } 
    
    public static void main(String[] args) throws Exception{ 
    	EndThread1_Flag thread = new EndThread1_Flag(); 
        thread.start(); 
        sleep(5000); // 主线程延迟5秒 
        thread.exit = true;  // 5秒后，终止线程thread 
        thread.join(); 
        System.out.println("线程退出!"); 
    } 

}
