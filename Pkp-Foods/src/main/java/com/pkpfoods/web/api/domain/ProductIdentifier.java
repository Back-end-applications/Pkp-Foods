package com.pkpfoods.web.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class ProductIdentifier implements Serializable {

	private String productId;

	@ManyToOne
	@JoinColumn(name = "family_id", nullable = false, insertable = false, updatable = false)
	private Family family;
}
