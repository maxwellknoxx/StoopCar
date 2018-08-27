package com.stoop.api.dto;

public class PaymentsSeparatedCarDTO {

	public PaymentsSeparatedCarDTO() {
	}

	private Long id;
	private String carPlate;
	private String totalHour;
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

	public String getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(String totalHour) {
		this.totalHour = totalHour;
	}

	public String getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(String pricePaid) {
		this.pricePaid = pricePaid;
	}

	@Override
	public String toString() {
		return "PaymentsSeparatedCar [id=" + id + ", carPlate=" + carPlate + ", totalHour=" + totalHour + ", pricePaid="
				+ pricePaid + "]";
	}

}
