package com.component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class MainComponent {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("com/component/configcomponent.xml");
 Laptop obj= context.getBean(Laptop.class,"laptop");
 System.out.println(obj);
 
	}

}
