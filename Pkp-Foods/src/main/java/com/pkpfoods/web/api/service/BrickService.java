package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.entity.BrickEntity;

public interface BrickService {

	Iterable<BrickEntity> getBricks();

	Iterable<BrickEntity> getBricks(String classId);

	void insertBricks(List<BrickEntity> bricks);

	void deleteBricks(List<BrickEntity> bricks);

}
