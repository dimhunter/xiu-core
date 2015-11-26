package com.shen.innerclass;

/**
 * 静态内部类使用测试
 * 
 * 是最简单的内部类形式。
 * 类定义时加上static关键字。
 * 不能和外部类有相同的名字（类名不能和外部类相同）。
 * 被编译成一个完全独立的.class文件，名称为OuterClass$InnerClass.class的形式。
 * 只可以访问外部类的静态成员和静态方法，包括了私有的静态成员和方法。
 * 生成静态内部类对象的方式为：OuterClass.InnerClass inner = new OuterClass.InnerClass();
 * 
 * @author shen
 *
 */
public class StaticInnerClassTest {
	public static void main(String[] args){
        StaticInner.Inner inner = new StaticInner.Inner();
        inner.test();
    }
}


class StaticInner {
    private static int a = 4;
    private int b = 6;
    // 静态内部类
    public static class Inner {
//    	会覆盖外部类的。
//    	private static int a = 44; 
//    	private int b = 66;
        public void test(){
            // 静态内部类只可以访问外部类的静态成员，private的也可以。
            // 并且它只能访问静态的
            System.out.println(a);
//            b就不可以访问，不是静态的。
//            System.out.println(b);
        }
    }
}
