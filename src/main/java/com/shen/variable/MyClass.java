package com.shen.variable;
public class MyClass {
    public static String classVariable = "类变量";   // 类变量
    public String instanceVariable = "实例变量";   // 实例变量
 
    public static void classMethod() {                  // 类方法1
        System.out.println("类方法1");
        System.out.println(classVariable);     //类方法直接调用类变量。
        classMethod2();						   //类方法直接调用类方法。
        
    }
    
    public static void classMethod2() {                  // 类方法2
        System.out.println("类方法2");
    }
 
    public void instanceMethod() {                   // 实例方法1。
        System.out.println("实例方法1");
        
        System.out.println(instanceVariable);   //实例方法可以直接访问实例变量。
        instanceMethod2();                      //实例方法可以直接调用实例方法。
        
        System.out.println(classVariable);   //实例方法可直接访问类变量。
        classMethod();                       //实例方法可直接调用类方法。
    }
    
    public void instanceMethod2() {                   // 实例方法2。
        System.out.println("实例方法2");
    }
    
 
    public static void main(String[] args) {
        classMethod();        // 可以直接写类方法的名字来用。
 
        MyClass.classMethod();  //也可以用类名来直接调用类方法。
 
        System.out.println(MyClass.classVariable);     //用类名直接调用类变量。
        System.out.println(classVariable);             //不用类名也可以直接用类变量。
 
        MyClass instance = new MyClass();
        instance.classMethod();							//已不推荐，改用类名直接访问。
        System.out.println(instance.classVariable);		//已不推荐，改用类名直接访问。
 
        instance.instanceMethod();  					//对外实例方法只能通过new一个对象来访问，在类内部可以直接通过名字调用。
        System.out.println(instance.instanceVariable);  //对外实例变量只能通过new一个对象来访问，在类内部可以直接用。
    }
}
