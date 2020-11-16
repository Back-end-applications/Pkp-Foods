package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.Product;

public interface ProductService {

	Iterable<Product> getProducts();

	void insertProducts(List<Product> families);
}
