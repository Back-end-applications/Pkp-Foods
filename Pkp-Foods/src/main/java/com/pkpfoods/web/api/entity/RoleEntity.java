package com.pkpfoods.web.api.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "roles")
@Data
public class RoleEntity {

	@Id
	private String id;

	@Enumerated(EnumType.STRING)
	private ERole name;

}
