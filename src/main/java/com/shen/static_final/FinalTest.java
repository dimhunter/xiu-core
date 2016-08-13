package com.shen.static_final;

import java.util.HashMap;
import java.util.Map;

/**
 * final应用说明
	1、final用在类上表示该类不能被继承
	2、final用在方法上表示该方法不能被重写（override），【但可以被子类继承】。
	3、final用在变量上表示该变量一旦被赋值后它的值将不能被改变，即为常量，只能赋值一次，注意这里不可以改变值的意思是不可以改变引用名和对象之间的指向关系，
	比如map，赋值final map a = map b后，就不可以map a = map c了，但是可以往map里put值，因为put值不属于改变引用和对象间的引用关系。
	 
	对于final类型的【成员变量】的初始化方式:
	1、final成员变量在声明时一定要初始化（赋值），如果没有初始化，也可以在该类构造函数中初始化，否则编译不通过。
	2、对于【static】的final类型的成员变量，只能通过在变量声明时直接赋值，不能通过在构造方法中完成赋值，
	因为static的变量是优先于构造方法执行的，而static的final类型的成员变量在声明时有点特殊：不会被
	设置成默认的值（如int a;本应该在声明时会自动设置成默认的值"0"）
	3、局部final变量可以在声明的时候不初始化(赋值)，可以随时赋值，但是在第一次赋值后，也就不可以改变了。（该类62行例子）
	
	4、对于final类型的引用变量来说，所谓的不能改变指的是该引用不能被改变，而不是该引用的内容不能被改变（？？？可以暂不理解。没用）
	
	
	在构造方法中完成赋值的注意点：
	如果一个类有多个构造方法，那么必须在每个（注意是每个）构造方法中对final类型的成员变量赋值，否则将通不过编译
	
 * @author shen
 *
 */
public class FinalTest {    
    private final int A;    
    //private static final int a ;和上一句比较
    
    private String b = "123";
    //final成员变量在声明时一定要初始化（赋值），如果没有初始化，也可以在该类构造函数中初始化，否则编译不通过。
    private final String bb = "123";
    
    private Map<String,String> ab = new HashMap<String,String>();
    private final Map<String,String> abc = new HashMap<String,String>();
    
    private String name;    
        
    public FinalTest(){    
        //如果final成员变量未在声明时直接赋值，那么每个构造方法里必须要对它进行赋值，否则将通不过编译    
        A = 3;   
        ab.put("1", "11");
    	abc.put("1", "11");
    }    
        
    public FinalTest(String name){    
        //如果final成员变量未在声明时直接赋值，那么每个（注意是每个）构造方法里必须要对它进行赋值，否则将通不过编译    
        A = 5;    
        this.name = name;    
    }    
    
    
    public void testJuBu(){
    	final String jba ;
    	//局部final变量可以在声明的时候不初始化(赋值)，可以随时赋值，但是在第一次赋值后，也就不可以改变了。
    	jba = "ddd";
    	//编译报错，因为在上面已经刚赋过值了。
//    	jba = "fds";
    }
    
    public final void testFinalMethod(){
    	System.out.println("parent testFinalMethod run ! ");
    }
        
    public static void main(String[] args){    
        FinalTest ft = new FinalTest();    
//        ft.A = 6;//编译不通过，a是final的，值不可以被改变了。
        ft.b = "456";
//        ft.bb = "456"; ////编译不通过，bb是final的，值不可以被改变了。和上一句改变b的值比较，b不是final，所以可以被改变。
        
        Map cc = new HashMap<String,String>();
        ft.ab.put("2", "22");
        ft.abc.put("2", "22");
        ft.ab = cc;//不是final的，可以重新赋值。即改变引用指向的对象。put值不算赋值。
//        ft.abc = cc;  //编译不通过，final的map不可以被重新赋值，但是可以往里put值，put值不属于改变引用指向关系。
        
        FinalTest ft2 = new FinalTest("hello");    
    }    
}
