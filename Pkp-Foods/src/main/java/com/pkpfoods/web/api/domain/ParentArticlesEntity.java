package com.pkpfoods.web.api.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity(name = "admin_classification_parent_articles")
@Data
public class ParentArticlesEntity {

	@EmbeddedId
	private ParentArticlesIdentifier parentArticleIdentifier;

	private String parentArticleName;

	private String parentArticleImage;

	private String brandId;

	private int expiry;

	private String description;

}
