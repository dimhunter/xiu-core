package com.shen.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shenluguo on 2015/6/11.
 */
public class Player implements Runnable{

    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;
    public Player(int i, CountDownLatch begin, CountDownLatch end) {
        // TODO Auto-generated constructor stub
        super();
        this.id = i;
        this.begin = begin;
        this.end = end;
    }

    public void run() {
        // TODO Auto-generated method stub
        try{
            begin.await();        //等待begin的状态为0
            Thread.sleep((long)(Math.random()*100));    //随机分配时间，即运动员完成时间
            System.out.println("Play"+id+" arrived.");
        }catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            end.countDown();    //使end状态减1，最终减至0
        }
    }

}
