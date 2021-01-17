package com.pkpfoods.web.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.BrickEntity;
import com.pkpfoods.web.api.domain.BrickIdentifier;

@Repository
public interface BrickRepository extends CrudRepository<BrickEntity, BrickIdentifier> {

	@Query(value = "SELECT * FROM pkp_foods.admin_classification_brick WHERE class_id = :classId ORDER BY brick_name", nativeQuery = true)
	Iterable<BrickEntity> findAllByClassId(String classId);

	List<BrickEntity> findAllByOrderByBrickIdentifierBrickId();

}
