package com.shen.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * JAXB（Java API for XML Binding），提供了一个快速便捷的方式将Java对象与XML进行转换。
 * 在JAX-WS（Java的WebService规范之一）中，JDK1.6 自带的版本JAX-WS2.1，其底层支持就是JAXB。
 * JAXB 可以实现Java对象与XML的相互转换，
 * 在JAXB中，将一个Java对象转换为XML的过程称之为Marshal。
 * 
 * @author shen
 *
 */
public class Java2XML {
	
		public static void main(String[] args) throws JAXBException {  
        JAXBContext context = JAXBContext.newInstance(People.class);  
          
        Marshaller marshaller = context.createMarshaller();  
        //编码格式
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");  
        //是否格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        //是否省略xml头信息（<?xml version="1.0" encoding="utf-8" standalone="yes"?>）
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
          
        People people = new People();  
        marshaller.marshal(people, System.out);  
    }  
}
