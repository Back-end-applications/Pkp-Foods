package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.BrandEntity;
import com.pkpfoods.web.api.service.BrandService;

@RestController
@CrossOrigin("*")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@GetMapping(value = "getBrands")
	public @ResponseBody Iterable<BrandEntity> getBrands() {
		return brandService.getBrands();
	}

	@PostMapping(value = "insertBrands", consumes = "application/json")
	public void insertBrands(@RequestBody List<BrandEntity> brands) {
		brandService.insertBrands(brands);
	}

	@PostMapping(value = "deleteBrands")
	public void deleteBrands(@RequestBody List<BrandEntity> brands) {
		brandService.deleteBrands(brands);
	}

}
