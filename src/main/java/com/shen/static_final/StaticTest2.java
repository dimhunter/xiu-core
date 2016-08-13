package com.shen.static_final;

/**
 * 一个类中，一个 static变量只会有一个内存空间，虽然有多个类实例，但这些类实例中的这个 static变量会共享
 * 同一个内存空间。
 * 
 *   static基本规则： 
 *   一个类的静态方法只能访问静态属性 
 *   一个类的静态方法不能够直接调用非静态方法 
 *   如访问控制权限允许，static属性和方法可以使用对象名加‘.’方式调用；当然也可以使用实例加‘.’方式调用 
 *   静态方法中不存在当前对象，因而不能使用“this” ，当然也不能使用”super”； 
 *   静态方法不能被非静态方法覆盖； 
 *   构造方法不允许声明为 static的 
 * @author shen
 */
public class StaticTest2 {
	
	/**
	 * 输出结果：
	 * st1.um.userName = 李四
	 * st2.um.userName = 李四
	 * StaticTest3.i = 4
	 * 
	 * 为什么会是一样的值呢？就是因为多个实例中的静态变量 um 是共享同一内存空间，t1.um和 t2.um其实指向的都是同一个内存空间，
	 * 所以就得到上面的结果了。
	 *  
	 * 小结：
	 * static的变量是在类装载的时候就会被初始化。也就是说，只要类被装载，不管你是否使用了这个 static变量，它都会被初始化。 
	 * 类变量（class variables）用关键字 static修饰，在类加载的时候，分配类变量的内存，以后再生成类的实例对象时，将共享这块内
	 * 存（类变量） ，任何一个对象对类变量的修改，都会影响其它对象。
	 * 外部有两种访问方式：通过对象来访问或通过类名来访问。  
	 */
	
	static UserModel um = new UserModel();
	static int i = 3;
	
	public static void main(String[] args) {
		StaticTest2 st1 = new StaticTest2();
		st1.um.userName = "张三"; //推荐写成 StaticTest3.um.userName="张三";应直接用类名调。
		StaticTest2 st2 = new StaticTest2();
		st2.um.userName = "李四";
		
		StaticTest2.i = 4;
		
		System.out.println("st1.um.userName = " + st1.um.userName);
		System.out.println("st2.um.userName = " + st2.um.userName);
		System.out.println("StaticTest3.i = " + StaticTest2.i);
	}
}

class UserModel{
	public String userName = "";
} 