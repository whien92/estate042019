package com.vvhien.dto;

public class BuildingSearchDTO {
	private String name;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private Integer buildingArea;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}
	
	
}
