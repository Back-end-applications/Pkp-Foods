package com.pkpfoods.web.api.domain;

import lombok.Data;

@Data
public class ChildArticles {

	private int weight;

	private String unitOfMeasurement;

	private double costPrice;

	private double margin;

	private double maximumRetailPrice;

	private int inventory;

	private boolean display;

}
