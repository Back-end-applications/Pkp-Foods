package com.pkpfoods.web.api.domain;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class JwtResponse {

	@NonNull
	private String token;

	private String type = "Bearer";

	@NonNull
	private String id;

	@NonNull
	private String username;

	@NonNull
	private String email;

	@NonNull
	private List<String> roles;

}
