package com.shen.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 所有容器类对象在调用remove，contains，或者在检查是否重复元素，比如list和set的区别时，都需要比较对象是否相等，比较相等
 * 都是用得equals方法，equals相等为true的话那么hashCode必须相等。
 * 相等的对象应该具有相等的hashCode。
 * 对于自定义的类型，需重写equals和hashCode方法，两个方法必须同时重写或不写，以实现自定义的对象相等规则。
 * @author shen
 *
 */
public class CollectionsTest {
	
	public static void main(String[] args){
		
		List<String> l1 = new LinkedList<String>();
		
		for(int i=0;i<=9;i++){
			l1.add("a"+i);
		}
		System.out.println(l1);
		/**
		 * java.util.Collections类提供了一些静态的方法对容器对象进行操作，最多的是对list对象的操作
		 */
		
		Collections.reverse(l1); //对list容器内的元素逆序排列
		System.out.println(l1);
		Collections.shuffle(l1); //对list容器内的元素随机排列
		System.out.println(l1);
		Collections.sort(l1);    //根据元素的自然顺序，对list容器内的元素排序
		System.out.println(l1);
		
		
		//二分法查找
		System.out.println(Collections.binarySearch(l1, "a5"));
	}
	
}
