package com.pkpfoods.web.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class ProductIdentifier implements Serializable {

	private String productId;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "family_id", nullable = false)
	private Family family;
}
