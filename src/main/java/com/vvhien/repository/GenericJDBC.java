 package com.vvhien.repository;

import java.util.List;

import com.vvhien.dto.BuildingDTO;
import com.vvhien.entity.BuildingEntity;

public interface GenericJDBC<T> {
	List<T> query(String sql, Object ...parameters);
	Long insert(String sql, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(Object object);
	void update(Object object);
	void delete(Long id);
	BuildingEntity findById(Long id);
}
