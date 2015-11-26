package com.shen.awt;

import javax.swing.*;

public class TestComponent {
	public static void main(String[] args) {
		JFrame f=new JFrame("hehe");
		f.setSize(400,250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField jtf=new JTextField();
		f.add(jtf,"North");
		
		JTextArea jta=new JTextArea();
		JScrollPane jsp=new JScrollPane(jta);
		f.add(jsp);
		
		JPanel p=new JPanel();
		JButton b=new JButton("OK");
		p.add(b);
		
		JComboBox jcb=new JComboBox();
		jcb.addItem("Unix");
		jcb.addItem("CoreJava");
		jcb.addItem("OOAD");
		p.add(jcb);
		
		f.add(p,"South");
		
		f.setVisible(true);
	}
}
