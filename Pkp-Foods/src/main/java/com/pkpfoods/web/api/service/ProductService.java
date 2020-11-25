package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.ChildArticles;
import com.pkpfoods.web.api.domain.Products;

public interface ProductService {

	Iterable<Products> getParentArticles();

	Iterable<ChildArticles> getProductsByFamilyId(String familyId);

	void insertParentArticles(List<Products> products);

	Iterable<ChildArticles> getChildArticles();

	void insertChildArticles(List<ChildArticles> childArticles);
}
