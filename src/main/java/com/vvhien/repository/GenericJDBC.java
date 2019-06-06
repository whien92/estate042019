 package com.vvhien.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;
import com.vvhien.paging.Pageble;
public interface GenericJDBC<T> {
	List<T> query(String sql, Object ...parameters);
	Long insert(String sql, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(Object object);
	void update(Object object);
	void delete(Long id);
	BuildingEntity findById(Long id);
	List<BuildingDTO> findBy(Iterator parameterNames);
	
	<T> T findById1(Long id);
	void delete1(Long id); 
	List<T> findAll(Map<String, Object> properties, Pageble pageble, Object... where);
}
