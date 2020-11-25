package com.pkpfoods.web.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.ProductIdentifier;
import com.pkpfoods.web.api.domain.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, ProductIdentifier> {

	@Query(value = "SELECT * FROM products WHERE family_id = :familyId", nativeQuery = true)
	Iterable<Products> findAllByFamilyId(String familyId);

}
