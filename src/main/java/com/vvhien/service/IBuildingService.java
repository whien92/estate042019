package com.vvhien.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vvhien.builder.BuildingSearchBuilder;
import com.vvhien.dto.BuildingDTO;

import paging.Pageble;

public interface IBuildingService {
	
	BuildingDTO save(BuildingDTO buildingDTO);

	void update(BuildingDTO buildingDTO);

	void delete(Long id);

	BuildingDTO findById(Long id);

	List<BuildingDTO> findBy(Iterator parameterNames);

	BuildingDTO findById1(Long id);

	List<BuildingDTO> findAll(Map<String, Object> properties, Pageble pageble, Object...where);

	List<BuildingDTO> findAll(BuildingSearchBuilder builder, Pageble pageble);
}
