package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.CouponsEntity;

public interface CouponsService {

	void insertCoupons(List<CouponsEntity> coupons);

	Iterable<CouponsEntity> getCoupons();

	void deleteCoupons(List<String> coupons);

}
