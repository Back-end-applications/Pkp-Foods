package com.pkpfoods.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkpfoods.web.api.domain.BrickEntity;
import com.pkpfoods.web.api.service.BrickService;

@RestController
@CrossOrigin("*")
public class BrickController {

	@Autowired
	private BrickService brickService;

	@GetMapping(value = "getBricks")
	public @ResponseBody Iterable<BrickEntity> getBricks() {
		return brickService.getBricks();
	}

	@PostMapping(value = "insertBricks", consumes = "application/json")
	public void insertBricks(@RequestBody List<BrickEntity> bricks) {
		brickService.insertBricks(bricks);
	}

}
