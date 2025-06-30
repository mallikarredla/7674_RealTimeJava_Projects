package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootProj02OnDependencyInjectionStrategyDppApplication {

	public static void main(String[] args) {
		
	try {	
		

		
  ApplicationContext ctx=SpringApplication.run(BootProj02OnDependencyInjectionStrategyDppApplication.class, args);
  //get target class obj from IOC Container
  
  Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
 
  
  vehicle.journey("Hyd", "Delhi");
  
  
  //close container
	}
	catch(Exception e){
		
		e.printStackTrace();
		
	}
	}

}
