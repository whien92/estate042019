package com.vvhien.repository;

import com.vvhien.entity.RentArea;

public interface IRentAreaRepository extends GenericJDBC<RentArea>{
	void deleteByBuilding(long id);
}
