package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.ChildArticles;
import com.pkpfoods.web.api.domain.Products;
import com.pkpfoods.web.api.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "getParentArticles")
	public @ResponseBody Iterable<Products> getParentArticles() {
		return productService.getParentArticles();
	}

	@GetMapping(value = "getProductsByFamilyId")
	public @ResponseBody Iterable<ChildArticles> getProductsByFamilyId(String familyId) {
		return productService.getProductsByFamilyId(familyId);
	}

	@PostMapping(value = "insertParentArticles", consumes = "application/json")
	public void insertParentArticles(@RequestBody List<Products> products) {
		productService.insertParentArticles(products);
	}

	@GetMapping(value = "getChildArticles")
	public @ResponseBody Iterable<ChildArticles> getChildArticles() {
		return productService.getChildArticles();
	}

	@PostMapping(value = "insertChildArticles", consumes = "application/json")
	public void insertChildArticles(@RequestBody List<ChildArticles> childArticles) {
		productService.insertChildArticles(childArticles);
	}
}
