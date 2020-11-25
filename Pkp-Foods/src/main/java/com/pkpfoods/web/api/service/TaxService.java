package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.Tax;

public interface TaxService {

	Iterable<Tax> getTaxes();

	void insertTaxes(List<Tax> taxes);

}
