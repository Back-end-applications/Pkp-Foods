package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.FamilyEntity;
import com.pkpfoods.web.api.service.FamilyService;

@RestController
@CrossOrigin("*")
public class FamilyController {

	@Autowired
	private FamilyService familyService;

	@GetMapping(value = "getFamilies")
	public @ResponseBody Iterable<FamilyEntity> getFamilies() {
		return familyService.getFamilies();
	}

	@PostMapping(value = "insertFamilies", consumes = "application/json")
	public void insertFamilies(@RequestBody List<FamilyEntity> families) {
		families.forEach(family -> System.out.println(family.toString()));
		familyService.insertFamilies(families);
	}

	@PostMapping(value = "deleteFamilies")
	public void deleteFamilies(@RequestBody List<FamilyEntity> families) {
		familyService.deleteFamilies(families);
	}
}
