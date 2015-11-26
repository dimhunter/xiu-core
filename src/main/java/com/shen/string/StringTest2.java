package com.shen.string;

public class StringTest2 {
	public static void main(String[] args){
		//new就是先看string池里有没有，有就不建，没有就在池里建一个，然后在堆立在建一个。
		//s最后指向的都是堆里的。
		String s = new String("abc");
		
		//没有new的就是先看池里有没有，有就指向它，没有的就在池里建一个，
		//此时池里有s建立的了，所以就不建了，最后s1指向的是池里的。
		String s1 = "abc";
		String s4 = "abc";
		//这个和s是一样的，池里有就不再建，但s2最后指向又新new出的一个abc，虽然值相同
		//但是内存地址是不同的，只要有new就肯定有新对象产生，值相同但内存地址是不同的
		String s2 = new String("abc");
		
		System.out.println(s == s1);
		System.out.println(s == s2);
		System.out.println(s1 == s2);
		System.out.println(s1 == s4);//都是池里的，所以相等

		System.out.println(s == s.intern());
		System.out.println(s1 == s1.intern());
		System.out.println(s.intern() == s2.intern());
		
	}
}
