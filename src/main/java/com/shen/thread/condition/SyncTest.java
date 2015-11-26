package com.shen.thread.condition;

/**
 * Created by shenluguo on 2015/6/15.
 * 使用 synchronized 方式实现的锁
 */
public class SyncTest {
    public static void main(String[] args) {
        final Outputter output = new Outputter();
        new Thread() {
            public void run() {
                output.output("zhangsan");
            };
        }.start();
        new Thread() {
            public void run() {
                output.output("lisi");
            };
        }.start();
    }
}
class Outputter {
    //输出的字符串被打乱了，我们期望的输出结果是zhangsanlisi，这就是线程同步问题
    //加上synchronized就不会有不同步的问题，输出会是zhagnsanlisi或lisizhangsan
//    public void output(String name) {
    public synchronized void output(String name) {
        // 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
        for(int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
