package com.shen.annotation;

import java.util.HashMap;
import java.util.Map;


@MyAnnotation7(name = "type")//类位置 注解
public class AnnotationTest2 {
	
	@MyAnnotation7(name="param",id=1) //类成员位置 注解	
	private Integer age;
	
	@MyAnnotation7(name="construct",id=2)// 构造方法位置 注解
	public AnnotationTest2(){
	}
	
	@MyAnnotation7(name="public method",id=3) //类方法位置 注解	
	public void a(){		
		Map<String,String> m = new HashMap<String,String>(0);	
	}
	
	public void b(Integer a){}
	
	
	
}
