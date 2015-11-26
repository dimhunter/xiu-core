package com.shen.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 获取注解的各种方法。
 * 
 * 讨论了如何自定义注解。但是自定义了注解又有什么用呢？这个问题才是J2SE5.0提供注解的关键。自定义注解当然是要用的。
 * 那么如何用呢？解决这个问题就需要使用java最令人兴奋的功能之一：反射(reflect)。
 * 
 * jdk1.5 既然增加了注解，肯定就增加了相关读取的api 在java.lang.reflect包中新增了AnnotatedElement接口，JDK源码如下： 
 * public interface AnnotatedElement {	    
 * 		boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);	    
 * 		<T extends Annotation> T getAnnotation(Class<T> annotationClass);	    
 * 		Annotation[] getAnnotations();	    
 * 		Annotation[] getDeclaredAnnotations();
 * }
 * 
 * •isAnnotationPresent：判断是否标注了指定注解 
 * •getAnnotation：获取指定注解，没有则返回null 
 * •getAnnotations：获取所有注解，包括继承自基类的，没有则返回长度为0的数组 
 * •getDeclaredAnnotations：获取自身显式标明的所有注解，没有则返回长度为0的数组
 * 
 * @author shen
 *
 */
public class AnnotationUtils{
	
	/**
	 * 获取类或接口上的注解。
	 */
	public void test1(){
		//如果要得到某一个类或接口的注解信息，可以使用如下代码,参数是自定义注解的class，MyAnnotation1.class：
		//注意：通过class.getAnnotation只能得到类或接口上的注解，方法或属性，变量上的注解是获取不到的。
		Annotation at = AnnotationTest2.class.getAnnotation(MyAnnotation7.class);
		
		//如果要得到全部的注解信息可使用如下语句: 该方法也是通过class.getAnnotations，也是只能得到类级别上的所有注解。
//		Annotation[] annotations = AnnotationTest2.class.getAnnotations();
		
		MyAnnotation7 mat = (MyAnnotation7)at;
		System.out.println(mat.name());
	}
	
	/**
	 * 获取方法上的注解。
	 */
	public void test2(){
		Method[] methods = AnnotationTest2.class.getDeclaredMethods(); 
		for (Method method : methods) {
			//判断方法中是否有指定注解类型的注解 ,通过method获取的都是方法级别上的注解。
			boolean hasAnnotation = method.isAnnotationPresent(MyAnnotation7.class);
			if (hasAnnotation) {
				MyAnnotation7 at = method.getAnnotation(MyAnnotation7.class);
				System.out.println(at.name());
			}
		}
		
		Constructor[] constructors = AnnotationTest2.class.getConstructors(); 
		for (Constructor constructor : constructors) { 
			//判断构造方法中是否有指定注解类型的注解 ,通过constructors获取的都是构造方法级别上的注解。
			boolean hasAnnotation = constructor.isAnnotationPresent(MyAnnotation7.class);
			if (hasAnnotation) {
				MyAnnotation7 at = (MyAnnotation7) constructor.getAnnotation(MyAnnotation7.class);
				System.out.println(at.name());
			}
		}
		//或
//		Annotation[] annotations2 = AnnotationUtils.class.getDeclaredAnnotations();
		//getDeclaredAnnotations与getAnnotations类似，但它们不同的是getDeclaredAnnotations得到的是当前成员所有的注解，不包括继承的。而getAnnotations得到的是包括继承的所有注解。
	}
	
	public static void main(String[] args){
		AnnotationUtils a = new AnnotationUtils();
		a.test1();
		a.test2();
	}

}
