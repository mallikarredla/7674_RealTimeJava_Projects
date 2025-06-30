package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("WMG")
public class WishMessageGenerator {
	
	@Autowired//Field Injection
	private LocalDateTime dateTime;//HAS-A Property
	
//b.method
	
	
	public String generateMessage(String user) {
		int hour=dateTime.getHour();
		if(hour<12) 
			return "good morning :"+user;
			
		else if(hour<16)
			return "Good Afternoon:"+user;
		else if(hour>20)
			return "Good Evening:"+user;
		else
			return "Goodnight:"+user;
		
	}
}
