package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.Products;
import com.pkpfoods.web.api.entity.ChildArticlesEntity;
import com.pkpfoods.web.api.entity.ParentArticlesEntity;

public interface ProductService {

	Iterable<ParentArticlesEntity> getParentArticles();

	List<ParentArticlesEntity> getParentArticles(String brickId);

	void insertParentArticles(List<ParentArticlesEntity> parentArticles);

	Iterable<ChildArticlesEntity> getChildArticles();

	void insertChildArticles(List<ChildArticlesEntity> childArticles);

	void deleteChildArticles(List<ChildArticlesEntity> childArticles);

	Products getProductsByFamilyId(String familyId);

	void deleteParentArticles(List<ParentArticlesEntity> parentArticles);

}
