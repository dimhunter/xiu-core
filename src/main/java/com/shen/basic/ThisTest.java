package com.shen.basic;
/**
 * this关键字讲解
 * @author shen
 * 
 * this关键字代表自身，在程序中主要有以下用途。
 */
public class ThisTest {
	
	private String name; //定义一个成员变量name
	private int i = 2;   //定义一个成员变量i

	public String hello() {
		return "hello";
	}
	
	/**
	 * 1. 调用本类中的属性，也就是类中的成员变量。
	 */
	public void test1(String hello){
		this.name = hello + this.name;
		//java会自动将所有的成员变量和方法与this关键字联系在一起，因此，可以省略，也可以写成如下形式：
		name = hello + name;
		
		//当成员变量和方法内部定义的变量名相同时，this是不多余的。到底是调用谁呢。
		//也就是说：“this.变量”调用的是当前属性的变量值，直接使用变量名称调用的是相对 "距离最近" 的变量的值。 
		int i = 3; //跟类的属性的变量名称是相同的。
		System.out.println("实例变量 i= " + this.i); //结果是2。
		System.out.println("方法内部变量 i= " + i);  //结果是3。
	}
	
	/**
	 * 2. 调用本类中的其他方法。
	 */
	public void test2(){
		this.hello();
		//也可以省略
		hello();
	}
	
	/**
	 * 3. 代表自身对象(和new不同，new是产生一个新的，this就是当前，自身)
	 * 
	 * 在一个类的内部，也可以使用this代表自身类的对象，或者换句话说，每个类内部都有一个隐含的成员变量，该成员变量的类型
	 * 是该类的类型，该成员变量的名称是this，实际使用this代表自身类的对象的示例代码如下：
	 * 在构造方法内部，将对象this的值赋值给instance。
	 */
//	ThisTest instance;
//
//	public ThisTest(){
//		instance = this;
//	}

	public void test3(){
		System.out.println(this);
		System.out.println(new AAAAA(this));
	}
	
	
	/**
	 * 4. 调用本类中的其他构造方法，调用时一定要放在构造方法的第一行。
	 */
	public ThisTest() {
//		System.out.println("---");
		this("aaa");//调用下边那个带参数String a的构造方法。必须放在这个构造方法的第一行，前边有任何东西都会出错。
		System.out.println("------");
	}
	
	public ThisTest(String a) {
		this.hello();
	}

}

/**
 * 测试类
 * @author shen
 */
class AAAAA{
	/**
	 * 构造方法
	 * @param tt
	 */
	public AAAAA(ThisTest tt){
	}
}
