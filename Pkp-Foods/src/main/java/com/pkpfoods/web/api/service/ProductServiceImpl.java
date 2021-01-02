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
	public Iterable<ParentArticlesEntity> getParentArticles(String familyId) {
		return parentArticlesRepository.findAllByFamilyId(familyId);
	}

	@Override
	public void insertParentArticles(List<ParentArticlesEntity> parentArticles) {
		parentArticlesRepository.saveAll(parentArticles);
	}

	@Override
	public void deleteParentArticles(List<ParentArticlesEntity> parentArticles) {
		parentArticles.forEach(parentArticle -> parentArticlesRepository.delete(parentArticle));
	}

	@Override
	public Iterable<ChildArticlesEntity> getChildArticles() {
		return childArticlesRepository.findAll();
	}

	@Override
	public void insertChildArticles(List<ChildArticlesEntity> childArticles) {

		childArticles.forEach(childArticle -> {

			/* Setting MRP based on Cost price, Margin & Tax percentage */
			double price = childArticle.getCostPrice() + childArticle.getMargin();
			childArticle.setMaximumRetailPrice(
					price + (price * taxRepository.findById(childArticle.getTaxCode()).get().getTaxPercentage() / 100));

			/*
			 * Setting the offer price if discount is available else offer price is same as
			 * MRP
			 */
			double discount = childArticle.getDiscount();
			double MRP = childArticle.getMaximumRetailPrice();

			System.out.println(discount);
			if (discount > 0) {
				System.out.println("discount available");
				if ("Fixed".equalsIgnoreCase(childArticle.getDiscountType())) {
					childArticle.setOfferPrice(MRP - discount);
				} else if ("Percentage".equalsIgnoreCase(childArticle.getDiscountType())) {
					childArticle.setOfferPrice(MRP - (MRP * discount / 100));
				}
			} else {
				System.out.println("discount not available");
				childArticle.setOfferPrice(MRP);
			}

			System.out.println("Final offer price : " + childArticle.getOfferPrice());

		});

		childArticlesRepository.saveAll(childArticles);

	}

	@Override
	public void deleteChildArticles(List<ChildArticlesEntity> childArticles) {
		childArticles.forEach(childArticle -> childArticlesRepository.delete(childArticle));
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
				parentArticle.setClassId(childArticle.getChildArticleIdentifier().getParentArticles().getClassId());
				parentArticle.setBrickId(childArticle.getChildArticleIdentifier().getParentArticles().getBrickId());
				parentArticle.setBrandId(childArticle.getChildArticleIdentifier().getParentArticles().getBrandId());
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
