package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	
	
	//HAS-A Property for field Injection
	
	@Autowired
	@Qualifier("pEngine")
	private IEngine engine;
	
	public void journey(String startPlace, String endPlace) {
		
		
		 
		System.out.println("Vehicle.journey()");
		//start the engine
		engine.start();
		System.out.println("Vehicle journey started from:::"+startPlace);
		System.out.println("Vehicle journey() is going on.....");
		engine.stop();
		System.out.println("Vehicle journey ended at:::"+endPlace);
		
	}
	
	
	
	

}
