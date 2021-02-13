package com.pkpfoods.web.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "admin_brand")
@Data
public class BrandEntity {

	@Id
	private String brandId;

	private String brandName;

}
