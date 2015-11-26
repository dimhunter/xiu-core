package com.shen.exception;

import java.io.*;
public class TestException{  
    public static void main(String[] args) throws Exception{   
          TestException te=new TestException(); 
          System.out.println("this is main begin");
          //te.m1();             
          int num=te.m3();       
          System.out.println(num);
          System.out.println("this is main end");
    }
    public int m3(){ 
    	 int num=3/0;
    	 return num;
    }   
    public void m1() throws Exception{
         System.out.println("this is m1 begin");
         m2();    
         System.out.println("this is m1 end");
    } 
    public void m2() throws ArithmeticException,FileNotFoundException{
         System.out.println("this is m2 begin");
         //int  num=3/0;  
        // FileInputStream fis=new FileInputStream("day14.txt");
          throw new FileNotFoundException();    
         //System.out.println("this is m2 end");
    }
}