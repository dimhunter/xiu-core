package com.shen.variable;

/**
 * 变量作用范围
 * @author shen
 * 
 * Java变量的范围有四个级别: 类级、对象实例级、方法级、块级 
 * （1） ：类级变量又称全局级变量，在 "对象产生之前" 就已经存在，就是后面会学到的 static变量。 
 * （2） ：对象实例级，就是前面学到的属性变量,也就是实例变量，new一个对象的时候会产生。 
 * （3） ：方法级：就是在方法内部定义的变量，就是前面学到的局部变量。 
 * （4） ：块级：就是定义在一个块内部的变量，变量的生存周期就是这个块，出了这个块就消失了。 
 */
public class VariableScope {
	
	private static String name = "申哥"; //类级
	private int i ; 					 //对象实例级，Test类的实例变量
	//属性块，在类初始化属性的时候运行。
	{
		int j = 2;						 //块级
	}
	
	
	/**
	 * 访问说明 
	 * （1）：方法内部除了能访问方法级的变量，还可以访问类级和实例级的变量 。
	 * （2）：块内部能够访问类级、实例级变量，如果块被包含在方法内部，它还可以访问方法级的变量。 
	 * （3）: 变量当然是要在被访问前被定义和初始化，不能访问后面才定义的变量。 
	 */
	public void test(){
		int j = 3;						 //方法级
		if(j == 3){
			int k = 5;					 //块级
		}
		//这里不能访问块级的变量j和k，块级变量只能在块内部访问。
		System.out.println("name="+name+", i="+i+", j="+j);
	}
	
	
	
	public static void main(String[] args) {
		VariableScope vs = new VariableScope();
		vs.test();
	}

}
