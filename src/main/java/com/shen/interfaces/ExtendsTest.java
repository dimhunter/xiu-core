package com.shen.interfaces;

public class ExtendsTest {

	public static void main(String[] args) throws Exception {
		TParent p = new TChild();
		p.output(); //Child
	}
}	
	
	class TParent {
//Exception的范围比子类output()函数抛出的NullPointerException的范围要大
		public void output() throws Exception{
			System.out.println("Parent");
		}
	}
//方法的修饰宽度public必须比父类中的级别高或相同（现父类中的是public,此时父类中的还可以是private或protected）	
	class TChild extends TParent {
		public void output() throws NullPointerException{
			System.out.println("Child");
		}
	}

/*关于JAVA中的方法重写：
1、子类中的方法与父类中的方法有相同的返回类型，相同的方法名称，相同的参数列表
2、子类中的‘方法’(注意是方法的访问权限)的访问级别不能低于父类中该方法的访问级别（即 方法前的修饰 private protected public 级别从低到高）
3、子类中方法抛出的异常的范围不能大于父类中方法抛出的异常的范围（即 子类可以不抛出异常，或者抛出的异常是父类抛出
的异常的子类）

总结：子类比父类的  "异常小 ，访问权限大"
*/
