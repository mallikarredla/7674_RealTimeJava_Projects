package com.javaexpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer credentialId;

	@Column(unique = true)
	private String userName;
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private RoleBasedAuthority roleBasedAuthority;

	private Boolean isEnabled;

	private Boolean isAccounNonExpired;

	private Boolean isAccountNonLocked;

	private Boolean isCredentialNonExpired;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
