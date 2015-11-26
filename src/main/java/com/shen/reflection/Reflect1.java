package com.shen.reflection;

import java.lang.reflect.Method;

public class Reflect1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//根据类全名加载类。
			Class<?> classType = Class.forName("java.lang.String");
			//获得该类所有的方法。
			Method[] methods = classType.getDeclaredMethods();
			for(int i=0;i<methods.length;i++){
				System.out.println(methods[i]);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
