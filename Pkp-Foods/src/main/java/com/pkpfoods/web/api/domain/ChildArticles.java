package com.pkpfoods.web.api.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class ChildArticles {

	@EmbeddedId
	private ChildArticleIdentifier childArticleIdentifier;

	private double costPrice;

	private double margin;

	private String taxCode;

	private double maximumRetailPrice;

	private int inventory;

	private boolean display;

}
