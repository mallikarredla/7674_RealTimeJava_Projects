package com.javaexpress.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserListener {
	
	@KafkaListener(topics="javaexpress-user-topic",groupId="userconsumergroup")
	public void getEvents(UserDto userDto) {
		log.info("Received User Dto{} ",userDto);
		
	}

}

