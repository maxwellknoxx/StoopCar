package com.stoop.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "separated_car")
public class SeparatedCar {
	
	public SeparatedCar() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "car_plate", nullable = false)
	private String carPlate;

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
		return "SeparatedCar [id=" + id + ", carPlate=" + carPlate + "]";
	}
	
}
