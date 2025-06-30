package com.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;


@Configuration
@ComponentScan("com.configuaration")
public class ConfigurationTest {
	
	@Bean
	public Employee44 getEmployee() {
		Employee44 obj= new Employee44();
	obj.setEmployeeName("aman");
	obj.setSalary(30000);
	return obj;
	
	}
	

}
