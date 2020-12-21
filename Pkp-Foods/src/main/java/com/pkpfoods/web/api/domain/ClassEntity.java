package com.pkpfoods.web.api.domain;

import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "class")
@Data
public class ClassEntity {

	@EmbeddedId
	private ClassIdentifier classIdentifier;

	private String className;

	@JsonIgnore
	@OneToMany(mappedBy = "brickIdentifier.classEntity")
	private Set<BrickEntity> bricks;
}
