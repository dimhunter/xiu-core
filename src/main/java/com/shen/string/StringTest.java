package com.shen.string;

/**
 * 字符串
 * 
 * String就是用双引号引起来的任意多个字符。
 * String 不是原始的数据类型，而是一个类。String的默认值是null。
 * @author shen
 *
 */
public class StringTest {
	 public static void main(String[] args) {
	  String a = "hello";
	  String b = "hello";
	  
	  String newA = new String("hello");
	  String newB = new String("hello");
	  
	  System.out.println("****** Testing Object == ******");
	  System.out.println("a==b ? :" + (a==b));//true
	  System.out.println("newA==newB ? :" +(newA==newB));//false
	  System.out.println("a==newA ? :" + (a==newA));//false
	  
	  //关于String对象的intern()方法的说明
	  //一个初始时为空的字符串池，它由类 String 私有地维护,当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象
	  //由 equals(Object) 方法确定），则返回池中的字符串。否则，将此String 对象添加到池中，并且返回此String 对象的引用，因
	  //此a.intern(),b.intern(),newA.intern(),newB.intern()隐含的各自在栈中分配了各自的内存区域，同时都将栈中的应用全部指向
	  //了String pool常量池中的同一块区域"hello"
	  System.out.println("***** Testing String Object intern method******");
	  System.out.println("a.intern()==b.intern() ? : " + (a.intern()==b.intern()));
	  System.out.println("newA.intern()==newB.intern() ? :" + (newA.intern()==newB.intern()));
	  System.out.println("a.intern()==newA.intern() ? :" + (a.intern()==newA.intern()));
	  System.out.println("a=a.intern() ? :" + (a==a.intern()));
	  System.out.println("newA==newA.intern() ? : " + (newA==newA.intern()));//false
	  
	  System.out.println("****** Testing String Object equals method******");
	  System.out.println("equals() method :" + a.equals(newA));//true
	  
	  String c = "hel";
	  String d = "lo";
	  final String finalc = "hel";
	  final String finalgetc = getc();
	  
	  System.out.println("****** Testing Object splice ******");
	  //JVM对于字符串常量的"+"号连接，在程序编译期，JVM就将常量字符串的"+"连接优化为连接后的值，因此"hel" + "lo"优化后完全等同于"hello"  
	  System.out.println("a==\"hel\"+\"lo\" ? :" + (a=="hel"+"lo")); 
	  //JVM对于字符串引用，由于在字符串的"+"连接中，有字符串引用存在，而引用的值在程序编译期是无法确定的，所以c+\"lo\"实际是c在栈中保存的地址+字符串"lo"于
	  //常量池中指向的地址 所指向的在堆中新分配的一块内存空间  
	  System.out.println("a==c+d ? : " + (a==c+d));
	  System.out.println("a==c+\"lo\" ? : " + (a==c+"lo"));
	  //对于final修饰的变量，它在编译时被解析为常量值的一个本地拷贝存储到自己的常量 池中或嵌入到它的字节码流中，在编译期就已经确定了内存空间
	  //地址，所以此类似于2个字符串常量的+  
	  System.out.println("a==finalc+\"lo\" ? :" + (a == finalc + "lo"));
	  System.out.println("a==finalgetc+\"lo\" ? :" + (a == finalgetc+"lo"));
	  
	  //字符串拼接
	  //1. 在拼接静态字符串时，尽量用 +，因为通常编译器会对此做优化。
	  //2. 在拼接动态字符串时，尽量用 StringBuffer 或 StringBuilder的 append，这样可以减少构造过多的临时 String 对象（javac编译器会对String连接做自动优化）：
	  String jingtai = "aaa" + "bbb"; //写死的才叫静态
	  String dongtai1 = "ccc";
	  String dongtai2 = "ddd";
	  String dt = dongtai1 + dongtai2; //这种虽然值是写死，但是有引用，这不叫静态字符串。
	  String dongtai = new StringBuffer().append(dongtai1).append(dongtai2).toString();

	 }
	 private static String getc(){
		 return "hel";
	 } 
}