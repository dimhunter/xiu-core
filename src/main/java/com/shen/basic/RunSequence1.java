package com.shen.basic;
/**
 * JAVA 执行顺序，用debug就可以看出来。
 * 注意static变量和static代码块的特殊之处。他们执行顺序是自上而下执行的，并且在构造方法之前。
 * static和final是不一样的，static修饰的变量值可变，叫做类变量，用类名访问，static变量只会有一个内存空间
 * final修饰的叫常量，值不可变，final的才是常量。
 * @author shen
 */
public class RunSequence1 {
		
	private String name = "申哥";                         // 8 初始化一个类，就要先初始化它的所有属性(初始化属性是不包括static静态常量和static静态块和static方法，不属于一类，也就是除static之外的其他所有东西，包括代码块。)
	private int age = 25;                                 // 9
	
	static{												 // 2 因为它在static变量上边
		System.out.println("--");						 // 3
	}													 // 4
	
	{													 //10 再执行一个类的构造方法new一个对象前，除去static的东西，是要初始化类的所有属性，包括
		System.out.println("初始化块");					 //11	变量和代码块，他们的顺序也是从上到下，谁在前先执行谁。
	}													 //12
	
	private static int a = 6;							 // 5
	
	public RunSequence1(){                                // 7 构造方法，接下来有人认为应该执行下一行age=100了，其实不是
														  //  应是执行8，这里很重要！！！！初始化一个类，就要先初始化它的所有属性
		age = 100;                                        // 13 属性都初始化完以后，才回到构造方法里执行执行方法里的代码
	}                                                     // 14
	 
	public static void main(String[] args) {               // 1
		RunSequence1 t = new RunSequence1();               // 6  一new就要执行构造方法，构造方法之前是自上而下执行static变量和方法。
		System.out.println( t.name + "的年龄是" + t.age ); // 15
		System.out.println(RunSequence1.a);  			   // 16
	}                                                      // 17
	 
} 
