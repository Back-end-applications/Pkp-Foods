package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.Family;
import com.pkpfoods.web.api.repository.FamilyRepository;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	FamilyRepository familyRepository;

	@Override
	public Iterable<Family> getFamilies() {
		return familyRepository.findAll();
	}

	@Override
	public void insertFamilies(List<Family> families) {
		familyRepository.saveAll(families);
	}

}
