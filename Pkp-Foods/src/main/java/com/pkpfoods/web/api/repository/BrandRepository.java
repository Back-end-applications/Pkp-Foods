package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.entity.BrandEntity;

@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, String> {

}
