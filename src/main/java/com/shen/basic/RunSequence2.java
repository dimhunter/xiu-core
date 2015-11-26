package com.shen.basic;
/**
 * JAVA 执行顺序，用debug就可以看出来。
 * @author shen
 * 
 * 有继承的类在运行的时候，一定要记得：初始化子类必须先初始化父类，这是java程序的一个基本的运行过程。
 * java技术安全模式要求在子类执行任何东西之前，描述父类的一个对象的各个方面都必须初始化。
 * 有静态代码块的，先执行父类静态代码块，再执行子类静态代码块，再初始化父类，就是执行父类构造方法，初始化父类属性，再执行子类构造方法，初始化子类属性。
 * 牢记顺序。
 */
public class RunSequence2 extends Parent {
	private String name = "申哥";							// 16
	private int age = 20;									// 17
	static {												// 6 因为static块在static变量上边，所以先执行它。
		System.out.println("执行 子类 的静态代码块");			// 7
	}														// 8
	private static int a = 6;								// 9
	public RunSequence2() {									// 11
		System.out.println("执行 子类 构造方法，初始化 子类 "); // 18
		age = 100;											// 19
	}														// 20
	public static void main(String[] args) {				// 1
		RunSequence2 t = new RunSequence2();				// 10
		System.out.println( t.name + "的年龄是" + t.age );	// 21
		System.out.println( RunSequence2.a );				// 22
	}														// 23
}															// 24

/**
 * 父类
 * @author shen
 */
class Parent {
	private int num = 1;									// 13
	private static int a = 6;								// 2 因为它在static块上边，所以先执行它。
	static {												// 3
		System.out.println("执行 父类 的静态代码块");			// 4
	}														// 5
	public Parent() {										// 12
		System.out.println("执行 父类 构造方法，初始化 父类 ");	// 14
	}														// 15
	public void test(){                                     // 该方法没执行，初始化父类，并不是就是吧父类全部执行了。只是初始化执行个属性和构造方法。
		System.out.println("这是 父类 的test方法");
		System.out.println(num);
		System.out.println(Parent.a);
	}
}