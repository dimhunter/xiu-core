package com.shen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 测试元注解target的作用，标记注解的使用位置的。
 * @author shen
 *
 */


@TargetTypeAnnotation
//@TargetMethodAnnotation  此处就不能用声明在方法生的注解，会报错：The annotation @TargetMethodAnnotation is disallowed for this location
public class TargetAnnotation {
	
	@TargetMethodAnnotation
	//@TargetTypeAnnotation 此处就不能用声明在类上的注解，报错：The annotation @TargetTypeAnnotation is disallowed for this location
	void testMehond(){
		
	}
	
}

/**
 * 类，接口（包括注解类型）或enum声明 
 */
@Target(ElementType.TYPE)
@interface TargetTypeAnnotation {
	
}

/**
 * 用在方法声明上。
 */
@Target(ElementType.METHOD)
@interface TargetMethodAnnotation {
	
}
