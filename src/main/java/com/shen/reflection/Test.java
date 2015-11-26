package com.shen.reflection;

import org.fusesource.jansi.Ansi;

public class Test {
	
	public static void main(String[] args){
		Ansi ansi = new Ansi();
		Class<?> clazz = null;
		try {
			clazz = Class.forName("org.fusesource.jansi.Ansi");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clazz.getMethod("ansi");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String.format("", "");
		System.out.println("----");
//		System.out.println(String.format("aadd", "dd"));
		String str = "monad %s (v%s)";
		String text = "web@7777";
		String version = "2.0";
		String a = "@|green "+String.format("|@ @|red "+text+"|@","@|yellow "+version+"|@");
		System.out.println(a);
	}
	
}
