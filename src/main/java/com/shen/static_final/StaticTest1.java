package com.shen.static_final;

/**
 *   static修饰符能够与  属性、方法和内部类(只能是内部类，一般类不行) 一起使用，表示是“静态”的。切记这3种修饰。 
 *   类中的静态变量和静态方法能够与“类名”一起使用，不需要创建一个类的对象来访问该类的静态成员。所以 static 修饰
 *   的变量又称作“类变量” 。这与实例变量不同。实例变量总是用对象来访问，因为它们的值在对象和对象之间有所不同。 
 *   下列示例展示了如何访问一个类的静态变量： 
 * @author shen
 */

public class StaticTest1{
	public static void main(String[] args){
		System.out.println("类变量i="+StaticModifier.i);
		StaticModifier s=new StaticModifier();	
		System.out.println("实例变量j="+s.j);
	}
}


class StaticModifier{
	static int i=10;
	int j;
	
	/**
	 * 构造方法初始化j
	 */
	StaticModifier(){
		j=20;	
	}	
}