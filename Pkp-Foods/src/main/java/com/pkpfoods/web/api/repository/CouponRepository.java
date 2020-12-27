package com.pkpfoods.web.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pkpfoods.web.api.domain.CouponsEntity;

@Repository
public interface CouponRepository extends CrudRepository<CouponsEntity, String> {

}
