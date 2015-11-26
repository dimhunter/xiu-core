package com.shen.collection;
/**
 * 用户实体类
 * 需求：一组用户对象User放在List中，这组用户对象需要排序，先按照用户的年龄来排序，如果年龄一样的话按照id排序。
 * @author shen
 *
 */
public class User {

	private int id; // 用户id
	private int age; // 用户年龄
	private String name; // 用户名

	public User() {
	}

	public User(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "ID：" + id + "，年龄：" + age + "，名字：" + name;
	}
}
