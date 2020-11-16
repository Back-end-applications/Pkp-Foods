package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.Product;
import com.pkpfoods.web.api.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "getProducts")
	public @ResponseBody Iterable<Product> getFamilies() {
		return productService.getProducts();
	}

	@PostMapping(value = "insertProducts", consumes = "application/json")
	public void insertFamily(@RequestBody List<Product> products) {
		System.out.println("Product details == " + products);
		productService.insertProducts(products);
	}
}
