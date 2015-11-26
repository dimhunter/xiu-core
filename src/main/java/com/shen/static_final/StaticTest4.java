package com.shen.static_final;

/**
 * 静态初始器（Static  Initializer）是一个存在与类中方法外面的静态块。
 * 静态初始器仅仅在类装载的时候（第一次使用类的时候）执行一次。 静态初始器的功能是：往往用来初始化静态的类属性。 
 * 
 * @author shen
 */
public class StaticTest4 {

	public static void main(String[] args) {
		System.out.println("counter = "+ Count.counter);
		new Count().test();
	}

}

class Count{
	public static int counter;
	
	//只运行一次
	static {
		counter = 123;
		System.out.println("Now is static block");
	}
	
	public void test(){
		System.out.println("test method == "+counter);
	}
}
