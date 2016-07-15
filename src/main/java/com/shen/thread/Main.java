package com.shen.thread;

/**
 * Created by shenge on 16/7/8.
 */
public class Main {

    public static void main(String[] args) {
//        ServiceManager.startAll();
        ServiceManager.sync();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ServiceManager.shutdown();
    }
}
