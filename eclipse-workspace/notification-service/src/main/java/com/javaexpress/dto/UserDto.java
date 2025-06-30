package com.javaexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDto {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

}
