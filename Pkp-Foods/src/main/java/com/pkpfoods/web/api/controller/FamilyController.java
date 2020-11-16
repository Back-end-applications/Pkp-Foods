package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.Family;
import com.pkpfoods.web.api.service.FamilyService;

@RestController
public class FamilyController {

	@Autowired
	private FamilyService familyService;

	@GetMapping(value = "getFamilies")
	public @ResponseBody Iterable<Family> getFamilies() {
		return familyService.getFamilies();
	}

	@PostMapping(value = "insertFamilies", consumes = "application/json")
	public void insertFamily(@RequestBody List<Family> families) {
		familyService.insertFamilies(families);
	}
}
