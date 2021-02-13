package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.entity.TaxEntity;
import com.pkpfoods.web.api.service.TaxService;

@RestController
@CrossOrigin("*")
public class TaxController {

	@Autowired
	private TaxService taxService;

	@GetMapping(value = "getTaxes")
	public @ResponseBody Iterable<TaxEntity> getTaxes() {
		return taxService.getTaxes();
	}

	@PostMapping(value = "insertTaxes", consumes = "application/json")
	public void insertTaxes(@RequestBody List<TaxEntity> taxes) {
		taxService.insertTaxes(taxes);
	}
}
