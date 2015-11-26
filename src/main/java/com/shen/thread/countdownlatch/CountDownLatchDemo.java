package com.shen.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch类是一个同步计数器,构造时传入int参数,该参数就是计数器的初始值，每调用一次countDown()方法，计数器减1,
 * 计数器大于0 时，await()方法会阻塞程序继续执行CountDownLatch如其所写，是一个倒计数的锁存器，当计数减至0时触发特定
 * 的事件。利用这种特性，可以让主线程等待子线程的结束。下面以一个模拟运动员比赛的例子加以说明。
 *
 *  public CountDownLatch(int count);
    public void countDown();
    public void await() throws InterruptedException

    构造方法参数指定了计数的次数
    countDown方法，当前线程调用此方法，则计数减一
    awaint方法，调用此方法会一直阻塞当前线程，直到计时器的值为0
 *
 */
public class CountDownLatchDemo {
    private static final int PLAYER_AMOUNT = 5;
    public CountDownLatchDemo() {
        // TODO Auto-generated constructor stub
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //对于每位运动员，CountDownLatch减1后即结束比赛
        CountDownLatch begin = new CountDownLatch(1);
        //对于整个比赛，所有运动员结束后才算结束
        CountDownLatch end = new CountDownLatch(PLAYER_AMOUNT);
        Player[] plays = new Player[PLAYER_AMOUNT];

        for(int i=0;i<PLAYER_AMOUNT;i++)
            plays[i] = new Player(i+1,begin,end);

        //设置特定的线程池，大小为5
        ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
        for(Player p:plays)
            exe.execute(p);            //分配线程
        System.out.println("Race begins!");
        begin.countDown();
        try{
            end.await();            //等待end状态变为0，即为比赛结束
        }catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("Race ends!");
        }
        exe.shutdown();
    }
}