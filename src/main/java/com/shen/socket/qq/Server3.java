package com.shen.socket.qq;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server3 extends JFrame{
	static JTextArea area;
	JTextField field;
	JButton button;
	static PrintStream writer;
	public Server3(){
		this.setTitle("服务器");
		this.setSize(400,500);
		area = new JTextArea(25,30);
		area.setEditable(false);
		field = new JTextField(20);
		button = new JButton("提交");
		JPanel panel = new JPanel();
		JScrollPane sp = new JScrollPane(area);
		this.add(sp,BorderLayout.CENTER);
		panel.add(field);
		panel.add(button);
		this.add(panel,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String text = field.getText();
				writer.println(text);
				area.append("我："+text+"\n");
				field.setText("");
			}
			
		});
	}
	public static void main(String[] args) throws Exception {
		Server3 s = new Server3();
		ServerSocket server = new ServerSocket(8899);
		System.out.println("开始监听...");
		Socket socket = server.accept();
		InetAddress address = socket.getInetAddress();
		String name = address.getLocalHost().getHostName();
		System.out.println(name+"已连接");
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintStream(socket.getOutputStream(), true);
		while (true) {
			String line = null;
			line = reader.readLine();
			if (line != null) {	
					area.append("客户端："+line+"\n");
			}

		}
	}

}