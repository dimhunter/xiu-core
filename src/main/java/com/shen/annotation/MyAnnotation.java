package com.shen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解。
 * 
 * 详解：@interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。
 * 方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是：基本类型（8种）、Class、String、enum）。
 * 可以通过default来声明参数的默认值。 
 * 
 * 为方便测试：注解目标为类 方法，属性及构造方法
 * 在运行期级别保存该注解信息
 * 
 * 最简单的注解，标记性，什么也不写。
 * 使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。
 * 在定义注解时，不能继承其他的注解或接口。
 * 
 */

public @interface MyAnnotation {

}

/**
 * 这里有个约定，如果注解中只有一个名称为value的属性，或者其他属性都有默认值，返回值类型无所谓，String，int等都可以， 
 * 那么可以省略value=部分，例如：@MyAnnotation(0)。
 * 只跟名称是value有关，类型无关。
 * 参见AnnotationTest，test1();
 */
@interface MyAnnotation1 {
	int value();
}

/**
 * 这里有个约定，如果注解中只有一个名称为value的属性，或者其他属性都有默认值，返回值类型无所谓，String，int等都可以， 
 * 那么可以省略value=部分，例如：@MyAnnotation("shen")。
 * 只跟名称是value有关，类型无关。
 * 参见AnnotationTest，test2();
 */
@interface MyAnnotation2 {
	String value();
	String value2() default "aaa";
	String value3() default "ccc";
}

/**
 * 有变量的注解。属性名是不是 value()的。
 * 除了value以外的变量名都需要使用name=value的方式赋值。
 */
@interface MyAnnotation3 {
	String value1();
	String value2();
}

/**
 * 变量有默认值的注解
 * 
 * 有默认值的就可以不赋值也不报错，因为有默认值，如果赋值，就会覆盖默认值。
 */
@interface MyAnnotation4 {
	String value() default "aaa";
}

/**
 * 数组格式变量。
 */
@interface MyAnnotation5 {
	String[] value1() default "abc";
}

/**
 * 多变量使用枚举
 * @author shen
 *
 */
@interface MyAnnotation6 {
	String value1();
    MyEnum value2();
}
enum MyEnum{
    Sunny,Rainy
}

/**
 * 只有runtime的注解才能通过反射获取到。！！！！！！！
 * @author shen
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation7 {
	String name();
	int id() default 0;
}