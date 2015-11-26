package com.shen.innerclass;

/**
 * 局部内部类使用测试 
 * 
	局部内部类定义在方法中，比方法的范围还小。是内部类中最少用到的一种类型。
　　像局部变量一样，不能被public, protected, private和static修饰。
　　只能访问方法中定义的final类型的局部变量。
　　局部内部类在方法中定义，所以只能在方法中使用，即只能在方法当中生成局部内部类的实例并且调用其方法。
 * 
 * @author shen
 *
 */
public class LocalInnerClassTest {
    public static void main(String[] args){
        // 创建外部类对象
        LocalInner inner = new LocalInner();
        // 调用外部类的方法
        inner.doSomething();
    }
}

class LocalInner{
    int a = 1;
    public void doSomething(){
        int b = 2;
        final int c = 3;
        // 定义一个局部内部类
        class Inner{
            public void test(){
                System.out.println("Hello World");
                System.out.println(a);
                // 不可以访问非final的局部变量
                // error: Cannot refer to a non-final variable b inside an inner class defined in a different method
                // System.out.println(b);
                // 可以访问final变量
                System.out.println(c);
            }
        }
        // 创建局部内部类的实例并调用方法
        new Inner().test();
    }
}
