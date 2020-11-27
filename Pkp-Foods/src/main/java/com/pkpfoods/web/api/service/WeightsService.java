package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.WeightsEntity;

public interface WeightsService {

	Iterable<WeightsEntity> getWeights();

	void insertWeights(List<WeightsEntity> weights);

}
