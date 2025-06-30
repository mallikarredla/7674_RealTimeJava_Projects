package com.constructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class AppConst {

	public static void main(String[] args) {

ApplicationContext context=new ClassPathXmlApplicationContext("com/constructor/configconst.xml");		
		
		Employee bean=context.getBean(Employee.class,"emp");
		System.out.println(bean);
		 
	}

}
