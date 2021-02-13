package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.entity.FamilyEntity;
import com.pkpfoods.web.api.service.FamilyService;

@RestController
@CrossOrigin("*")
public class OrderCartController {

	@Autowired
	private FamilyService familyService;

	@GetMapping(value = "getCartDetails")
	public @ResponseBody Iterable<FamilyEntity> getCartDetails() {
		return familyService.getFamilies();
	}

	@PostMapping(value = "addToCart", consumes = "application/json")
	public void addToCart(@RequestBody List<FamilyEntity> families) {
		familyService.insertFamilies(families);
	}

	@PostMapping(value = "deleteFromCart")
	public void deleteFromCart(@RequestBody List<FamilyEntity> families) {
		familyService.deleteFamilies(families);
	}

}
