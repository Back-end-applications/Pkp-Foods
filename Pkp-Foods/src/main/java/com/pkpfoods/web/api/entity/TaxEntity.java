package com.pkpfoods.web.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "admin_tax_lookup")
@Data
public class TaxEntity {

	@Id
	private String taxCode;

	private int taxPercentage;

}
