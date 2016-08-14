package com.shen.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue接口与List、Set同一级别，都是继承了Collection接口。LinkedList实现了Queue接 口。
 * Queue接口窄化了对LinkedList的方法的访问权限（即在方法中的参数类型如果是Queue时，就完全只能访问Queue接口所定义的方法 了，
 * 而不能直接访问 LinkedList的非Queue的方法），以使得只有恰当的方法才可以使用。
 * 
 * 在Java多线程应用中，队列的使用率很高，多数生产消费模型的首选数据结构就是队列。Java提供的线程安全的Queue可以分为阻塞队列和非阻塞队列，
 * 其中阻塞队列的典型例子是BlockingQueue，非阻塞队列的典型例子是ConcurrentLinkedQueue。都继承了Queue接口。
 * 
 * 	add        	增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
	remove   	移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
	element  	返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
	offer       添加一个元素并返回true       如果队列已满，则返回false
	poll        移除并返问队列头部的元素    如果队列为空，则返回null
	peek       	返回队列头部的元素             如果队列为空，则返回null
	put         添加一个元素                      如果队列满，则阻塞
	take        移除并返回队列头部的元素     如果队列为空，则阻塞
	----------------------------
	可能报异常		返回布尔值		可能阻塞		设定等待时间
	入队	add(e)		offer(e)		put(e)		offer(e, timeout, unit)
	出队	remove()	poll()			take()		poll(timeout, unit)
	查看	element()	peek()			无			无
	
	(顶级接口)Collection-->Queue-->Deque-->LinkedList(实现类)
 * 
 * @author shenluguo
 *
 */
public class QueneTest {
	/**
     * 测试队列
     * <pre>
     * 队列特点，先进先出，后进后出，火车过山洞例子
     * </pre>
     */
    static void testQueue(){
    	//(顶级接口)Collection-->Queue-->Deque-->LinkedList(实现类)
        Queue<String> queue=new LinkedList<String>();
        //添加几个元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        System.out.println("队列中的元素是:"+queue);
        //弹出元素
        queue.poll();
        System.out.println("队列中的元素是:"+queue);
        //查看队列中首个元素，并不移除
        String peek=queue.peek();
        System.out.println("查看队列中首个元素，并不移除:"+peek);
        System.out.println("队列中的元素是:"+queue);
    }
    
    
    /**
     * 测试栈
     * <pre>
     * 先进后出，后进先出，水桶倒水
     * </pre>
     */
    static void testStack(){
        Stack<String> stack=new Stack<String>();
        //添加几个元素
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");
        stack.add("5");
        System.out.println("栈中的元素是:"+stack);
        //弹出元素
        stack.pop();
        System.out.println("栈中的元素是:"+stack);
        //查看栈中首个元素，并不移除
        String peek=stack.peek();
        System.out.println("查看栈中首个元素，并不移除:"+peek);
        System.out.println("栈中的元素是:"+stack);
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        testQueue();
        System.out.println("-------栈--------");
        testStack();
    }
}
