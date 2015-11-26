package com.shen.awt;
import java.awt.*;
import javax.swing.*;
public class TestGridLayout {
	public static void main(String[] args) {
		JFrame f=new JFrame("hehe");
		f.setSize(400,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LayoutManager lm=new GridLayout(3,2);
		f.setLayout(lm);
		
		JButton b1=new JButton("B1");
		JButton b2=new JButton("B2");
		JButton b3=new JButton("B3");
		JButton b4=new JButton("B4");
		JButton b5=new JButton("B5");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		
		f.setVisible(true);
		
	}
}
