package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.ClassEntity;

public interface ClassService {

	Iterable<ClassEntity> getClasses();

	void insertClasses(List<ClassEntity> classes);

}
