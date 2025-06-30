package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.nt.processor.BookItemProcessor;
import com.nt.reader.BookItemReader;
import com.nt.writer.BookItemWriter;




@Configuration
public class BatchConfig {
	
	@Autowired
	private BookItemReader reader;
	@Autowired
	private BookItemWriter writer;
	
	
	@Autowired
	private BookItemProcessor processor;
    
	
	@Autowired
	private JobMonitoringListener listener;
	
	
	
		
	}
	
	
	

}
