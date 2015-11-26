package com.shen.basic;
/**
 * equals方法是object中的方法，在object中的意思是比较两个对象的地址，是否指向同一个内存地址。
 * 所以object中的equals方法和 == 是相同的意思，都是比较的内存地址是否相同，是否是同一个对象。
 * 但是对于字符串来说，String是重写了equals方法，比较的是内容是否相等，所以字符串是例外，字符串
 * 的equals和==就是不同的，equals是比较内容，而==是比较的内存地址。
 * 对于重写了equals方法的对象来说，equals方法就要看api的说明了。
 * 
 * @author shen
 *
 */
public class EqualsTest {

	public static void main(String[] args) {
		
		//（1）对于字符串变量来说，使用“==”和“equals()”方法比较字符串时，其比较方法不同。
		//“==”比较两个变量本身的值，即两个对象在内存中的首地址。
		//“equals()”比较字符串中所包含的内容是否相同。
		String s1,s2,s3 = "abc", s4 ="abc" ;
		s1 = new String("abc");
		s2 = new String("abc");
		System.out.println(s1==s2); 		//是 false,两个变量的内存地址不一样，new出来的就是两个不同对象，也就是说它们指向的对象不 一样，故不相等。重要！和s3==s4比较。
		System.out.println(s1.equals(s2));	//是 true ,两个变量的所包含的内容是abc，故相等。
		System.out.println(s3==s4);			//由于s3和s4是两个字符串常量所生成的变量，其中所存放的内存地址是相等的，所以s3==s4是true（没有s3=s4，这样一个赋值语句）
		
		StringBuffer s5 = new StringBuffer("a");
        StringBuffer s6 = new StringBuffer("a");
        System.out.println(s5.equals(s6)); 	//是false,StringBuffer类中没有重写equals这个方法，因此这个方法就来自Object类，而Object类
        									//中的equals方法是用来比较“地址”的，所以等于false。
		
		
		//（2）对于非字符串变量来说，"=="和"equals"方法的作用是相同的都是用来比较其对象在堆内存的首地址，即用来比较两个引用变量是否指向同一个对象。
		AA obj1 = new AA();
	    AA obj2 = new AA();
	    System.out.println(obj1==obj2); //是false
	    System.out.println(obj1.equals(obj2)); //是false
	    
	    //（3） 如果是基本类型比较，那么只能用==来比较，不能用equals，而且比较的都是值，这与基本数据类型的存储地址有关。
	    int a = 3;
	    int b = 4;
	    int c = 3;
	    System.out.println(a == b);//结果是false
	    System.out.println(a == c);//结果是true
//	    System.out.println(a.equals(c));//错误，编译不能通过，equals方法不能运用与基本类型的比较。
	    
	    //（4） 对于基本类型的包装类型，比如Boolean、Character、Byte、Shot、Integer、Long、Float、Double等的引用变量，==是比较地址的，而equals是比较内容的。
	    Integer n1 = new Integer(30);
	    Integer n2 = new Integer(30);
	    Integer n3 = new Integer(31);
	    System.out.println(n1 == n2);//结果是false 两个不同的Integer对象，故其地址不同，
	    System.out.println(n1 == n3);//那么不管是new Integer(30)还是new Integer(31) 结果都显示false
	    System.out.println(n1.equals(n2));//结果是true 根据jdk文档中的说明，n1与n2指向的对象中的内容是相等的，都是30，故equals比较后结果是true
	    System.out.println(n1.equals(n3));//结果是false 因对象内容不一样，一个是30一个是31




	}

}

class AA{
      
}

