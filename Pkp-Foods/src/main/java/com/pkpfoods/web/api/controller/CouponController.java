package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.CouponsEntity;
import com.pkpfoods.web.api.service.CouponsService;

@RestController
@CrossOrigin("*")
public class CouponController {

	@Autowired
	CouponsService couponsService;

	@PostMapping(value = "insertCoupons")
	public void insertCoupons(@RequestBody List<CouponsEntity> coupons) {
		System.out.println("Insert Coupons ====== Start");
		couponsService.insertCoupons(coupons);
		System.out.println("Insert Coupons ====== End");
	}

	@PostMapping(value = "deleteCoupons")
	public void deleteCoupons(@RequestBody List<String> coupons) {
		couponsService.deleteCoupons(coupons);
	}

	@GetMapping(value = "getCoupons")
	public @ResponseBody Iterable<CouponsEntity> getCoupons() {
		return couponsService.getCoupons();
	}

}
