package com.pkpfoods.web.api.domain;

import java.util.Set;

import lombok.Data;

@Data
public class SignupRequest {

	private String username;

	private String email;

	private String password;

	private Set<String> roles;

}
