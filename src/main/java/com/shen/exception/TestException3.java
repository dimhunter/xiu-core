package com.shen.exception;

import java.io.*;
public class TestException3{  
    public static void main(String[] args) {   
          TestException3 te=new TestException3(); 
          System.out.println("this is main begin");
          try{
          		te.m1();             
         	 	int num=te.m3(); 
         	 	te.m4();  
         }catch(ArithmeticException e){ 
         	   e.printStackTrace();
         }catch(FileNotFoundException fe){  
         	  fe.printStackTrace();
        }catch(Exception ie){   
        	  ie.printStackTrace(); 
        }finally{
        	 System.out.println("Call");
        } 
          System.out.println("this is main end");
    }  
    public void m4() throws IOException{  
    	throw new IOException();
    }
    public int m3() throws ArithmeticException{ 
    	 int num=3/0;
    	 return num;
    }   
    public void m1() throws ArithmeticException,FileNotFoundException{
         System.out.println("this is m1 begin");
         m2();    
         System.out.println("this is m1 end");
    } 
    public void m2() throws ArithmeticException,FileNotFoundException{
         System.out.println("this is m2 begin");
         int  num=3/0;  
        FileInputStream fis=new FileInputStream("day14.txt");
        System.out.println("this is m2 end");
    }
}