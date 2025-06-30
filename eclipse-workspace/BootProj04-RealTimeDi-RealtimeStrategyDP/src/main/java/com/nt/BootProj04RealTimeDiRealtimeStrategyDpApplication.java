package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.CollegeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj04RealTimeDiRealtimeStrategyDpApplication {

	public static void main(String[] args) {
ApplicationContext ctx=SpringApplication.run(BootProj04RealTimeDiRealtimeStrategyDpApplication.class, args);
		CollegeOperationsController controller=ctx.getBean("clgController",CollegeOperationsController.class);
		try {
			List<Employee>list=controller.showEmployeeByDesgs("CLERKS","MANAGER","SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
				
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		((ConfigurableApplicationContext)ctx).close();
	
	}
}
