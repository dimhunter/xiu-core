package com.shen.exception;

public class Test1 {
	
	void test() throws Exception{
		System.out.println("=========");
		throw new Exception("aaaa");
	}

	/**
	 * @param args
	 * @throws Exception 
	 * 
	 * 如果把try...catch注释放开的话，try到异常后，执行catch里的语句，但是try...catch外，后边的语句还会继续执行下去。把注释去掉试试。
	 */
	public static void main(String[] args) throws Exception {
		Test1 t = new Test1();
//		try{
			t.test();
			System.out.println("++++++++++++");
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("-----------");
//		}
		System.out.println("!!!!!!!!!!!!");
	}

}
