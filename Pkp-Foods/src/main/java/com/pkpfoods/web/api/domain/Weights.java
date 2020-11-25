package com.pkpfoods.web.api.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Weights {

	@Id
	private String weightCode;

	private int weight;

	private String unitOfMeasurement;

	@JsonIgnore
	@OneToMany(mappedBy = "childArticleIdentifier.weights")
	private Set<ChildArticles> childArticles;

}
