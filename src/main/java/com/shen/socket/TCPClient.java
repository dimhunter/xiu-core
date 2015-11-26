package com.shen.socket;

import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 6666); //这就表示连上了
		//想要跟服务器端说话就要用到流
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		//脸上以后让它睡30秒，在这期间另一个客户端是连不上的，这个问题需要解决。
		Thread.sleep(30000);
		//向服务器端说一句话，但是服务器端接收才能打印出来。
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
}