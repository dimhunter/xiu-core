package com.shen.exception;

public class ExceptionTest {    
	   
    public static void main(String[] args) {    
        try {    
            //输出的结果:finally    
            String s = null;   
            System.out.println(s);
            //对于异常，如果有方法返回return，并且有finally，那么在执行return之前会先执行finally语句块
            return;    
        }catch(Exception e){    
            System.out.println("com/shen/exception");
        }finally{    
            System.out.println("finally");    
        }    
    }    
} 
/*
Exception异常知识点：
1、在程序return前执行finally里的程序
2、如果程序用了System.exit(0);则不会执行finally里的程序
3、Java中异常分为两类：

1) checked Exception
	处理方式一、继续抛出，消极做法，直到抛出到JVM
	处理方式二、用try..catch
	
2) unchecked Exception (runtime exception)
	对于运行时异常可以不做任何处理
*/