package com.pkpfoods.web.api.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Family {

	@Id
	private String familyId;

	private String familyName;

	private String familyImage;

	@JsonIgnore
	@OneToMany(mappedBy = "productIdentifier.family")
	private Set<Products> products;

}
