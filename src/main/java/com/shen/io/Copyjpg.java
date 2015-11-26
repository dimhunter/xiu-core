package com.shen.io;
import java.io.*;
public class Copyjpg {
	public static void main(String[] args){
		try{
			FileInputStream in=new FileInputStream("1.jpg");
			FileOutputStream out =new FileOutputStream("copy-1.jpg");
			
			byte[] bs=new byte[512];        //缓冲数组，并不是要一次全读进去。
			int len;                        //len表示一共读了几个字符
			while((len=in.read(bs))!=-1){   //read方法返回-1表示读到了最后。
				out.write(bs,0,len);
			}
			in.close();
			out.close();
			System.out.println("文件复制成功");
		}catch(Exception e){
			System.out.println("文件复制失败");
		}
	}
}
