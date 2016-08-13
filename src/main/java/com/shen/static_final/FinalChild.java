package com.shen.static_final;

/**
 * 如果FinalTest类设置成final修饰，再extends就会编译错误。
 * @author shen
 *
 */
public class FinalChild extends FinalTest{
	
	//override该方法会编译错误，因为父类的final方法不可被重写，但可被子类继承，子类直接可调用该方法。
//	public void testFinalMethod(){
//		System.out.println("child testFinalMethod run ! ");
//	}
	
	public static void main(String[] args) {
		FinalChild fc = new FinalChild();
		//可直接调用父类的final方法，但不可override重写。
		fc.testFinalMethod();
	}
	
}
