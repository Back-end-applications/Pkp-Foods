package com.pkpfoods.web.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class ChildArticleIdentifier implements Serializable {

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "product_id", referencedColumnName = "productId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false, insertable = false, updatable = false) })
	private ParentArticlesEntity parentArticles;

	@ManyToOne
	@JoinColumn(name = "weight_code", nullable = false, insertable = false, updatable = false)
	private WeightsEntity weights;
}
