package com.pkpfoods.web.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.ChildArticlesIdentifier;
import com.pkpfoods.web.api.domain.ChildArticlesEntity;

@Repository
public interface ChildArticlesRepository extends CrudRepository<ChildArticlesEntity, ChildArticlesIdentifier> {

	@Query(value = "select * from child_articles where family_id = :familyId order by maximum_retail_price", nativeQuery = true)
	Iterable<ChildArticlesEntity> findAllByFamilyId(String familyId);

}
