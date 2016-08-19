package com.shen.thread;

/**
 * wait()、notify()、notifyAll()是三个定义在Object类里的方法，可以用来控制线程的状态。
		这三个方法最终调用的都是jvm级的native方法。随着jvm运行平台的不同可能有些许差异。
		 
		如果对象调用了wait方法就会使持有该对象的线程把该对象的控制权交出去，然后处于等待状态。
		如果对象调用了notify方法就会通知某个正在等待这个对象的控制权的线程可以继续运行。
		如果对象调用了notifyAll方法就会通知所有等待这个对象控制权的线程继续运行。
		
		要非常注意的几个事实是
 
		任何一个时刻，对象的控制权（monitor）只能被一个线程拥有。
		无论是执行对象的wait、notify还是notifyAll方法，必须保证当前运行的线程取得了该对象的控制权（monitor）
		如果在没有控制权的线程里执行对象的以上三种方法，就会报java.lang.IllegalMonitorStateException异常。
		JVM基于多线程，默认情况下不能保证运行时线程的时序性

 * Created by shenluguo on 2015/6/15.
 */
public class NotifyTest {
    private String[] flag = { "true" };

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                //3秒后唤醒3个等待的线程。
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (flag) {
                flag[0] = "false";
                flag.notifyAll();
            }
        }
    };

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {
            synchronized (flag) {
                //在调用wait方法时，都是用while判断条件的，而不是if，在wait方法说明中，也推荐使用while，因为在某些特定的情况下，线程有
                // 可能被假唤醒，使用while会循环检测更稳妥。wait和notify方法必须工作于synchronized内部，且这两个方法只能由锁对象来调用
                while (flag[0] != "false") {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println("wait time :" + waitTime);
                }
                System.out.println(getName() + " end waiting!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        NotifyTest test = new NotifyTest();
        NotifyThread notifyThread = test.new NotifyThread("notify01");
        WaitThread waitThread01 = test.new WaitThread("waiter01");
        WaitThread waitThread02 = test.new WaitThread("waiter02");
        WaitThread waitThread03 = test.new WaitThread("waiter03");
        notifyThread.start();
        waitThread01.start();
        waitThread02.start();
        waitThread03.start();
    }

}