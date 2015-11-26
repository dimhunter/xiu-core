package com.shen.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * 所有实现了Collection接口的容器类都有一个iterator方法，返回一个实现了Iterator接口的对象。称作迭代器，用以
 * 方便的实现对容器内元素的遍历操作。Iterator接口共有3个方法，如下：
 * 1. boolean hasNext();  如果仍有元素可以迭代，则返回 true。
 * 2. Object next();	      返回迭代的下一个元素。
 * 3. void remove();	      从迭代器指向的 collection 中移除迭代器返回的最后一个元素。
 * 
 * @author shen
 *
 */
public class IteratorTest {
	public static void main(String[] args){
		//多态！！！
		Collection<String> c = new ArrayList<String>();
		c.add("aaaa");
		c.add("bbb");
		c.add("cc");
		c.add("ddddd");
		c.add("e");
		
		//相当于省略了for循环中的表达式3
		//for循环执行过程:首先计算表达式1，接着执行表达式2，若表达式2的值=true，则执行一次循环体语句，接着
		//计算表达式3，再判断表达式2的值，依次重复下去，直到表达式2的值=false。
		for(Iterator<String> i = c.iterator(); i.hasNext(); ){
			String element = i.next();
			if(element.length()<3){
				//Iterator对象的remove方法是在容器迭代或遍历过程中删除元素的唯一安全的方法。
				i.remove();
				
				//用容器的remove方法会产生java.util.ConcurrentModificationException异常，原因就是你不能在对一个容器进行遍历的时候将其中的元素删除掉。
//				c.remove(element);
			}
		}
		System.out.println(c);
	}
}
