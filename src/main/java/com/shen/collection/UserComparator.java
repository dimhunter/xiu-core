package com.shen.collection;

import java.util.Comparator;

/**
 * 用户实体类的比较器。
 * 
 * @author shen
 * 
 */
public class UserComparator implements Comparator<User> {

	/**
	 * 比较器方法 先按年龄排序从小到大，如果年龄一样的话按id排序
	 */
	public int compare(User o1, User o2) {
		if (o1.getAge() > o2.getAge())
			return 1;
		else if (o1.getAge() == o2.getAge()) {
			if (o1.getId() > o2.getId())
				return 1;
			else if (o1.getId() == o2.getAge())
				return 0;
			else
				return -1;
		} else
			return -1;
	}

}
