package com.vvhien.service;

import java.awt.print.Pageable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vvhien.dto.BuildingDTO;

public interface IBuildingService {
	
	BuildingDTO save(BuildingDTO buildingDTO);

	void update(BuildingDTO buildingDTO);

	void delete(Long id);

	BuildingDTO findById(Long id);

	List<BuildingDTO> findBy(Iterator parameterNames);

	BuildingDTO findById1(Long id);

	List<BuildingDTO> findAll(Map m, Pageable pageable, Object where);
}
