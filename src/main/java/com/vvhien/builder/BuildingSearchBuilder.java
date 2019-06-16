package com.vvhien.builder;

public class BuildingSearchBuilder {
	private String name;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private Integer buildingArea;
	
	public BuildingSearchBuilder (Builder builder) {
		this.name = builder.name;
		this.ward = builder.ward;
		this.street = builder.street;
		this.numberOfBasement = builder.numberOfBasement;
		this.buildingArea = builder.buildingArea;
	}
	
	public String getName() {
		return name;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	
	public static class Builder {
		private String name;
		private String ward;
		private String street;
		private Integer numberOfBasement;
		private Integer buildingArea;
		
		public void setName(String name) {
			this.name = name;
		}
		public void setWard(String ward) {
			this.ward = ward;
		}
		public void setStreet(String street) {
			this.street = street;
		}

		public void setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
		}
		public void setBuildingArea(Integer buildingArea) {
			this.buildingArea = buildingArea;
		}
		
		public BuildingSearchBuilder build () {
			return new BuildingSearchBuilder(this);
		}
	}
	
}
