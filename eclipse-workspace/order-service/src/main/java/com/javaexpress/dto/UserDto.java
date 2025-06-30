package com.javaexpress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	@JsonProperty("user")
	private UserDto userDto;
}
