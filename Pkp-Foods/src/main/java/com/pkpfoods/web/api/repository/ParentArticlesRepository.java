package com.pkpfoods.web.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.ParentArticleIdentifier;
import com.pkpfoods.web.api.domain.ParentArticlesEntity;

@Repository
public interface ParentArticlesRepository extends CrudRepository<ParentArticlesEntity, ParentArticleIdentifier> {

	@Query(value = "SELECT * FROM products WHERE family_id = :familyId", nativeQuery = true)
	Iterable<ParentArticlesEntity> findAllByFamilyId(String familyId);

}
