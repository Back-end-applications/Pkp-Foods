package com.pkpfoods.web.api.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity(name = "child_articles")
@Data
public class ChildArticlesEntity {

	@EmbeddedId
	private ChildArticleIdentifier childArticleIdentifier;

	private double costPrice;

	private double margin;

	private String taxCode;

	private double maximumRetailPrice;

	private int inventory;

	private boolean display;

}
