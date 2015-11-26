package com.shen.basic;


/**
 * 第一个程序
 * 	1、源文件名必须和public修饰的类名一致，以.java作为文件后缀，如果定义的类不是public的，则文件名与类名可以不同。
 *	2、一个.java文件中可以有多个class，但是只有一个public修饰的类。
 *	3、java源代码文件编译后，一个类对应生成一个.class文件
 *	4、一个java应用程序应该包含一个main()方法，而且其签名是固定的，它是应用程序的入口方法，可以定义在任意一个类中，不一定是public修饰的类
 * 执行时，用的是java命令，后面跟的是含有main方法的类的类名，如 java HelloWorld.class，或 java AAA.class。java是根据所执行的类名进入不同入口，也就是main方法。
 * 
 * 	编译：javac -d . HelloWorld.java
 *			含有包的类，在编译的时候最好用上面的格式，-d指的是让该类生成的时候按照包结构去生成，" . "指的是在当前路径下生成
 *		如果不用上面的格式，也可以用javac HelloWorld.java，但是需要注意的是包结构就要由自己去建立，然后将生成的.class文件放到该目录下
 *	执行：java mypack.HelloWorld
 *		将字节码文件交给Java虚拟机去解释执行
 *		需要注意的事，必须使用包名.类名去解释执行
 * 
 * @author shen
 */
public class HelloWorld {

	/**
	 * main函数
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----- hello world java 11 ------");
	}

}

class AAA{
	public static void main(String[] args) {
		System.out.println("----- hello world java 22 ------");
	}
}

class BBB{
	
}