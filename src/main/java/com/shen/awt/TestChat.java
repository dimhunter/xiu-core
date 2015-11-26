package com.shen.awt;

import java.awt.event.*;
import javax.swing.*;

public class TestChat {
	public static void main(String[] args){
		JFrame f=new JFrame("chat room");
		f.setSize(300, 200);
		
		final JTextArea jta=new JTextArea();		
		jta.setEditable(false);
		f.add(new JScrollPane(jta));

		final JTextField jtf=new JTextField();
		f.add(jtf,"South");		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ActionListener l=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text= jtf.getText();
				jtf.setText("");         //ʹ�ı���Ϊ���ȡ�
				jta.append(text+"\n");
			}		
		};
		jtf.addActionListener(l);
	}
}
