package com.shen.socket;

import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(6666);
		System.out.println("服务端启动成功");
		while(true) {
			Socket s = ss.accept();
			System.out.println("a client connect!");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			//服务器端接收并打印客户端说的话
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
		
	}
}