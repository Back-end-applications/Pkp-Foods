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
		families.forEach(family -> {

			List<FamilyEntity> familiesList = familyRepository.findAllByOrderByFamilyId();
			int i = 0;

			for (; i < familiesList.size(); i++) {
				if (Integer.parseInt(familiesList.get(i).getFamilyId()) != i + 1) {
					family.setFamilyId(String.format("%02d", i + 1));
					break;
				}
			}

			if (family.getFamilyId() == null) {
				family.setFamilyId(String.format("%02d", i + 1));
			}

			familyRepository.save(family);

		});
	}

	@Override
	public void deleteFamilies(List<FamilyEntity> families) {
		families.forEach(family -> familyRepository.delete(family));
	}

}
