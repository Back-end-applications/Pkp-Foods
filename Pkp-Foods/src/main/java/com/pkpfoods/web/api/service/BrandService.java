package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.BrandEntity;

public interface BrandService {

	Iterable<BrandEntity> getBrands();

	void insertBrands(List<BrandEntity> brands);

	void deleteBrands(List<BrandEntity> brands);

}
