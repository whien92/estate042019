package com.vvhien.repository.impl;

import com.vvhien.entity.BuildingEntity;
import com.vvhien.repository.IBuildingRepository;

public class BuildingRepository extends AbstractJDBC<BuildingEntity> implements IBuildingRepository{

	/*@Override
	public Long insert(BuildingEntity buildingEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO building(name, numberofbasement, buildingarea, district, ward, structure, costrent, costdescription, servicecost, ");
		sql.append("carcost, motobikecost, overtimecost, electricitycost, deposit, payment, timerent, timedecorator, managername, managerphone, createddate) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		return this.insert(sql.toString(), 
				buildingEntity.getName(), buildingEntity.getNumberOfBasement(),
				buildingEntity.getBuildingArea(), buildingEntity.getDistrict(),
				buildingEntity.getWard(), buildingEntity.getStructure(),
				buildingEntity.getCostRent(), buildingEntity.getCostDescription(),
				buildingEntity.getServiceCost(), buildingEntity.getCarCost(),
				buildingEntity.getMotobikeCost(), buildingEntity.getOverTimeCost(),
				buildingEntity.getElectricityCost(), buildingEntity.getDeposit(),
				buildingEntity.getPayment(), buildingEntity.getTimeRent(),
				buildingEntity.getTimeDecorator(), buildingEntity.getManagerName(),
				buildingEntity.getManagerPhone(), buildingEntity.getCreatedDate());
	}*/

}
