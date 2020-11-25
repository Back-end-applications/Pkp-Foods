package com.pkpfoods.web.api.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Products {

	@EmbeddedId
	private ProductIdentifier productIdentifier;

	private String productName;

	private String productImage;

	@Column(name = "class")
	private String className;

	private String brick;

	private String brand;

	private int expiry;

	@JsonIgnore
	@OneToMany(mappedBy = "childArticleIdentifier.products")
	private Set<ChildArticles> childArticles;

}
