package com.shen.thread.concurrent.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Executor框架是指java 5中引入的一系列并发库中与executor相关的一些功能类，其中包括线程池，Executor，Executors，ExecutorService，
 * CompletionService，Future，Callable等。
 * 
 * Executor 接口定义了最基本的 execute 方法，用于接收用户提交任务。
 * 
 * ExecutorService接口继承了Executor接口，并添加了一些生命周期管理的方法。ExecutorService 定义了线程池终止和创建及提交 futureTask（异步） 任务支持的方法。
 * 他的submit方法其实就是调用了父接口Executor的execute方法，并添加了future等任务处理。
 * 
 * AbstractExecutorService 是抽象类，主要实现了 ExecutorService 和 futureTask 相关的一些任务创建和提交的方法。
 * 
 * Executors类，提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。
 * 
 * ThreadPoolExecutor 是最核心的一个类，是Executors静态类创建的，是线程池的内部实现。线程池的功能都在这里实现了，平时用的最多的基本就是这个了。
 * Executor提交的和ExecutorService提交的任务都放到了他的任务队列里执行。研究源码。
 * 
 * @author shenluguo
 *
 */
public class ExecutorTest {
	
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(2);  
		Runnable task = new Runnable() {  
		    public void run() {  
		        System.out.println("task over");  
		    }  
		}; 
		Runnable task2 = new Runnable() {  
		    public void run() {  
		        System.out.println("task over2");  
		    }  
		}; 
		Runnable task3 = new Runnable() {  
		    public void run() {  
		        System.out.println("task over3");  
		    }  
		}; 
		executor.execute(task);
		executor.execute(task3);
		executor.execute(task2);
	}
	
}
