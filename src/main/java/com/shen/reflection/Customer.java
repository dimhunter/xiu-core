package com.shen.reflection;

import java.lang.reflect.InvocationTargetException;

public class Customer {
    private Long id;
    private String name;
    private int age;

    public Customer(){}

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public static void main(String[] args) {
//		Customer.class.getClass().getConstructor(String.class,Integer.class).newInstance("aaa",5);
		try {
			Class<?> clazz = Class.forName("");
			try {
				try {
					clazz.getConstructor(new Class[]{String.class,Integer.class}).newInstance("S",5);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
