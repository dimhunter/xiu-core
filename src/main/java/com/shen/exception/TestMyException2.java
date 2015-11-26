package com.shen.exception;

//用户自定义异常的例子
public class TestMyException2{
	public static void main(String[] args){
		TestMyException2 t = new TestMyException2();
		t.manager();
	}
	

	public void regist(int num)throws MyException{
		if(num < 0){
			throw new MyException("人数为负值，不合理!!!",3);	
		}
		System.out.println("登记人数"+num);
	}
	
	public void manager(){
		try{
			regist(-100);
		}catch(MyException e){
			System.out.println("登记出错，类别："+e.getId());	
		}
		System.out.println("本次登记操作结束");
	}	
}

class MyException extends Exception{   //用户自定义的异常
	private int idnumber;
	public MyException(String message , int id){
		super(message);
		this.idnumber = id;
	}
	public int getId(){
		return idnumber;	
	}
}

