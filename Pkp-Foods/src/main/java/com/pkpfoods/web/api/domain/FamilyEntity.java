package com.pkpfoods.web.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "admin_classification_family")
@Data
public class FamilyEntity {

	@Id
	private String familyId;

	private String familyName;

	private String familyImage;

	private String description;

}
