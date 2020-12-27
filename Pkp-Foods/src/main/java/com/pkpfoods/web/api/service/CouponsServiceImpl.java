package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.CouponsEntity;
import com.pkpfoods.web.api.repository.CouponRepository;

@Service
public class CouponsServiceImpl implements CouponsService {

	@Autowired
	CouponRepository couponsRepository;

	@Override
	public void insertCoupons(List<CouponsEntity> coupons) {
		couponsRepository.saveAll(coupons);
	}

	@Override
	public Iterable<CouponsEntity> getCoupons() {
		return couponsRepository.findAll();
	}

}
