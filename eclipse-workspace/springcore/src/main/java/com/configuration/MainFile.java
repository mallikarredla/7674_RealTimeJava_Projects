package com.configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainFile {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(ConfigurationTest.class);
	Computer obj=	context.getBean(Computer.class,"computer");
	System.out.println(obj);
	
	Employee44  employee=	context.getBean(Employee44.class,"getEmployee");
	System.out.println(employee);
	}

}
