package com.ref;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class MainRef {

	public static void main(String[] args) {
ApplicationContext context= new ClassPathXmlApplicationContext("com/ref/configref.xml");

	Student studentBean = context.getBean(Student.class,"st");
	System.out.println(studentBean);
		
		
		
	}

}
