package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.ClassEntity;

public interface ClassService {

	Iterable<ClassEntity> getClasses();

	Iterable<ClassEntity> getClasses(String familyId);

	void insertClasses(List<ClassEntity> classes);

	void deleteClasses(List<ClassEntity> classes);

}
