package com.pkpfoods.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkpfoods.web.api.entity.BrickEntity;
import com.pkpfoods.web.api.repository.BrickRepository;

@Service
public class BrickServiceImpl implements BrickService {

	@Autowired
	BrickRepository brickRepository;

	@Override
	public Iterable<BrickEntity> getBricks() {
		return brickRepository.findAllByOrderByBrickIdentifierBrickId();
	}

	@Override
	public Iterable<BrickEntity> getBricks(String classId) {
		return brickRepository.findAllByClassId(classId);
	}

	@Override
	public void insertBricks(List<BrickEntity> bricks) {
		bricks.forEach(brick -> {

			List<BrickEntity> bricksList = brickRepository.findAllByOrderByBrickIdentifierBrickId();
			int i = 0;

			for (; i < bricksList.size(); i++) {
				if (Integer.parseInt(bricksList.get(i).getBrickIdentifier().getBrickId()) != i + 1) {
					brick.getBrickIdentifier().setBrickId(String.format("%02d", i + 1));
					break;
				}
			}

			if (brick.getBrickIdentifier().getBrickId() == null) {
				brick.getBrickIdentifier().setBrickId(String.format("%02d", i + 1));
			}

			brickRepository.save(brick);

		});
	}

	@Override
	public void deleteBricks(List<BrickEntity> bricks) {
		bricks.forEach(brick -> brickRepository.delete(brick));
	}

}
