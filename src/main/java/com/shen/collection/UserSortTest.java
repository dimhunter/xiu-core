package com.shen.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户实体类排序的测试类
 * 
 * @author shen
 * 
 */
public class UserSortTest {

	public static void main(String[] args) {
		// 创建测试数据
		List<User> users = new ArrayList<User>();
		User u1 = new User(1000, 20, "张三");
		User u2 = new User(1001, 18, "lisi");
		User u3 = new User(1002, 20, "wangwu");
		User u4 = new User(1003, 23, "赵六");
		User u5 = new User(999, 20, "mouqi");
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);

		// 创建比较器对象
		UserComparator comp = new UserComparator();
		// 调用排序方法
		Collections.sort(users, comp);

		// 遍历集合打印测试数据
		for (User user : users) {
			System.out.println(user);
		}
	}
}
