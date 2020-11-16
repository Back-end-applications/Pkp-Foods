package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.Product;
import com.pkpfoods.web.api.domain.ProductIdentifier;

@Repository
public interface ProductRepository extends CrudRepository<Product, ProductIdentifier> {

}
