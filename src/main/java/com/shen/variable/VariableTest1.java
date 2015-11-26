package com.shen.variable;
/**
 * 变量：实例变量和局部变量
 * @author shen
 * 
 * 实例变量：在方法外定义的变量主要是实例变量，它们是在使用new Xxx ()创建一个对象时被分配内存空间的。
 * 		每当创建一个对象时，系统就为该类的所有实例变量分配存储空间；创建多个对象就有多份实例变量。通
 * 		过对象的引用就可以访问实例变量。
 * 
 * 局部变量： 在方法内定义的变量或方法的参数被称为局部(local)变量，有时也被用为自动（automatic） 、
 * 		临时（temporary）或栈（stack）变量。 
 *   	方法参数变量定义在一个方法调用中传送的自变量，每次当方法被调用时，一个新的变量就被创建并且
 *   	一直存在到程序的运行跳离了该方法。 如method2的参数f。
 *		当执行进入一个方法遇到局部变量的声明语句时，局部变量被创建，当执行离开该方法时，局部变量被取消，
 *		也就是该方法结束时局部变量的生命周期也就结束了。 因而，局部变量有时也被引用为“临时或自动”变量。
 *		在成员方法内定义的变量对该成员变量是“局部的” ，因而，你可以在几个成员方法中使用相同的变量名而
 *		代表不同的变量。  
 */
public class VariableTest1 {
	
	//当一个对象被创建时，"实例变量" 在分配内存空间时按程序员指定的初始化值赋值，否则会按规则默认值进行初始化，看method3，但局部变量不会。
	private int i;  	//实例变量
	
	/**
	 * 方法一
	 */
	public void method1(){
		int j = 2; 		//局部变量
		System.out.println("method1 中的 i="+i +", j="+j);
	}
	
	/**
	 * 方法二
	 */
	public void method2(float f){
		int i = 7; 		//如果局部变量和实例变量同名，方法内用的就是局部变量！！！！！
		int j = 3; 		//局部变量，跟method1中的j是不同的，这个j的范围是限制在method2中，在这个地方，可同时访问 i，j，f。
		System.out.println("method2 中的 i="+i + ", j="+j + ", f="+f);
	}
	
	/**
	 * 方法三
	 * 在 Java 程序中，任何变量都必须经初始化后才能被使用。
	 * 当一个对象被创建时，"实例变量" 在分配内存空间时按程序员指定的初始化值赋值，否则系统将按下列默认值进行初始化： 
	 *  byte		0
	 *  short		0
	 *  int			0
	 *  long		0
	 *  float		0
	 *  double		0
	 *  char		'\u0000'
	 *  boolean		false
	 *  所有引用类型  null
	 *  
	 *  在方法外定义的变量被自动初始化。"局部变量" 必须在使用之前做“手工”(由程序员进行)初始化。如果编译器能够确认
	 *  一个变量在初始化之前可能被使用的情形，编译器将报错。  如method3
	 */
	@SuppressWarnings("unused")
	public void method3(){
		int x = (int)(Math.random());
		int y ; //没有经过初始化的局部变量。
//		System.out.println(y+x); //此处会报错，y必须初始化。如果y是实例变量就不用手动初始化了，比如这个类的实例变量 int i，默认被初始化为0
	}
	
	public static void main(String[] args){
		VariableTest1 vt = new VariableTest1();
		vt.method1();
		System.out.println("-----------------------");
		vt.method2(5);
	}

}
