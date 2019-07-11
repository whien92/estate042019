package com.vvhien.repository.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.vvhien.builder.BuildingSearchBuilder;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.paging.Pageble;
import com.vvhien.repository.IBuildingRepository;

public class BuildingRepository extends AbstractJDBC<BuildingEntity> implements IBuildingRepository{

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		Map<String, Object> properties = buildMapSearch(builder);
		StringBuilder whereClause = new StringBuilder();
		
		if(StringUtils.isNotBlank(builder.getCostRentFrom())) {
			whereClause.append(" AND costrent >= " + builder.getCostRentFrom());
		}
		
		if(StringUtils.isNotBlank(builder.getCostRentTo())) {
			whereClause.append(" AND costrent <= " + builder.getCostRentTo());
		}
		
		if(StringUtils.isNotBlank(builder.getAreaRentFrom()) || StringUtils.isNotBlank(builder.getAreaRentTo())) {
			whereClause.append(" AND EXISTS (SELECT * FROM rentarea ra WHERE (ra.buildingId = A.id");
			if(StringUtils.isNotBlank(builder.getAreaRentFrom())) {
				whereClause.append(" AND ra.value >= '" + builder.getAreaRentFrom() + "'");
			}
			if(StringUtils.isNotBlank(builder.getAreaRentTo())) {
				whereClause.append(" AND ra.value <= '" + builder.getAreaRentTo() + "'");
			}
			whereClause.append(" ))");	
		}
		
		if(builder.getBuildingTypes().length > 0) {
			whereClause.append(" AND (A.type LIKE '%" + builder.getBuildingTypes()[0] + "%'");
			
			//Java7
			/*for(String type : builder.getBuildingTypes()) {
				if(!type.equals(builder.getBuildingTypes()[0])) {
					whereClause.append(" OR A.type LIKE '%" + type + "%'");
				}
			}*/
			Arrays.stream(builder.getBuildingTypes()).filter(item -> !item.equals(builder.getBuildingTypes()[0]))
								.forEach(item -> whereClause.append(" OR A.type LIKE '%" + item + "%'"));
			whereClause.append(" )");	
		}
		
		return findAll(properties, pageble, whereClause.toString());
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
						 if (field.getName().equals("numberOfBasement") || field.getName().equals("buildingArea")) {
							 result.put(field.getName().toLowerCase(), Integer.parseInt((String) field.get(builder)));
						 }
						 else {
							 result.put(field.getName().toLowerCase(), field.get(builder));
						 }
						 
					 }
				}
			}	
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return result ;
	}

}
