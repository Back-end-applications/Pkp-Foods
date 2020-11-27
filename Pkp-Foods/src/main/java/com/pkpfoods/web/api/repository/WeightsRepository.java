package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.WeightsEntity;

@Repository
public interface WeightsRepository extends CrudRepository<WeightsEntity, String> {

}
