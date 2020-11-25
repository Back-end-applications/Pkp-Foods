package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.Weights;

public interface WeightsService {

	Iterable<Weights> getWeights();

	void insertWeights(List<Weights> weights);

}
