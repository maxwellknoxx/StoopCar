package com.stoop.api.dto;

public class SeparatedCarDTO {

	private Long id;
	private String carPlate;

	public SeparatedCarDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	@Override
	public String toString() {
		return "SeparatedCarDTO [id=" + id + ", carPlate=" + carPlate + "]";
	}

}
