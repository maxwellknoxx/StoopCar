package com.stoop.api.dto;

public class MonthlyCarDTO {

	private Long id;
	private String owner;
	private String brand;
	private String model;
	private String carPlate;

	public MonthlyCarDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	@Override
	public String toString() {
		return "MonthlyCarDTO [id=" + id + ", owner=" + owner + ", brand=" + brand + ", model=" + model + ", carPlate="
				+ carPlate + "]";
	}

}
