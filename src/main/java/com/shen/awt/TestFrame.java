package com.shen.awt;

import javax.swing.*;
public class TestFrame {
	public static void main(String[] args){
		JFrame f=new JFrame("Hello swing");
		f.setSize(400,300);
		
		JPanel p=new JPanel();
		f.add(p);
		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
