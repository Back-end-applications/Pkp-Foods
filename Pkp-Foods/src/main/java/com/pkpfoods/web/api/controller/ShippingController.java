package com.pkpfoods.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.service.ShippingService;

@RestController
public class ShippingController {

	@Autowired
	ShippingService shipRocketService;

	@GetMapping(value = "fetchCourierServiceability", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchCourierServiceability() {
		return shipRocketService.fetchCourierServiceability();
	}

	@GetMapping(value = "fetchLocalityDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchLocalityDetails() {
		return shipRocketService.fetchLocalityDetails();
	}
}
