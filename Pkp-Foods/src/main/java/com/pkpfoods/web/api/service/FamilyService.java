package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.Family;

public interface FamilyService {

	Iterable<Family> getFamilies();

	void insertFamilies(List<Family> families);
}
