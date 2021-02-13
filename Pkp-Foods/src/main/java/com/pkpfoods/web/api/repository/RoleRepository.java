package com.pkpfoods.web.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pkpfoods.web.api.entity.ERole;
import com.pkpfoods.web.api.entity.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, String> {
	Optional<RoleEntity> findByName(ERole name);
}
