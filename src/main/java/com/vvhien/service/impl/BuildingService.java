package com.vvhien.service.impl;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vvhien.converter.BuildingConverter;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.paging.Pageble;
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
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingDTO buildingDTO = buildingConverter.convertToDTO(buildingRepository.findById(id));
		return buildingDTO;
	}
	
	@Override
	public List<BuildingDTO> findBy(Iterator parameterNames) {
		return buildingRepository.findBy(parameterNames);
	}
	@Override
	public BuildingDTO findById1(Long id) {
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingDTO buildingDTO = buildingConverter.convertToDTO(buildingRepository.findById1(id));
		return buildingDTO;
	}
	@Override
	public List<BuildingDTO> findAll(Map m, Pageble pageble, Object where) {
		BuildingConverter buildingConverter = new BuildingConverter();
		List<BuildingDTO> buildingDTOs = buildingConverter.convertToDTO(buildingRepository.findAll(m, pageble, where));
		return buildingDTOs;
	}

}
