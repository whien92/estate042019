package com.vvhien.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO>{
	private String name;
	private String ward;
	private String street;
	private String structure;
	private String numberOfBasement;
	private String buildingArea;
	private String district;
	private Integer costRent;
	private String costDescription;
	private String serviceCost;
	private String carCost;
	private String motobikeCost;
	private String overTimeCost;
	private String electricityCost;
	private String deposit;
	private String payment;
	private String timeRent;
	private String timeDecorator;
	private String managerName;
	private String managerPhone;
	private String type;
	private String[] buildingTypes = new String[]{};
	private String costRentFrom;
	private String costRentTo;
	private String areaRentFrom;
	private String areaRentTo;
	private String direction;
	private String level;
	private String address;
	private String rentArea;
	
	
	
	
	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}

	public String getAddress() {
		return this.street + ", " + this.ward + ", " + this.district;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCostRentFrom() {
		return costRentFrom;
	}

	public void setCostRentFrom(String costRentFrom) {
		this.costRentFrom = costRentFrom;
	}

	public String getCostRentTo() {
		return costRentTo;
	}

	public void setCostRentTo(String costRentTo) {
		this.costRentTo = costRentTo;
	}

	public String getAreaRentFrom() {
		return areaRentFrom;
	}

	public void setAreaRentFrom(String areaRentFrom) {
		this.areaRentFrom = areaRentFrom;
	}

	public String getAreaRentTo() {
		return areaRentTo;
	}

	public void setAreaRentTo(String areaRentTo) {
		this.areaRentTo = areaRentTo;
	}

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

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(String numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(String buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getCostRent() {
		return costRent;
	}

	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}

	public String getCostDescription() {
		return costDescription;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}

	public String getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getCarCost() {
		return carCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public String getMotobikeCost() {
		return motobikeCost;
	}

	public void setMotobikeCost(String motobikeCost) {
		this.motobikeCost = motobikeCost;
	}

	public String getOverTimeCost() {
		return overTimeCost;
	}

	public void setOverTimeCost(String overTimeCost) {
		this.overTimeCost = overTimeCost;
	}

	public String getElectricityCost() {
		return electricityCost;
	}

	public void setElectricityCost(String electricityCost) {
		this.electricityCost = electricityCost;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTimeRent() {
		return timeRent;
	}

	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}

	public String getTimeDecorator() {
		return timeDecorator;
	}

	public void setTimeDecorator(String timeDecorator) {
		this.timeDecorator = timeDecorator;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}

	@Override
	public String toString() {
		return 	this.getId() + "\t" + this.getName() + "\t" + 
				this.getBuildingArea() + "\t"  + this.getWard() + "\t"  + 
				this.getStreet();
	}
	
	
}
