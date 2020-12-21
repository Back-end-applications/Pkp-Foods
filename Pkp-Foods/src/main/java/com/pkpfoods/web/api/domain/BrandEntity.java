package com.pkpfoods.web.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "brand")
@Data
public class BrandEntity {

	@Id
	private String brandId;

	private String brandName;

}
