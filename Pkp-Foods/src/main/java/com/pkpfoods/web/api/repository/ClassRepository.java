package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.ClassEntity;
import com.pkpfoods.web.api.domain.ClassIdentifier;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, ClassIdentifier> {

}
