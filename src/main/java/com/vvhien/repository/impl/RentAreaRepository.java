package com.vvhien.repository.impl;

import com.vvhien.entity.RentArea;
import com.vvhien.repository.IRentAreaRepository;

public class RentAreaRepository extends AbstractJDBC<RentArea> implements IRentAreaRepository{

	@Override
	public void deleteByBuilding(Long id) {
		String where = "WHERE buildingId = " + id + "";
		this.deleteByproperty(where); 
	}

}
