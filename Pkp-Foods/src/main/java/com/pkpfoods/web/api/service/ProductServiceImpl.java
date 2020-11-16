package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.Product;
import com.pkpfoods.web.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public void insertProducts(List<Product> families) {
		productRepository.saveAll(families);
	}

}
