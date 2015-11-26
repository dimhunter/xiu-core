package com.shen.thread.future;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by shenluguo on 2015/6/15.
 *
 * ExecutorService继承自Executor，它的目的是为我们管理Thread对象，从而简化并发编程，Executor使我们无需显示的去管理线程的生命
 * 周期，是JDK 5之后启动任务的首选方式。
 *
 * Callable和Future，它俩很有意思的，一个产生结果，一个拿到结果。
 * Callable接口类似于Runnable，从名字就可以看出来了，但是Runnable不会返回结果，并且无法抛出返回结果的异常，而Callable功能更强大
 * 一些，被线程执行后，可以返回值，这个返回值可以被Future拿到，也就是说，Future可以拿到异步执行任务的返回值，
 *
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<Future<Integer>> fulist = Lists.newArrayList();

        for(int i = 1; i < 5; i++) {
            final int taskID = i;
            Future<Integer> fu = threadPool.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    return taskID;
                }
            });
            fulist.add(fu);
        }
        // 可能做一些事情
        for(int i = 0; i < fulist.size(); i++) {
            try {
                Future<Integer> f = fulist.get(i);
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}