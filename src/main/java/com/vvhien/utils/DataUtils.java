package com.vvhien.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.vvhien.enums.BuildingTypeEnum;
import com.vvhien.enums.DistrictEnum;

public class DataUtils {
	public static Map<String, String> getDistricts() {
		Map<String, String> results = new HashMap<>();
		Stream.of(DistrictEnum.values()).forEach(item -> {
			results.put(item.name(), item.getValue());
		});	
		return results;
	}
	
	public static Map<String, String> getBuildingTypes() {
		Map<String, String> results = new HashMap<>();
		Stream.of(BuildingTypeEnum.values()).forEach(item -> {
			results.put(item.name(), item.getValue());
		});	
		return results;
	}
}
