package com.shen.thread;
/**
 * 区别与联系：
1， 一个类只能继承一个父类，存在局限；一个类可以实现多个接口
2， 在实现Runable接口的时候调用Thread的Thread（Runnable run）或者Thread(Runnable run ,String name)构造方法创建进程时，使用同一个Runnable实例，如上程序中使用的都是rt，则建立的多线程的实例变量也是共享的；
但是通过继承Thread类是不能用一个实例建立多个线程；
故而实现Runnable接口适合于资源共享；
当然，继承Thread类也能够共享变量，能共享Thread类的static变量；
3， Runnable接口和Thread之间的联系：
public class Thread extends Object implements Runnable
可以看出Thread类也是Runnable接口的子类；
下面大家可以直接去看Thread的源代码。Java <wbr>多线程实现接口Runnable和继承Thread区别
 * @author shen
 *
 */
public class ThreadVsRunnable {
	public static void main(String[] args) {
		ExtendsThread et1 = new ExtendsThread("w1");
		ExtendsThread et2 = new ExtendsThread("w2");
		et1.start();
		et2.start();
		System.out.println("-------------------");
		
		RunnableThread rt = new RunnableThread();
		Thread t3 = new Thread(rt);
		Thread t4 = new Thread(rt);
		t3.start();
		t4.start();
		
	}
}


class ExtendsThread extends Thread{
	private int ticket = 10;  
    private String name;
    
	public ExtendsThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i =0;i<500;i++){  
            if(this.ticket>0){
            	System.out.println("thread "+name+" : is running ticket > "+ticket--);
            }
		}
	}
}

class RunnableThread implements Runnable{
	private int ticket =10; 
	public void run() {
		for(int i =0;i<500;i++){  
            if(this.ticket>0){  
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));  
            }  
        }  		
	}
	
}