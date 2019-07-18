package com.vvhien.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.vvhien.builder.BuildingSearchBuilder;
import com.vvhien.converter.BuildingConverter;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.entity.RentArea;
import com.vvhien.paging.Pageble;
import com.vvhien.repository.IBuildingRepository;
import com.vvhien.repository.IRentAreaRepository;
import com.vvhien.repository.impl.BuildingRepository;
import com.vvhien.repository.impl.RentAreaRepository;
import com.vvhien.service.IBuildingService;

public class BuildingService implements IBuildingService{
	//@Inject
	private IBuildingRepository buildingRepository = new BuildingRepository();
	
	//@Inject
	private BuildingConverter buildingConverter = new BuildingConverter();
	
	//@Inject
	private IRentAreaRepository rentAreaRepository = new RentAreaRepository();
	
	public BuildingService() {
		if(buildingRepository == null) {
			buildingRepository = new BuildingRepository();
		}
		if(buildingConverter == null) {
			buildingConverter = new BuildingConverter();
		}
	}
	 
	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.converToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		buildingEntity.setCreatedBy("Hien Hien ");
		buildingEntity.setType(StringUtils.join(buildingDTO.getBuildingTypes(), ","));
		
		Long id = buildingRepository.insert(buildingEntity);
		
		for (String item :  buildingDTO.getRentArea().split(",")) {
			RentArea rentArea = new RentArea();
			rentArea.setValue(item);
			rentArea.setBuildingId(id);
			rentAreaRepository.insert(rentArea);
			
		}
		
		return buildingConverter.convertToDTO(buildingRepository.findById(id));
	}
	
	@Override
	public void update(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.converToEntity(buildingDTO);
		buildingRepository.update(buildingEntity);
	}
	
	@Override
	public void delete(Long id) {
		buildingRepository.delete(id);
	}
	@Override
	public BuildingDTO findById(Long id) {	
		BuildingDTO buildingDTO = buildingConverter.convertToDTO(buildingRepository.findById(id));
		return buildingDTO;
	}
	
	@Override
	public List<BuildingDTO> findBy(Iterator parameterNames) {
		return buildingRepository.findBy(parameterNames);
	}
	@Override
	public BuildingDTO findById1(Long id) {
		BuildingDTO buildingDTO = buildingConverter.convertToDTO(buildingRepository.findById1(id));
		return buildingDTO;
	}

	@Override
	public List<BuildingDTO> findAll(Map<String, Object> properties, Pageble pageble, Object...where) {	
		List<BuildingDTO> buildingDTOs = new ArrayList<>();
		List<BuildingEntity> buildingEntities= buildingRepository.findAll(properties, pageble, where);
		for (int i = 0; i < buildingEntities.size(); i++) {
			buildingDTOs.add(buildingConverter.convertToDTO(buildingEntities.get(i)));
			
		}
		return buildingDTOs; 
	}
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		List<BuildingEntity> buildingEntities =  buildingRepository.findAll(builder, pageble);
		List<BuildingDTO> results = buildingEntities.stream()
				.map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
		return results;
	}

	@Override
	public void update(BuildingDTO buildingDTO, long id) {
		BuildingEntity oldBuilding = buildingRepository.findById(id);
		BuildingEntity newBuilding = buildingConverter.converToEntity(buildingDTO);
		newBuilding.setCreatedBy(oldBuilding.getCreatedBy());
		newBuilding.setCreatedDate(oldBuilding.getCreatedDate());
		
		String rentArea = buildingDTO.getRentArea();
		updateRentArea(buildingDTO.getRentArea(), id);
		newBuilding.setType(StringUtils.join(buildingDTO.getBuildingTypes(), ","));
		buildingRepository.update(newBuilding);
	}

	private void updateRentArea(String strRentArea, long buildingId) {
		//delete rentArea by buildingId
		rentAreaRepository.deleteByBuilding(buildingId);
		
		//insert rentArea
		for (String item : strRentArea.split(",")) {
			RentArea rentArea = new RentArea();
			rentArea.setBuildingId(buildingId);
			rentArea.setValue(item);
			rentAreaRepository.insert(rentArea);
		}
		
	}

	@Override
	public void delete(Long[] ids) {
		for(long id : ids){
			rentAreaRepository.deleteByBuilding(id);
			buildingRepository.delete(id);
		}
		
	}
}
