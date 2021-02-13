package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.entity.BrandEntity;
import com.pkpfoods.web.api.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandRepository brandRepository;

	@Override
	public Iterable<BrandEntity> getBrands() {
		return brandRepository.findAll();
	}

	@Override
	public void insertBrands(List<BrandEntity> brands) {
		brandRepository.saveAll(brands);
	}

	@Override
	public void deleteBrands(List<BrandEntity> brands) {
		brands.forEach(brand -> brandRepository.delete(brand));
	}

}
