package com.shen.io;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) {
		
		String separator = File.separator;
		String fileName = "test.txt";
		String directory = "mydir1" + separator + "mydir2";
		System.out.println(separator);
		//这两种方式不推荐
		//String directory = "mydir1/mydir2";
		//String directory = "mydir1\\mydir2"; -- 一个\的斜杠在java里表示转义字符，用两个相当于一个/
		
		
		File f = new File(directory,fileName);
		if(f.exists()){
			System.out.println("文件名:"+f.getAbsolutePath());
			System.out.println("文件大小:"+f.length());
		}else{
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
