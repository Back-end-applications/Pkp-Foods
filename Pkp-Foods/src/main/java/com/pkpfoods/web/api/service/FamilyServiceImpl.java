package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.FamilyEntity;
import com.pkpfoods.web.api.repository.FamilyRepository;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	FamilyRepository familyRepository;

	@Override
	public Iterable<FamilyEntity> getFamilies() {
		return familyRepository.findAll();
	}

	@Override
	public void insertFamilies(List<FamilyEntity> families) {
		familyRepository.saveAll(families);
	}

	@Override
	public void deleteFamilies(List<FamilyEntity> families) {
		families.forEach(family -> familyRepository.delete(family));
	}

}
