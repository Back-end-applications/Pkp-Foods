package com.pkpfoods.web.api.domain;

import lombok.Data;

@Data
public class ChildArticles {

	private Weight weight;

	private double costPrice;

	private double margin;

	private double maximumRetailPrice;

	private int inventory;

	private boolean display;

}
