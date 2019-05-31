package com.vvhien.service;

import java.util.Iterator;
import java.util.List;

import com.vvhien.dto.BuildingDTO;

public interface IBuildingService {
	
	BuildingDTO save(BuildingDTO buildingDTO);

	void update(BuildingDTO buildingDTO);

	void delete(Long id);

	BuildingDTO findById(Long id);

	List<BuildingDTO> findBy(Iterator parameterNames);
}
