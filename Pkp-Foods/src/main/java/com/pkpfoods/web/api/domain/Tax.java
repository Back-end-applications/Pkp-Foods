package com.pkpfoods.web.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tax_lookup")
@Data
public class Tax {

	@Id
	private String taxCode;

	private int taxPercentage;

}
