package com.pkpfoods.web.api.domain;

import java.util.List;

import lombok.Data;

@Data
public class ParentArticles {

	private String productId;

	private String productName;

	private String productImage;

	private String className;

	private String brick;

	private String brand;

	private int expiry;

	private String taxCode;

	private List<ChildArticles> childArticlesList;

}
