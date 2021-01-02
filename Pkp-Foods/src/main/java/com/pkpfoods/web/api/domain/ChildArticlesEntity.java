package com.pkpfoods.web.api.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity(name = "child_articles")
@Data
public class ChildArticlesEntity {

	@EmbeddedId
	private ChildArticlesIdentifier childArticleIdentifier;

	private double costPrice;

	private double margin;

	private double discount;

	private String discountType;

	private String taxCode;

	private double maximumRetailPrice;

	private double offerPrice;

	private double length;

	private double width;

	private double height;

	@Column(name = "EAN_Code")
	private String EANCode;

	private int inventory;

	private LocalDate validFrom;

	private LocalDate validTo;

	private boolean display;

}
