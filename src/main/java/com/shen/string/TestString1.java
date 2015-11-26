package com.shen.string;

public class TestString1 {
	public static void main(String[] args){
		//这种直接定义不是new出来的叫字符串常量，"hello"放在内存的data区里，只产生一次。s1放在栈里，s1指向"hello"。
		String s1 = "hello";
		String s2 = "world";
		String s3 = "hello";
		System.out.println( s1 == s3 ); //true
		
		//new出来的就叫对象了，不是字符串常量了。是要分配堆内存空间的，两个"hello"放在堆里的不同位置，s1和s2在栈的不同
		//位置，分别指向他们，所以不相等。
		s1 = new String("hello");
		s2 = new String("hello");
		System.out.println( s1 == s2 ); //false
		//String类重写了object类的equals方法，意思是比较两个字符串对象的字符序列，也就是只要表面值相同就返回true
		System.out.println( s1.equals(s2)); //true
		
		//定义个字符数组
		char c[] = {'s','u','n',' ','j','a','v','a'};
		//调用String类的两个构造方法产生new两个对象。第二个的意思是从第4个元素开始取3个组成字符串。
		String s4 = new String(c);
		String s5 = new String(c,4,3);
		System.out.println(s4); //sun java
		System.out.println(s5); //jav
		
	}
}
