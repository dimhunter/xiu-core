package com.shen.string;

public class TestStringBuffer1 {

	public static void main(String[] args) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("这里");
		buffer.append("是");
		buffer.append("java");
		buffer.append("的世界");
		
		//public String toString()表示返回此序列中数据的字符串表示形式
		System.out.println("buffer == " + buffer.toString());
	}

}
