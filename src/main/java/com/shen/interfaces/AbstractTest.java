package com.shen.interfaces;

/**
 * 抽象方法必须用abstract关键字进行修饰。如果一个类含有抽象方法，则称这个类为抽象类，抽象类必须在类前用abstract关键字修饰。
 * 因为抽象类中含有无具体实现的方法，所以不能用抽象类创建对象。
 * 
 * @author shen
 */
public class AbstractTest extends AbClassParent{

	@Override
	void abParentMethod() {
		//必须实现父抽象类的抽象方法。
		System.out.println(super.name);
	}
}

/**
 * abstract 可以修饰类和方法
 *  抽象类不能被实例化。
 *  如果有抽象方法未被实现，则子类将继承父类的抽象方法，所以这个子类也一定是抽象类。
 *  
 * @author shen
 */
abstract class AbClassParent{
	//抽象类也可以有属性
	String name = "aaa";
	
	void parentMethod(){
		System.out.println("抽象类也可以有非抽象方法");
	}
	
	//抽象方法不需要有方法体大括号，留给子类实现。而且子类必须实现
	//抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法）
	//如果是private会编译报错
	abstract void abParentMethod();
	
}