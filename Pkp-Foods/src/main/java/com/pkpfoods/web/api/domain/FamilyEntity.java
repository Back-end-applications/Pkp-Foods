package com.pkpfoods.web.api.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "family")
@Data
public class FamilyEntity {

	@Id
	private String familyId;

	private String familyName;

	private String familyImage;

	@JsonIgnore
	@OneToMany(mappedBy = "parentArticleIdentifier.family")
	private Set<ParentArticlesEntity> parentArticles;

}
