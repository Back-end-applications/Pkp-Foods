package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.entity.TaxEntity;
import com.pkpfoods.web.api.repository.TaxRepository;

@Service
public class TaxServiceImpl implements TaxService {
	@Autowired
	TaxRepository taxRepository;

	@Override
	public Iterable<TaxEntity> getTaxes() {
		return taxRepository.findAllByOrderByTaxPercentage();
	}

	@Override
	public void insertTaxes(List<TaxEntity> taxes) {
		taxRepository.saveAll(taxes);
	}
}
