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
	public Iterable<ClassEntity> getClasses(String familyId) {
		return classRepository.findAllByFamilyId(familyId);
	}

	@Override
	public void insertClasses(List<ClassEntity> classes) {
		classes.forEach(_class -> {

			List<ClassEntity> classesList = classRepository.findAllByOrderByClassIdentifierClassId();
			int i = 0;

			for (; i < classesList.size(); i++) {
				if (Integer.parseInt(classesList.get(i).getClassIdentifier().getClassId()) != i + 1) {
					_class.getClassIdentifier().setClassId(String.format("%02d", i + 1));
					break;
				}
			}

			if (_class.getClassIdentifier().getClassId() == null) {
				_class.getClassIdentifier().setClassId(String.format("%02d", i + 1));
			}

			classRepository.save(_class);

		});
	}

	@Override
	public void deleteClasses(List<ClassEntity> classes) {
		classes.forEach(classObj -> classRepository.delete(classObj));
	}

}
