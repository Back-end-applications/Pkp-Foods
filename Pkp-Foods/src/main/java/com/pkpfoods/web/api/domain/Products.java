package com.pkpfoods.web.api.domain;

import java.util.List;

import lombok.Data;

@Data
public class Products {

	private String familyId;

	private String familyName;

	private String familyImage;

	private List<ParentArticles> parentArticlesList;

}
