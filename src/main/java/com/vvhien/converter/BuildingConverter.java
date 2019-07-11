package com.vvhien.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.entity.RentArea;
import com.vvhien.paging.PageRequest;
import com.vvhien.repository.IRentAreaRepository;

public class BuildingConverter {
	
	@Inject
	private IRentAreaRepository rentAreaRepository;  
	
	public BuildingDTO convertToDTO(BuildingEntity buildingEntity) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingDTO result = modelMapper.map(buildingEntity, BuildingDTO.class);
		
		Map<String, Object> conditions = new HashMap<>();
		conditions.put("buildingid", buildingEntity.getId());
		
		//List<RentArea> rentAreas = rentAreaRepository.findAll(conditions, new PageRequest(null, null, null));
		
		List<String> areas = rentAreaRepository.findAll(conditions, new PageRequest(null, null, null)).stream().map(RentArea::getValue).collect(Collectors.toList());
		if(areas.size() > 0) {
			result.setRentArea(StringUtils.join(areas, ","));
		}
		
		return result;
	}
	
	public BuildingEntity converToEntity(BuildingDTO buildingDTO) {
		ModelMapper modelMapper = new ModelMapper();
		BuildingEntity result = modelMapper.map(buildingDTO, BuildingEntity.class);
		return result;
	}
}
