package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.Products;
import com.pkpfoods.web.api.entity.ChildArticlesEntity;
import com.pkpfoods.web.api.entity.ParentArticlesEntity;
import com.pkpfoods.web.api.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "getParentArticles")
	public @ResponseBody Iterable<ParentArticlesEntity> getParentArticles() {
		return productService.getParentArticles();
	}

	@GetMapping(value = "getParentArticles", params = { "brickId" })
	public @ResponseBody Iterable<ParentArticlesEntity> getParentArticles(String brickId) {
		return productService.getParentArticles(brickId);
	}

	@PostMapping(value = "insertParentArticles", consumes = "application/json")
	public void insertParentArticles(@RequestBody List<ParentArticlesEntity> parentArticles) {
		productService.insertParentArticles(parentArticles);
	}

	@PostMapping(value = "deleteParentArticles")
	public void deleteParentArticles(@RequestBody List<ParentArticlesEntity> parentArticles) {
		productService.deleteParentArticles(parentArticles);
	}

	@GetMapping(value = "getChildArticles")
	public @ResponseBody Iterable<ChildArticlesEntity> getChildArticles() {
		return productService.getChildArticles();
	}

	@PostMapping(value = "insertChildArticles", consumes = "application/json")
	public void insertChildArticles(@RequestBody List<ChildArticlesEntity> childArticles) {
		System.out.println("ProductController: insertChildArticles");
		productService.insertChildArticles(childArticles);
	}

	@PostMapping(value = "deleteChildArticles")
	public void deleteChildArticles(@RequestBody List<ChildArticlesEntity> childArticles) {
		productService.deleteChildArticles(childArticles);
	}

	@GetMapping(value = "getProductsByFamilyId")
	public @ResponseBody Products getProductsByFamilyId(String familyId) {
		return productService.getProductsByFamilyId(familyId);
	}

}
