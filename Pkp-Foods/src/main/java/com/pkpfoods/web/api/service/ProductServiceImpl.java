package com.pkpfoods.web.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.ChildArticles;
import com.pkpfoods.web.api.domain.ParentArticles;
import com.pkpfoods.web.api.domain.Products;
import com.pkpfoods.web.api.entity.ChildArticlesEntity;
import com.pkpfoods.web.api.entity.ParentArticlesEntity;
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
	public List<ParentArticlesEntity> getParentArticles(String brickId) {
		return parentArticlesRepository.findAllByBrickId(brickId);
	}

	@Override
	public void insertParentArticles(List<ParentArticlesEntity> parentArticles) {
		parentArticles.forEach(parentArticle -> {

			List<ParentArticlesEntity> parentArticlesList = (List<ParentArticlesEntity>) parentArticlesRepository
					.findAll();
			int i = 0;

			for (; i < parentArticlesList.size(); i++) {
				if (Integer.parseInt(parentArticlesList.get(i).getParentArticleIdentifier().getParentArticleId()) != i
						+ 1) {
					parentArticle.getParentArticleIdentifier().setParentArticleId(String.format("%02d", i + 1));
					break;
				}
			}

			if (parentArticle.getParentArticleIdentifier().getParentArticleId() == null) {
				parentArticle.getParentArticleIdentifier().setParentArticleId(String.format("%02d", i + 1));
			}

			parentArticlesRepository.save(parentArticle);

		});
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

			if (discount > 0) {
				if ("Fixed".equalsIgnoreCase(childArticle.getDiscountType())) {
					childArticle.setOfferPrice(MRP - discount);
				} else if ("Percentage".equalsIgnoreCase(childArticle.getDiscountType())) {
					childArticle.setOfferPrice(MRP - (MRP * discount / 100));
				}
			} else {
				childArticle.setOfferPrice(MRP);
			}

			List<ChildArticlesEntity> childArticlesList = (List<ChildArticlesEntity>) childArticlesRepository.findAll();

			int i = 0;

			for (; i < childArticlesList.size(); i++) {
				if (Integer.parseInt(childArticlesList.get(i).getChildArticleIdentifier().getChildArticleId()) != i
						+ 1) {
					childArticle.getChildArticleIdentifier().setChildArticleId(String.format("%03d", i + 1));
					break;
				}
			}

			if (childArticle.getChildArticleIdentifier().getChildArticleId() == null) {
				childArticle.getChildArticleIdentifier().setChildArticleId(String.format("%03d", i + 1));
			}

			childArticlesRepository.save(childArticle);

		});

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
			product.setFamilyName(
					childArticle.getChildArticleIdentifier().getParentArticles().getParentArticleIdentifier().getBrick()
							.getBrickIdentifier().getClassEntity().getClassIdentifier().getFamily().getFamilyName());
			product.setFamilyImage(
					childArticle.getChildArticleIdentifier().getParentArticles().getParentArticleIdentifier().getBrick()
							.getBrickIdentifier().getClassEntity().getClassIdentifier().getFamily().getFamilyImage());
			product.setParentArticlesList(new ArrayList<>());

			if (null == parentArticlesMap.get(childArticle.getChildArticleIdentifier().getParentArticles()
					.getParentArticleIdentifier().getParentArticleId())) {

				ParentArticles parentArticle = new ParentArticles();
				parentArticle.setProductId(childArticle.getChildArticleIdentifier().getParentArticles()
						.getParentArticleIdentifier().getParentArticleId());
				parentArticle.setProductName(
						childArticle.getChildArticleIdentifier().getParentArticles().getParentArticleImage());
				parentArticle.setProductImage(
						childArticle.getChildArticleIdentifier().getParentArticles().getParentArticleImage());
				parentArticle.setClassId(
						childArticle.getChildArticleIdentifier().getParentArticles().getParentArticleIdentifier()
								.getBrick().getBrickIdentifier().getClassEntity().getClassIdentifier().getClassId());
				parentArticle.setBrickId(childArticle.getChildArticleIdentifier().getParentArticles()
						.getParentArticleIdentifier().getBrick().getBrickIdentifier().getBrickId());
				parentArticle.setBrandId(childArticle.getChildArticleIdentifier().getParentArticles().getBrandId());
				parentArticle.setExpiry(childArticle.getChildArticleIdentifier().getParentArticles().getExpiry());
				parentArticle.setTaxCode(childArticle.getTaxCode());
				parentArticle.setChildArticlesList(new ArrayList<>());

				parentArticlesMap.put(childArticle.getChildArticleIdentifier().getParentArticles()
						.getParentArticleIdentifier().getParentArticleId(), parentArticle);

			}

			ChildArticles childArticles = new ChildArticles();

			childArticles.setWeight(childArticle.getWeight());
			childArticles.setUnitOfMeasurement(childArticle.getUnitOfMeasurement());
			childArticles.setCostPrice(childArticle.getCostPrice());
			childArticles.setInventory(childArticle.getInventory());
			childArticles.setMargin(childArticle.getMargin());
			childArticles.setMaximumRetailPrice(childArticle.getMaximumRetailPrice());
			childArticles.setDisplay(childArticle.isDisplay());

			parentArticlesMap.get(childArticle.getChildArticleIdentifier().getParentArticles()
					.getParentArticleIdentifier().getParentArticleId()).getChildArticlesList().add(childArticles);

		});

		for (String key : parentArticlesMap.keySet()) {
			product.getParentArticlesList().add(parentArticlesMap.get(key));
		}

		return product;

	}

}
