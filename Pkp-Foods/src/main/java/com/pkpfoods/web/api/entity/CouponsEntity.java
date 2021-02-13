package com.pkpfoods.web.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "admin_coupons")
@Data
public class CouponsEntity {

	@Id
	private String couponCode;

	private String description;

	private double discount;

	private String discountType;

	private LocalDate validFrom;

	private LocalDate validTo;

}
