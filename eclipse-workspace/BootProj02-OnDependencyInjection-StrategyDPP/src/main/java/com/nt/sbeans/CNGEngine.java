package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("cEngine")	
public final class CNGEngine implements IEngine {
	
	
	public CNGEngine() {
		System.out.println("CNGEngine:: 0-param constructor");
	}
		
		
		@Override
		public void start() {
			System.out.println("CNGEngine.start() :: CNGEngine was Started");
			}
		
		@Override
		public void stop() {
			System.out.println("CNGEngine.stop():: CNGEngine was Stopped");
			
		}
		
		
		

	}



