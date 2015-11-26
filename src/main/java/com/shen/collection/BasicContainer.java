package com.shen.collection;

import java.util.*;
/**
 * 所有可以排序的类都实现了java.lang.Comparable接口，此接口只有一个方法
 * public int compareTo(Object obj)
 * 该方法 	返回0 		表示		this == obj
 * 			返回正数  	表示		this >  obj
 * 			返回负数		表示		this <	obj
 * 实现了Comparable接口的类通过实现compareTo方法从而确定该类对象的排序方式。
 * 
 * 但是容器类并没有实现排序接口，比如list，但是list是有序的，是因为LinkedList底层是由双向循环链表实现，里面的数据在逻辑上的存储是连续的，连续自然也就有顺序了？？？
 * Comparable接口排序的作用是为了对容器中的元素进行排序，比如容器中存放了一组Person对象，对Person排序，那么Person就要实现Comparable接口，实现compareTo方法。
 * 由于list数据结构的原因，放进list里的对象还是按照add的先后顺序排序的，那么对象实现了Comparable接口后，需要调用Collections类的静态排序方法才能实现自定义的排序。
 * 例子看ComparableUser。
 * @author shen
 *
 */
public class BasicContainer {
    public static void main(String[] args) {
        Collection<Object> c = new HashSet<Object>();
        c.add("hello");
        c.add(new Name("f1","l1"));
        c.add(new Integer(100));
        c.remove("hello"); 
        c.remove(new Integer(100));
        System.out.println
                  (c.remove(new Name("f1","l1")));
        System.out.println(c);
    }


}

class Name implements Comparable<Object> {
    private String firstName,lastName;
    public Name(String firstName, String lastName) {
        this.firstName = firstName; 
        this.lastName = lastName;
    }
    public String getFirstName() {  return firstName;   }
    public String getLastName() {   return lastName;   }
    public String toString() {  return firstName + " " + lastName;  }
    
    /**
     * 重写equals方法
     */
    public boolean equals(Object obj) {
	    if (obj instanceof Name) {
	        Name name = (Name) obj;
	        return (firstName.equals(name.firstName))
	            && (lastName.equals(name.lastName));
	    }
	    return super.equals(obj);
	}
	
    /**
     * 重写hashCode方法
     */
    public int hashCode() {
    	return firstName.hashCode();
	}
		
	/**
	 * 实现Comparable接口的compareTo方法。
	 */
	public int compareTo(Object o) {
        Name n = (Name)o;
        int lastCmp = 
            lastName.compareTo(n.lastName);
        return 
             (lastCmp!=0 ? lastCmp :
              firstName.compareTo(n.firstName));
    }
		
}
