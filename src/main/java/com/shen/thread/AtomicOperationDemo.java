package com.shen.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ava.util.concurrent中实现的原子操作类包括： 
	AtomicBoolean、AtomicInteger、AtomicIntegerArray、AtomicLong、AtomicReference、 
	AtomicReferenceArray。
 * @author shen
 *
 */
public class AtomicOperationDemo {  
       static AtomicInteger count=new AtomicInteger(0);  
       public static class AddThread implements Runnable{  
    	   
        @Override  
        public void run() {  
            for(int k=0;k<1000;k++){  
                count.incrementAndGet();  
            }  
         }   
       }  
       public static void AtomicIntShow(){  
         System.out.println("AtomicIntShow() enter"); 
         //10个线程的线程池
         ExecutorService threadpool = Executors.newFixedThreadPool(10);  
          //提交100个人无语，每个+1000次incrementAndGet，1000*100,最后结果应该是100000
         for(int k=0;k<100;k++){  
             threadpool.submit(new AddThread());  
         }  
           
         try {  
            Thread.sleep(2000);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
           
         /* output 
          * AtomicIntShow() enter 
          * result of acumulated sum=100000 
          * AtomicIntShow() exit 
          */  
           
         System.out.println("result of acumulated sum="+count);  
         threadpool.shutdown();  
         System.out.println("AtomicIntShow() exit");  
         return ;  
    } 
       
       public static void main(String[] args) {  
           AtomicOperationDemo.AtomicIntShow();  
       }  
} 
