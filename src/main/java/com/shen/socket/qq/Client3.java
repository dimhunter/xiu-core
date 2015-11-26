package com.shen.socket.qq;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client3 extends JFrame{

	static JTextArea area;
	JTextField field;
	JButton button;
	static PrintWriter writer;
	public Client3(){
		this.setTitle("客户端");
		this.setSize(400,500);
		area = new JTextArea(25,30);
		area.setEditable(false);
		field = new JTextField(20);
		button = new JButton("提交");
		JScrollPane sp = new JScrollPane(area);
		JPanel panel = new JPanel();
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
	public static void main(String[] args) throws Exception{
		Client3 c = new Client3();
		Socket socket = new Socket("127.0.0.1",8899);
		OutputStream out = socket.getOutputStream();
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(out,true);
		System.out.println("已经成功和服务器连接...");
		while(true){
			String line = reader1.readLine();
			area.append("服务器："+line+"\n");
		}
	}

}
