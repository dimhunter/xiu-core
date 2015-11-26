package com.shen.annotation;

import org.junit.Test;

/**
 * 自定义注解使用，可以用在类上，方法上，变量上都行。
 * @author shen
 *
 */
public class AnnotationTest {
	
	/**
	 * 最简单的注解，什么也没有。
	 */
	@Test
	@MyAnnotation
	public void test(){
		System.out.println("com/shen/test");
	}
	
	/**
	 * 这里有个约定，如果注解中只有一个名称为value的属性，或者其他属性都有默认值，返回值类型无所谓，String，int等都可以， 
	 * 那么可以省略value=部分，例如：@MyAnnotation(0)。
	 * 只跟名称是value有关，类型无关。
	 */
	@Test
	@MyAnnotation1(0)
	public void test1(){
		System.out.println("test1");
	}
	
	/**
	 * 这里有个约定，如果注解中只有一个名称为value的属性，或者其他属性都有默认值，返回值类型无所谓，String，int等都可以， 
	 * 那么可以省略value=部分，例如：@MyAnnotation("shen")。
	 * 只跟名称是value有关，类型无关。
	 */
	@Test
	@MyAnnotation2("ddd")
	public void test2(){
		System.out.println("test2");
	}
	
	/**
	 * 属性名是不是 value()的注解。
	 */
	@Test
	@MyAnnotation3(value1 = "hello", value2 = "aaa")
	public void test3(){
		System.out.println("test3");
	}
	
	/**
	 * 变量有默认值。有默认值的就可以不赋值也不报错，因为有默认值，如果此处赋值，就会覆盖默认值。
	 */
	@Test
	@MyAnnotation4
	public void test4(){
		System.out.println("test4");
	}
	
	/**
	 * 数组格式的变量用value1={"a","b"}，大括号数组格式赋值，有默认值可以不赋值。
	 * 如果数组格式变量名称是value，一样可以省略，写成 {"a","b"}
	 */
	@Test
	@MyAnnotation5(value1={"a","b"})
	public void test5(){
		System.out.println("test5");
	}
	
	/**
	 * 多个变量的注解用枚举
	 */
	@Test
	@MyAnnotation6(value1 = "aa", value2 = MyEnum.Sunny)
	public void test6(){
		System.out.println("test6");
	}

}
