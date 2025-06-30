package com.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class MainAutowire {

	public static void main(String[] args) {
ApplicationContext context= new ClassPathXmlApplicationContext("com/autowire/configautowire.xml");
Employee obj= context.getBean(Employee.class,"emp");
System.out.println(obj);

	}

}
