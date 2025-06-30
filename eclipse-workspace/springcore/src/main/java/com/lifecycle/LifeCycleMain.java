package com.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/lifecycle/configlife.xml");
context.registerShutdownHook();
		Student obj = context.getBean(Student.class, "st11");
		System.out.println(obj);
	}

}
