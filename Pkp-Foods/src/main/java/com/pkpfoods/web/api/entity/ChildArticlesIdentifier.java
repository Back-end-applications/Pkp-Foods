package com.pkpfoods.web.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Embeddable
@Data
public class ChildArticlesIdentifier implements Serializable {

	private String childArticleId;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "parent_article_id", referencedColumnName = "parentArticleId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "brick_id", referencedColumnName = "brick_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false, insertable = false, updatable = false) })
	private ParentArticlesEntity parentArticles;

}
