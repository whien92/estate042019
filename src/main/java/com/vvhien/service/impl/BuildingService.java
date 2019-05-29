package com.vvhien.service.impl;

import java.sql.Timestamp;

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

}
