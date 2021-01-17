package com.pkpfoods.web.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.ClassEntity;
import com.pkpfoods.web.api.domain.ClassIdentifier;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, ClassIdentifier> {

	@Query(value = "SELECT * FROM pkp_foods.admin_classification_class WHERE family_id = :familyId ORDER BY class_name", nativeQuery = true)
	Iterable<ClassEntity> findAllByFamilyId(String familyId);

	List<ClassEntity> findAllByOrderByClassIdentifierClassId();

}
