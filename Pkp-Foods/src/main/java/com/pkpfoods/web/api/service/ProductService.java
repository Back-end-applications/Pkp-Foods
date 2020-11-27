package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.ChildArticlesEntity;
import com.pkpfoods.web.api.domain.ParentArticlesEntity;
import com.pkpfoods.web.api.domain.Products;

public interface ProductService {

	Iterable<ParentArticlesEntity> getParentArticles();

	Products getProductsByFamilyId(String familyId);

	void insertParentArticles(List<ParentArticlesEntity> parentArticles);

	Iterable<ChildArticlesEntity> getChildArticles();

	void insertChildArticles(List<ChildArticlesEntity> childArticles);
}
