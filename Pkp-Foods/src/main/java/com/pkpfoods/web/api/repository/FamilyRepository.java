package com.pkpfoods.web.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.entity.FamilyEntity;

@Repository
public interface FamilyRepository extends CrudRepository<FamilyEntity, String> {

	List<FamilyEntity> findAllByOrderByFamilyId();

}
