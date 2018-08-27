package com.stoop.api.dto;

public class SpacesDTO {

	private Long id;
	private int total;
	private int empty;
	private int busy;

	public SpacesDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getEmpty() {
		return empty;
	}

	public void setEmpty(int empty) {
		this.empty = empty;
	}

	public int getBusy() {
		return busy;
	}

	public void setBusy(int busy) {
		this.busy = busy;
	}

	@Override
	public String toString() {
		return "SpacesDTO [id=" + id + ", total=" + total + ", empty=" + empty + ", busy=" + busy + "]";
	}

}
