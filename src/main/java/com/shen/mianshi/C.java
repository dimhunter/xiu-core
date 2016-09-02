package com.shen.mianshi;

interface A {
	int x = 0;
}

class B{
	int x = 1;
}

public class C extends B implements A{
	public void px(){
		//编译时会提示你the field is ambiguous.接口A和父类B中都定义了x，所以产生冲突，把A中或者B中的x改成不一样的变量名就行了。
//		这样写，相当于C类中定义了两个x，直接用会产生歧义。必须加上关键词来区分。
//		接口的变量默认都是public static final，可以用A.x来访问。父类的变量可以用super.x来访问。搜索
//		所以pX方法中的x应该改成A.x或super.x来区分是接口的x还是父类的x
//		System.out.println(x);
		
		
		System.out.println(A.x);
		System.out.println(super.x);
	}
	
	public static void main(String[] args) {
		new C().px();
	}
}