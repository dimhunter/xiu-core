package com.shen.thread;

/*
 * 功能：制造线程同步问题
 */
public class MaiPiao {
    public static void main(String[] args) {
        TicketWindow tw1 = new TicketWindow();
        
        Thread t1 = new Thread(tw1);
        Thread t2 = new Thread(tw1);
        Thread t3 = new Thread(tw1);
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketWindow implements Runnable{
//    private int num = 100 ;
    private static int num = 100 ;//加不加static都是一样的，同步是靠synchronized。
    //间隔1s出票
    public void run() {
        while(true){
//        	synchronized (this) {
            if(num>0){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在售出第"+num+"张票");
                num--;
            }else break;
//        	}
        }
    }
}
