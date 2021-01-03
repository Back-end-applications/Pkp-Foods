package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.ClassEntity;
import com.pkpfoods.web.api.service.ClassService;

@RestController
@CrossOrigin("*")
public class ClassController {

	@Autowired
	private ClassService classService;

	@GetMapping(value = "getClasses")
	public @ResponseBody Iterable<ClassEntity> getClasses() {
		return classService.getClasses();
	}

	@GetMapping(value = "getClasses", params = { "familyId" })
	public @ResponseBody Iterable<ClassEntity> getClasses(String familyId) {
		return classService.getClasses(familyId);
	}

	@PostMapping(value = "insertClasses", consumes = "application/json")
	public void insertClasses(@RequestBody List<ClassEntity> classes) {
		classService.insertClasses(classes);
	}

	@PostMapping(value = "deleteClasses")
	public void deleteClasses(@RequestBody List<ClassEntity> classes) {
		classService.deleteClasses(classes);
	}

}