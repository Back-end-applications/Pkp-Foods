package com.pkpfoods.web.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Family {

	@Id
	private String familyId;

	private String familyName;

	private String familyImage;

	@OneToOne(mappedBy = "productIdentifier.family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Product product;

}
