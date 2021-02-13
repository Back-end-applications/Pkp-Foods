package com.pkpfoods.web.api.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity(name = "admin_classification_class")
@Data
public class ClassEntity {

	@EmbeddedId
	private ClassIdentifier classIdentifier;

	private String className;
}
