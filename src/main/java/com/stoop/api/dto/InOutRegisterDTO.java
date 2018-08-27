package com.stoop.api.dto;

public class InOutRegisterDTO {

	public InOutRegisterDTO() {
	}

	private Long id;
	private String inHour;
	private String outHour;
	private String carPlate;
	private String totalHours;
	private String totalToPay;

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

	public String getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}

	public String getTotalToPay() {
		return totalToPay;
	}

	public void setTotalToPay(String totalToPay) {
		this.totalToPay = totalToPay;
	}

	@Override
	public String toString() {
		return "InOutRegisterDTO [id=" + id + ", inHour=" + inHour + ", outHour=" + outHour + ", carPlate=" + carPlate
				+ ", totalHours=" + totalHours + ", totalToPay=" + totalToPay + "]";
	}

}
