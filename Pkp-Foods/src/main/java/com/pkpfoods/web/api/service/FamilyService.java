package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.FamilyEntity;

public interface FamilyService {

	Iterable<FamilyEntity> getFamilies();

	void insertFamilies(List<FamilyEntity> families);

	void deleteFamilies(List<FamilyEntity> families);
}
