package com.vvhien.service.impl;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vvhien.builder.BuildingSearchBuilder;
import com.vvhien.converter.BuildingConverter;
import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.paging.Pageble;
import com.vvhien.repository.IBuildingRepository;
import com.vvhien.repository.impl.BuildingRepository;
import com.vvhien.service.IBuildingService;

public class BuildingService implements IBuildingService{
	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;
	
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
		Long id = buildingRepository.insert(buildingEntity);
		return null;
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
	
	
	
	/*private Object getValue(Field field, BuildingSearchBuilder builder) {
		Object result = null;
		Method getter = getGetter(field, builder);
		if(getter != null) {
			try {
				result = getter.invoke(builder);
			} catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
		}
		return null;
	}
	private Method getGetter(Field field, BuildingSearchBuilder builder) {
		String getterMethod = "get" + StringUtils.capitalize(field.getName());
		try {
			return builder.getClass().getMethod(getterMethod);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		} 
	}*/



}
