package com.shen.innerclass;

/**
 * 成员内部类使用测试 

	成员内部类也是定义在另一个类中，但是定义时不用static修饰。
	成员内部类和静态内部类可以类比为非静态的成员变量和静态的成员变量。
	成员内部类就像一个实例变量。
	它可以访问它的外部类的所有成员变量和方法，不管是静态的还是非静态的都可以。
	在外部类里面创建成员内部类的实例：
	this.new Innerclass();
	在外部类之外创建内部类的实例：
	(new Outerclass()).new Innerclass();
	在内部类里访问外部类的成员：
	Outerclass.this.member
 * 
 * @author shen
 *
 */
public class MemberInnerClassTest {
	public static void main(String[] args){
        // 创建成员内部类的对象
        // 需要先创建外部类的实例
        MemberInner.Inner inner = new MemberInner().new Inner();
        inner.doSomething();
    }
}

class MemberInner{
    private static int d = 1;
    private int a = 2;

    // 定义一个成员内部类
    public class Inner{
        private int a = 8;
        public void doSomething(){
            // 直接访问外部类对象
            System.out.println(d);
            System.out.println(a);// 直接访问a，则访问的是内部类里的a
            // 如何访问到外部类里的a呢？
            System.out.println(MemberInner.this.a);
        }
    }
}

