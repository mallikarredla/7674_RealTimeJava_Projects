package com.javaexpress.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialDto {

	private Integer credentialId;

	private String userName;
	private String password;

	private RoleBasedAuthority roleBasedAuthority;

	private Boolean isEnabled;

	private Boolean isAccounNonExpired;

	private Boolean isAccountNonLocked;

	private Boolean isCredentialNonExpired;

	@JsonProperty("user")
	private UserDto userDto;

}
