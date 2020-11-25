package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.ChildArticles;
import com.pkpfoods.web.api.domain.Products;
import com.pkpfoods.web.api.repository.ChildArticlesRepository;
import com.pkpfoods.web.api.repository.ProductRepository;
import com.pkpfoods.web.api.repository.TaxRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ChildArticlesRepository childArticlesRepository;

	@Autowired
	TaxRepository taxRepository;

	@Override
	public Iterable<Products> getParentArticles() {
		return productRepository.findAll();
	}

	@Override
	public Iterable<ChildArticles> getProductsByFamilyId(String familyId) {
		System.out.println(familyId);
		return childArticlesRepository.findAllByFamilyId(familyId);
	}

	@Override
	public void insertParentArticles(List<Products> products) {
		productRepository.saveAll(products);
	}

	@Override
	public Iterable<ChildArticles> getChildArticles() {
		return childArticlesRepository.findAll();
	}

	@Override
	public void insertChildArticles(List<ChildArticles> childArticles) {
		childArticles.forEach(childArticle -> {
			double price = childArticle.getCostPrice() + childArticle.getMargin();
			childArticle.setMaximumRetailPrice(
					price + (price * taxRepository.findById(childArticle.getTaxCode()).get().getTaxPercentage() / 100));
		});
		childArticlesRepository.saveAll(childArticles);
	}

}
