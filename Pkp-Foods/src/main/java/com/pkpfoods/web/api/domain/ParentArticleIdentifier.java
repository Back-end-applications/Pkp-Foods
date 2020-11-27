package com.pkpfoods.web.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class ParentArticleIdentifier implements Serializable {

	private static final long serialVersionUID = 1L;

	private String productId;

	@ManyToOne
	@JoinColumn(name = "family_id", nullable = false, insertable = false, updatable = false)
	private FamilyEntity family;
}
