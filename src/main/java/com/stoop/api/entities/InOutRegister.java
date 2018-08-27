package com.stoop.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "in_out_register")
public class InOutRegister {
	
	public InOutRegister() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "in_hour", nullable = false)
	private String inHour;
	
	@Column(name = "out_hour", nullable = true)
	private String outHour;
	
	@Column(name = "car_plate", nullable = false)
	private String carPlate;
	
	@Column(name = "space_id", nullable = false)
	private Long spaceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInHour() {
		return inHour;
	}

	public void setInHour(String inHour) {
		this.inHour = inHour;
	}

	public String getOutHour() {
		return outHour;
	}

	public void setOutHour(String outHour) {
		this.outHour = outHour;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public Long getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(Long spaceId) {
		this.spaceId = spaceId;
	}

	@Override
	public String toString() {
		return "InOutRegister [id=" + id + ", inHour=" + inHour + ", outHour=" + outHour + ", carPlate=" + carPlate
				+ ", spaceId=" + spaceId + "]";
	}

}
