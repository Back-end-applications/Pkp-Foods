package com.pkpfoods.web.api.service;

import java.util.List;

import com.pkpfoods.web.api.domain.BrickEntity;

public interface BrickService {

	Iterable<BrickEntity> getBricks();

	void insertBricks(List<BrickEntity> bricks);

}
