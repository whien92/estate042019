package com.vvhien.service;

import com.vvhien.dto.BuildingDTO;

public interface IBuildingService {
	
	BuildingDTO save(BuildingDTO buildingDTO);

	void update(BuildingDTO buildingDTO);

	void delete(Long id);

	BuildingDTO findById(Long id);
}
