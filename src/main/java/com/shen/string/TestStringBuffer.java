package com.shen.string;

public class TestStringBuffer {

	public static void main(String[] args) {
		String s = "Mircosoft";
		char[] a = {'a','b','c'};
		//调用StringBuffer其中的一个构造方法
		StringBuffer sb1 = new StringBuffer(s);
		//public StringBuffer append(...) 这个方法是根据不同的参数将它加到StringBuffer字符序列后边
		sb1.append('/').append("IBM").append('/').append("SUN");
		
		System.out.println(sb1);
		
		StringBuffer sb2 = new StringBuffer("数字");
		for(int i=0; i<=9; i++){
			//还是append方法，只是参数不同，有好几种参数
			sb2.append(i);
		}
		System.out.println(sb2);
		
		//public StringBuffer delete(int start,int end)方法表示移除此序列的子字符串中的字符
		//public StringBuffer insert(...)表示将指定参数形式的字符序列插入到StringBuffer中。
		sb2.delete(8, sb2.length()).insert(0, a);
		
		System.out.println(sb2);
		//public StringBuffer reverse()表示将此字符序列用其反转形式取代。
		System.out.println(sb2.reverse());
	}
}
