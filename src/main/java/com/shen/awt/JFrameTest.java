package com.shen.awt;
import javax.swing.*;

public class JFrameTest{
	public static void main(String[] args){
		SimpleFrame f=new SimpleFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //重点记住这个方法，背下来，固定的。
		f.setVisible(true);
	}	
}

class SimpleFrame extends JFrame{
	public static final int DEFAULT_WIDTH=300;
	public static final int DEFAULT_HEIGHT=200;
	
	public SimpleFrame(){
		//super(str);          //调用父类JFrame的构造方法：JFrame(String title){},把参数str传给它设置成标题。
		setTitle("这是一个单纯的JFrame");    //从frame继承的setTitle方法
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);		
	}	
}