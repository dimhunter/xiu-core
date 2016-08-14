package com.shen.interfaces;

/**
 * 
 * 接口中可以含有 变量和方法。
 * 	1. 接口中的变量会被隐式地指定为public static final变量（并且只能是public static final变量，用private修饰会报编译错误），
 *  2. 方法会被隐式地指定为public abstract方法且只能是public abstract方法（用其他关键字，比如private、protected、static、 final等
 *  修饰会报编译错误），并且接口中所有的方法不能有具体的实现，也就是说，接口中的方法必须都是抽象方法。
 *  
 *  接口是一种极度抽象的类型，它比抽象类更加“抽象”
 * 
 * Created by shenluguo on 2015/9/2.
 */
public interface InterfaceA {
	
	//隐式定义为public static final
	int a = 10;
	
	//隐式定义为public abstract
    void methoda();

}
