package com.pkpfoods.web.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class ParentArticlesIdentifier implements Serializable {

	private static final long serialVersionUID = 1L;

	private String parentArticleId;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "brick_id", referencedColumnName = "brickId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false, insertable = false, updatable = false) })
	private BrickEntity brick;
}
