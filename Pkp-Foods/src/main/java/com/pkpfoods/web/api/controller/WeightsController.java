package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.WeightsEntity;
import com.pkpfoods.web.api.service.WeightsService;

@RestController
public class WeightsController {

	@Autowired
	private WeightsService weightsService;

	@GetMapping(value = "getWeights")
	public @ResponseBody Iterable<WeightsEntity> getWeights() {
		return weightsService.getWeights();
	}

	@PostMapping(value = "insertWeights", consumes = "application/json")
	public void insertWeights(@RequestBody List<WeightsEntity> weights) {
		System.out.println("Weights controller");
		weightsService.insertWeights(weights);
	}
}
