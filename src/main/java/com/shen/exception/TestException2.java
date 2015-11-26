package com.shen.exception;

public class TestException2{  
    public static void main(String[] args) throws Exception{   
          
    }
} 
class  Animal{ 
    public void sleep() throws InterruptedException{}
}  
class Dog extends Animal{ 
    public void slee() throws Exception{}       
    // Exception>InterruptedException---->error
}