package com.stoop.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "monthly_car")
public class MonthlyCar {

	public MonthlyCar() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "owner", nullable = false)
	private String owner;

	@Column(name = "brand", nullable = false)
	private String brand;

	@Column(name = "model", nullable = false)
	private String model;

	@Column(name = "car_plate", nullable = false)
	private String carPlate;

	@Column(name = "insert_date", nullable = true)
	private Date insertDate;

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

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	@PrePersist
    public void prePersist() {
        final Date atual = new Date();
        insertDate = atual;
    }

	@Override
	public String toString() {
		return "MonthlyCar [id=" + id + ", owner=" + owner + ", brand=" + brand + ", model=" + model + ", carPlate="
				+ carPlate + ", insertDate=" + insertDate + "]";
	}

}
