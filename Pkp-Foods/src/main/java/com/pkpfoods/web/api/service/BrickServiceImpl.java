package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.domain.BrickEntity;
import com.pkpfoods.web.api.repository.BrickRepository;

@Service
public class BrickServiceImpl implements BrickService {

	@Autowired
	BrickRepository brickRepository;

	@Override
	public Iterable<BrickEntity> getBricks() {
		return brickRepository.findAll();
	}

	@Override
	public Iterable<BrickEntity> getBricks(String classId) {
		return brickRepository.findAllByClassId(classId);
	}

	@Override
	public void insertBricks(List<BrickEntity> bricks) {
		brickRepository.saveAll(bricks);
	}

	@Override
	public void deleteBricks(List<BrickEntity> bricks) {
		bricks.forEach(brick -> brickRepository.delete(brick));
	}

}
