package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.Weights;
import com.pkpfoods.web.api.repository.WeightsRepository;

@Service
public class WeightsServiceImpl implements WeightsService {

	@Autowired
	WeightsRepository weightsRepository;

	@Override
	public Iterable<Weights> getWeights() {
		return weightsRepository.findAll();
	}

	@Override
	public void insertWeights(List<Weights> weights) {
		weightsRepository.saveAll(weights);
	}
}
