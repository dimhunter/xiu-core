package com.shen.exception;

public class TryCatchFinallyDemo{
	public static void main(String[] args){
		setN(0);
		setN(1);
		setN(2);
	}	
	
	static void setN(int n){
		
		try{
			if(n==0){System.out.println("没有捕获异常");}
			else if(n==1){int i=0;int j=4/i;}
			else if(n==2){
				int iArray[]=new int[4]; 
				iArray[10]=3;
			}	
		}
		catch(ArithmeticException e){
			System.out.println("捕获的异常是：" + e);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("捕获的异常是：" + e.getMessage());
		}	
		catch(Exception e){
			System.out.println("本句没有执行");
		}
		finally{
			System.out.println("这是finally语句块");
		}
	}
	
}