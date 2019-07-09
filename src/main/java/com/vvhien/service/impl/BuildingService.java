package com.vvhien.service.impl;

import java.awt.event.ItemEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

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
	
	/*public static BuildingService getInstance() {
		return new BuildingService();
	}*/
	
	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
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
	public List<BuildingDTO> findAll(Map<String, Object> properties, Pageble pageble, Object...where) {
		BuildingConverter buildingConverter = new BuildingConverter();
		
		List<BuildingDTO> buildingDTOs = new ArrayList<>();
		List<BuildingEntity> buildingEntities= buildingRepository.findAll(properties, pageble, where);
		for (int i = 0; i < buildingEntities.size(); i++) {
			buildingDTOs.add(buildingConverter.convertToDTO(buildingEntities.get(i)));
			
		}
		return buildingDTOs;
	}
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		Map<String, Object> properties = buildMapSearch(builder);
		List<BuildingEntity> buildingEntities =  buildingRepository.findAll(properties, pageble);
		List<BuildingDTO> results = buildingEntities.stream()
				.map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
		return results;
	}
	
	
	private Map<String, Object> buildMapSearch(BuildingSearchBuilder builder) {
		Map<String, Object> result = new HashMap<>();
		
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field field : fields) {
				if(!field.getName().equals("buildingTypes") && 
					!field.getName().startsWith("costRent") && 
					!field.getName().startsWith("areaRent")) {
					 field.setAccessible(true);
					 if(field.get(builder) != null) {
						 result.put(field.getName().toLowerCase(), field.get(builder));
					 }
				}
			}	
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return result ;
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
