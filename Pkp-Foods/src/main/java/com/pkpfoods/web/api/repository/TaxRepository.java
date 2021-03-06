package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.entity.TaxEntity;

@Repository
public interface TaxRepository extends CrudRepository<TaxEntity, String> {
	Iterable<TaxEntity> findAllByOrderByTaxPercentage();
}
