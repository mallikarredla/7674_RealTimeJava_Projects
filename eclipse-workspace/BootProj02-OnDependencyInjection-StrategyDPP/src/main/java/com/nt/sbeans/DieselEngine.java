package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dEngine")
@Lazy
	public final class DieselEngine implements IEngine {
		
		public DieselEngine() {
			System.out.println("DieselEngine:: 0-param constructor");
		}
		
		
		@Override
		public void start() {
			System.out.println("DieselEngine.start() :: DieselEngine was Started");
			}
		
		@Override
		public void stop() {
			System.out.println("DieselEngine.stop():: DieselEngine was Stopped");
			
		}
		
		
		

	}



