package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EligibilityDeterminationAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>handleAllExceptions(Exception e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		
		
		
		
	}

}
