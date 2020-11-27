package com.pkpfoods.web.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.ChildArticles;
import com.pkpfoods.web.api.domain.ChildArticlesEntity;
import com.pkpfoods.web.api.domain.ParentArticles;
import com.pkpfoods.web.api.domain.ParentArticlesEntity;
import com.pkpfoods.web.api.domain.Products;
import com.pkpfoods.web.api.domain.Weight;
import com.pkpfoods.web.api.repository.ChildArticlesRepository;
import com.pkpfoods.web.api.repository.ParentArticlesRepository;
import com.pkpfoods.web.api.repository.TaxRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ParentArticlesRepository parentArticlesRepository;

	@Autowired
	ChildArticlesRepository childArticlesRepository;

	@Autowired
	TaxRepository taxRepository;

	@Override
	public Iterable<ParentArticlesEntity> getParentArticles() {
		return parentArticlesRepository.findAll();
	}

	@Override
	public void insertParentArticles(List<ParentArticlesEntity> parentArticles) {
		parentArticlesRepository.saveAll(parentArticles);
	}

	@Override
	public Iterable<ChildArticlesEntity> getChildArticles() {
		return childArticlesRepository.findAll();
	}

	@Override
	public void insertChildArticles(List<ChildArticlesEntity> childArticles) {
		childArticles.forEach(childArticle -> {
			double price = childArticle.getCostPrice() + childArticle.getMargin();
			childArticle.setMaximumRetailPrice(
					price + (price * taxRepository.findById(childArticle.getTaxCode()).get().getTaxPercentage() / 100));
		});
		childArticlesRepository.saveAll(childArticles);
	}

	@Override
	public Products getProductsByFamilyId(String familyId) {
		System.out.println(familyId);
		return this.productMapper(familyId);
	}

	private Products productMapper(String familyId) {

		Iterable<ChildArticlesEntity> childArticlesList = childArticlesRepository.findAllByFamilyId(familyId);

		Products product = new Products();
		Map<String, ParentArticles> parentArticlesMap = new HashMap<>();

		childArticlesList.forEach(childArticle -> {

			product.setFamilyId(familyId);
			product.setFamilyName(childArticle.getChildArticleIdentifier().getParentArticles()
					.getParentArticleIdentifier().getFamily().getFamilyName());
			product.setFamilyImage(childArticle.getChildArticleIdentifier().getParentArticles()
					.getParentArticleIdentifier().getFamily().getFamilyImage());
			product.setParentArticlesList(new ArrayList<>());

			if (null == parentArticlesMap.get(childArticle.getChildArticleIdentifier().getParentArticles()
					.getParentArticleIdentifier().getProductId())) {

				ParentArticles parentArticle = new ParentArticles();
				parentArticle.setProductId(childArticle.getChildArticleIdentifier().getParentArticles()
						.getParentArticleIdentifier().getProductId());
				parentArticle
						.setProductName(childArticle.getChildArticleIdentifier().getParentArticles().getProductName());
				parentArticle.setProductImage(
						childArticle.getChildArticleIdentifier().getParentArticles().getProductImage());
				parentArticle.setClassName(childArticle.getChildArticleIdentifier().getParentArticles().getClassName());
				parentArticle.setBrick(childArticle.getChildArticleIdentifier().getParentArticles().getBrick());
				parentArticle.setBrand(childArticle.getChildArticleIdentifier().getParentArticles().getBrand());
				parentArticle.setExpiry(childArticle.getChildArticleIdentifier().getParentArticles().getExpiry());
				parentArticle.setTaxCode(childArticle.getTaxCode());
				parentArticle.setChildArticlesList(new ArrayList<>());

				parentArticlesMap.put(childArticle.getChildArticleIdentifier().getParentArticles()
						.getParentArticleIdentifier().getProductId(), parentArticle);

			}

			ChildArticles childArticles = new ChildArticles();

			childArticles.setCostPrice(childArticle.getCostPrice());
			childArticles.setInventory(childArticle.getInventory());
			childArticles.setMargin(childArticle.getMargin());
			childArticles.setMaximumRetailPrice(childArticle.getMaximumRetailPrice());
			childArticles.setDisplay(childArticle.isDisplay());

			Weight weight = new Weight();
			weight.setWeightCode(childArticle.getChildArticleIdentifier().getWeights().getWeightCode());
			weight.setWeight(childArticle.getChildArticleIdentifier().getWeights().getWeight());
			weight.setUnitOfMeasurement(childArticle.getChildArticleIdentifier().getWeights().getUnitOfMeasurement());
			childArticles.setWeight(weight);

			parentArticlesMap.get(childArticle.getChildArticleIdentifier().getParentArticles()
					.getParentArticleIdentifier().getProductId()).getChildArticlesList().add(childArticles);

		});

		for (String key : parentArticlesMap.keySet()) {
			product.getParentArticlesList().add(parentArticlesMap.get(key));
		}

		return product;

	}

}
