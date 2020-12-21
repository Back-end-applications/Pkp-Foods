package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.BrickEntity;
import com.pkpfoods.web.api.domain.BrickIdentifier;

@Repository
public interface BrickRepository extends CrudRepository<BrickEntity, BrickIdentifier> {

}
