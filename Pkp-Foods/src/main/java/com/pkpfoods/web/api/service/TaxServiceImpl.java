package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.Tax;
import com.pkpfoods.web.api.repository.TaxRepository;

@Service
public class TaxServiceImpl implements TaxService {
	@Autowired
	TaxRepository taxRepository;

	@Override
	public Iterable<Tax> getTaxes() {
		return taxRepository.findAll();
	}

	@Override
	public void insertTaxes(List<Tax> taxes) {
		taxRepository.saveAll(taxes);
	}
}
