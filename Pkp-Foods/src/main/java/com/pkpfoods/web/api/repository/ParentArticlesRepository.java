package com.pkpfoods.web.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.ParentArticlesEntity;
import com.pkpfoods.web.api.domain.ParentArticlesIdentifier;

@Repository
public interface ParentArticlesRepository extends CrudRepository<ParentArticlesEntity, ParentArticlesIdentifier> {

	@Query(value = "SELECT * FROM pkp_foods.admin_classification_parent_articles WHERE brick_id = :brickId ORDER BY parent_article_name", nativeQuery = true)
	List<ParentArticlesEntity> findAllByBrickId(String brickId);

}
