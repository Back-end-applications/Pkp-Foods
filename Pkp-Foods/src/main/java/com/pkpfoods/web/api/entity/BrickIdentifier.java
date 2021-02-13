package com.pkpfoods.web.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class BrickIdentifier implements Serializable {

	private static final long serialVersionUID = 1L;

	private String brickId;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "class_id", referencedColumnName = "classId", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false, insertable = false, updatable = false) })
	private ClassEntity classEntity;

}
