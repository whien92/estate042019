package com.vvhien.builder;

public class BuildingSearchBuilder {
	private String name;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String[] buildingTypes = new String[] {};
	private Integer costRentFrom;
	private Integer costRentTo;
	private Integer areaRentFrom;
	private Integer areaRentTo;

	public BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.ward = builder.ward;
		this.street = builder.street;
		this.numberOfBasement = builder.numberOfBasement;
		this.costRentFrom = builder.costRentFrom;
		this.costRentTo = builder.costRentTo;
		this.areaRentFrom = builder.areaRentFrom;
		this.areaRentTo = builder.areaRentTo;
		this.buildingTypes = builder.buildingTypes;
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

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public Integer getCostRentFrom() {
		return costRentFrom;
	}

	public Integer getCostRentTo() {
		return costRentTo;
	}

	public Integer getAreaRentFrom() {
		return areaRentFrom;
	}

	public Integer getAreaRentTo() {
		return areaRentTo;
	}

	public static class Builder {
		private String name;
		private String ward;
		private String street;
		private Integer numberOfBasement;
		private String[] buildingTypes = new String[] {};
		private Integer costRentFrom;
		private Integer costRentTo;
		private Integer areaRentFrom;
		private Integer areaRentTo;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setBuildingTypes(String[] buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}

		public Builder setCostRentFrom(Integer costRentFrom) {
			this.costRentFrom = costRentFrom;
			return this;
		}

		public Builder setCostRentTo(Integer costRentTo) {
			this.costRentTo = costRentTo;
			return this;
		}

		public Builder setAreaRentFrom(Integer areaRentFrom) {
			this.areaRentFrom = areaRentFrom;
			return this;
		}

		public Builder setAreaRentTo(Integer areaRentTo) {
			this.areaRentTo = areaRentTo;
			return this;
		}

		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}

}
