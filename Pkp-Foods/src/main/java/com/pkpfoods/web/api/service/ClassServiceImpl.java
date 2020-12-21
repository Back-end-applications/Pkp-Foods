package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.ClassEntity;
import com.pkpfoods.web.api.repository.ClassRepository;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	ClassRepository classRepository;

	@Override
	public Iterable<ClassEntity> getClasses() {
		return classRepository.findAll();
	}

	@Override
	public void insertClasses(List<ClassEntity> classes) {
		classRepository.saveAll(classes);
	}

}
