package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.entity.TaxEntity;

public interface TaxService {

	Iterable<TaxEntity> getTaxes();

	void insertTaxes(List<TaxEntity> taxes);

}
