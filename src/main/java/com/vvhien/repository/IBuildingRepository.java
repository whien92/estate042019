 package com.vvhien.repository;

import java.util.List;
import java.util.Map;

import com.vvhien.builder.BuildingSearchBuilder;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.paging.Pageble;

public interface IBuildingRepository extends GenericJDBC<BuildingEntity>{
	List<BuildingEntity> findAll(BuildingSearchBuilder builder, Pageble pageble);
}
