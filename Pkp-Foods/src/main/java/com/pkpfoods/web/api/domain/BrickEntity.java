package com.pkpfoods.web.api.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity(name = "admin_classification_brick")
@Data
public class BrickEntity {

	@EmbeddedId
	private BrickIdentifier brickIdentifier;

	private String BrickName;

}
