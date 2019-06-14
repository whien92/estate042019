package com.vvhien.entity;

import com.vvhien.annotation.Column;
import com.vvhien.annotation.Entity;
import com.vvhien.annotation.Table;

@Entity
@Table(name = "rentarea")
public class RentArea extends BaseEntity {
	@Column(name = "value")
	private String value;
	
	@Column(name = "buildingid")
	private Long buildingId;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	
	
}
