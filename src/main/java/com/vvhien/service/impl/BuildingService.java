package com.vvhien.service.impl;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import com.vvhien.converter.BuildingConverter;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.repository.IBuildingRepository;
import com.vvhien.repository.impl.BuildingRepository;
import com.vvhien.service.IBuildingService;

public class BuildingService implements IBuildingService{
	private IBuildingRepository buildingRepository;
	
	public BuildingService() {
		buildingRepository = new BuildingRepository();
	}
	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.converToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = buildingRepository.insert(buildingEntity);
		return null;
	}
	
	@Override
	public void update(BuildingDTO buildingDTO) {
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.converToEntity(buildingDTO);
		buildingRepository.update(buildingEntity);
	}
	
	@Override
	public void delete(Long id) {
		buildingRepository.delete(id);
	}
	@Override
	public BuildingDTO findById(Long id) {	
		return buildingRepository.findById(id);
	}
	
	@Override
	public List<BuildingDTO> findBy(Iterator parameterNames) {
		return buildingRepository.findBy(parameterNames);
	}

}
