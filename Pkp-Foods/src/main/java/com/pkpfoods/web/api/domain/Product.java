package com.pkpfoods.web.api.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Product {

	@EmbeddedId
	private ProductIdentifier productIdentifier;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "family_id", nullable = false, insertable = false, updatable = false)
	private Family family;

	private String productName;

	private String productImage;

}
