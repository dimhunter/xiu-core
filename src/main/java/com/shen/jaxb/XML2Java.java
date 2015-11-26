package com.shen.jaxb;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * JAXB（Java API for XML Binding），提供了一个快速便捷的方式将Java对象与XML进行转换。
 * 在JAX-WS（Java的WebService规范之一）中，JDK1.6 自带的版本JAX-WS2.1，其底层支持就是JAXB。
 * JAXB 可以实现Java对象与XML的相互转换，
 * 在JAXB中，将XML转换为Java对象的过程称之为UnMarshal。
 * 
 * @author shen
 *
 */
public class XML2Java {
	public static void main(String[] args) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(People.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		InputStream in = XML2Java.class.getResourceAsStream("people.xml");
		People people = (People)unmarshaller.unmarshal(in);
		System.out.println(people.id);
		System.out.println(people.name);
		System.out.println(people.age);
	}
}
