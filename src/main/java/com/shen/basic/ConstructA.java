package com.shen.basic;

/**
 * 注意执行顺序，初始化子类，必先初始化父类
 * 
 * 1、如果一个类中没有定义构造器，编译器在编译时会自动加上默认无参构造器
 * 2、每个类直接或间接是Object的子类，编译器会给Object自动加上默认无参构造器，它只有一个无参构造方法。
 * 3、编译器会在每个构造方法的第一行隐式添加父类的默认无参构造器，即添加super()。
 * 
 *  如果父类定义了一个带参数的构造器，因此编译器不会添加默认无参构造方法，但是因为在子类的构造器中没有显式调用父类的某个构造方法(比如例
 *  子中把40行super(n)注释掉),因此编译器会自动添加super()方法， 但是父类中不存在默认无参构造方法，因此会提示默认无参构造方法未定义错误。
 *  Implicit super constructor Employee() is undefined. Must explicitly invoke another constructor
 *  
 *  解决方法两种: 1. 给添加父类添加默认无参构造方法ConstructA()
 *  			 2. 子类构造方法中显示调用父类其他构造方法,如40行放开注释.
 * 
 * 
 * 
 * @author shen
 *
 */
public class ConstructA {
	
	public ConstructA(int n){
		System.out.println("AAAnnn");
	}
	
	public ConstructA(){
		System.out.println("AAA");
	}
	
	public static void main(String[] args){
		ConstructB b = new ConstructB(0);
	}
	
}

class ConstructB extends ConstructA{
	public ConstructB(int n){
//		super(n);不显示调用父类构造器会报错。
		System.out.println("BBBnnn");
	}
}