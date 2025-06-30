package com.collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {

	public static void main(String[] args) {
ApplicationContext context= new ClassPathXmlApplicationContext("com/collection/configcollection.xml");


Person personObj=context.getBean(Person.class, "p1");
System.out.println(personObj.getPersonId()+"\n"+personObj.getHobbies()+"\n"+personObj.getPhones()+"\n"+personObj.getCountry());
	}
}
