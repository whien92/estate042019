package com.vvhien.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.entity.RentArea;
import com.vvhien.paging.PageRequest;
import com.vvhien.repository.IRentAreaRepository;
import com.vvhien.repository.impl.RentAreaRepository;

public class BuildingConverter {
	
	//@Inject
	private IRentAreaRepository rentAreaRepository = new RentAreaRepository();  
	
	public BuildingDTO convertToDTO(BuildingEntity buildingEntity) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingDTO result = modelMapper.map(buildingEntity, BuildingDTO.class);
		
		Map<String, Object> conditions = new HashMap<>();
		conditions.put("buildingid", buildingEntity.getId());
		
		List<String> areas = rentAreaRepository.findAll(conditions, new PageRequest(null, null, null)).stream().map(RentArea::getValue).collect(Collectors.toList());
		if(areas.size() > 0) {
			result.setRentArea(StringUtils.join(areas, ","));
		}
		if(StringUtils.isNotBlank(buildingEntity.getType())) {
			result.setBuildingTypes(buildingEntity.getType().split(","));
		}
		return result;
	}
	
	public BuildingEntity converToEntity(BuildingDTO buildingDTO) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingEntity result = modelMapper.map(buildingDTO, BuildingEntity.class);
		if(StringUtils.isNotBlank(buildingDTO.getNumberOfBasement())) {
			result.setNumberOfBasement(Integer.parseInt(buildingDTO.getNumberOfBasement()));
		}
		if(StringUtils.isNotBlank(buildingDTO.getBuildingArea())) {
			result.setBuildingArea(Integer.parseInt(buildingDTO.getBuildingArea()));	
		}
		return result;
	}
}
