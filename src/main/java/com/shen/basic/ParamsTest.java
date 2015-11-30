package com.shen.basic;
/**
 * 参数讲解
 * @author shen
 * 
 * 形参：就是形式参数的意思。是在定义方法名的时候使用的参数，用来标识方法接收的参数类型，在调用该方法时传入。 
 * 实参：就是实际参数的意思。是在调用方法时传递给该方法的实际参数。 
 * 
 * 形参和实参有如下基本规则： 
 *	（1） ：形参和实参的类型必须要一致，或者要符合隐含转换规则 
 *	（2） ：形参类型不是引用类型时，在调用该方法时，是按值传递的。在该方法运行时，形参和实参是不同的变量，它们
 *		在内存中位于不同的位置，形参将实参的值复制一份，在该方法运行结束的时候形参被释放，而实参内容不会改变。 
 *      如doSomeThing1(int a) 传递的是值。
 *	（3） ：形参类型是引用类型时，在调用该方法时，是按引用传递的。运行时，传给方法的是实参的地址，在方法体内部
 *		使用的也是实参的地址，即使用的就是实参本身对应的内存空间。所以在函数体内部可以改变实参的值。 
 *		如doSomeThing2(User u) 传递的是引用。
 */

public class ParamsTest {
	
	/**
	 *  
	 * 比如：下面的例子中“int a”就是个形式参数，这里只是表示需要传入一个整数，这个方法才能正常运行，但具体传入
	 * 的是几，要到真正使用的时候，也就是调用这个方法的时候才具体确定，假如调用的时候传入“8” ，8就是个实际参数。
	 *  
	 * @param a
	 */
	public void doSomeThing1(int a){
		System.out.println(a);
	}
	
	/**
	 * 传递的是引用
	 * 
	 * @param u
	 */
	public void doSomeThing2(User u){
		System.out.println(u);
	}
	
	/**
	 * 从JDK5.0开始，提供了参数可变的方法。 
	 * 当不能确定一个方法的入口参数的个数时，5.0 以前版本的 Java 中，通常的做法是将多个参数放在一个数组或者
	 * 对象集合中作为参数来传递，5.0 版本以前的写法是：void testParams(int[] a) 
	 * 5.0以后是用下边的方法，用3个点来表示传入参数的个数并不确定。但请注意：传入参数的类型必须是一致的，究
	 * 其本质，就是一个数组。
	 *  
	 * @param a
	 */
	public void testParams(int... a){
		System.out.println(a);
	}
	
}


/**
 * 人对象
 * @author shen
 */
class User{
	
}