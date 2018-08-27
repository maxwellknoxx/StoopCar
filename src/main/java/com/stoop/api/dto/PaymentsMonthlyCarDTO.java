package com.stoop.api.dto;

public class PaymentsMonthlyCarDTO {

	public PaymentsMonthlyCarDTO() {
	}

	private Long id;
	private String carPlate;
	private String pricePaid;
	private String startDate;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "PaymentsMonthlyCarDTO [id=" + id + ", carPlate=" + carPlate + ", pricePaid=" + pricePaid
				+ ", startDate=" + startDate + "]";
	}

}
