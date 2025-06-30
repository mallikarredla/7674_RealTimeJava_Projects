package com.springcore;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/config.xml");

		Employee obj = context.getBean(Employee.class, "emp");
		System.out.println(obj);
	}

}
