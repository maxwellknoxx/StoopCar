package com.stoop.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments_monthly_car")
public class PaymentsMonthlyCar implements Serializable {

	private static final long serialVersionUID = 3010235316297618611L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "car_plate", nullable = false)
	private String carPlate;

	@Column(name = "price_paid", nullable = false)
	private String pricePaid;

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

	public String getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(String pricePaid) {
		this.pricePaid = pricePaid;
	}

	@Override
	public String toString() {
		return "PaymentsMonthlyCar [id=" + id + ", carPlate=" + carPlate + ", pricePaid=" + pricePaid + "]";
	}

}
