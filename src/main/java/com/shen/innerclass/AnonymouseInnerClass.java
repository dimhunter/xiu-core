package com.shen.innerclass;

import java.util.Date;

/**
 * 匿名内部类使用测试
 * 
	匿名内部类就是没有名字的局部内部类，不使用关键字class, extends, implements, 没有构造方法。
　　匿名内部类隐式地继承了一个父类或者实现了一个接口。
　　匿名内部类使用得比较多，通常是作为一个方法参数。
	生成的.class文件中，匿名类会生成OuterClass$1.class文件，数字根据是第几个匿名类而类推
 * 
 * @author shen
 *
 */
public class AnonymouseInnerClass {

    @SuppressWarnings("deprecation")
    public String getDate(Date date){
        return date.toLocaleString();
    }

    public static void main(String[] args){
        AnonymouseInnerClass test = new AnonymouseInnerClass();
        // 打印日期：
        String str = test.getDate(new Date());
        System.out.println(str);
        System.out.println("----------------");

        // 使用匿名内部类
        String str2 = test.getDate(new Date(){
        });// 使用了花括号，但是不填入内容，执行结果和上面的完全一致
            // 生成了一个继承了Date类的子类的对象
        System.out.println(str2);
        System.out.println("----------------");

        // 使用匿名内部类，并且重写父类中的方法
        String str3 = test.getDate(new Date(){
            // 重写父类中的方法
            @Override
            @Deprecated
            public String toLocaleString(){
                return "Hello: " + super.toLocaleString();
            }
        });
        System.out.println(str3);
    }
}
