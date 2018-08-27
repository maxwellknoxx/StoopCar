package com.stoop.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "spaces")
public class Spaces {
	
	public Spaces() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "total", nullable = true)
	private int total;

	@Column(name = "busy", nullable = false)
	private int busy;

	@Column(name = "empty", nullable = false)
	private int empty;

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

	public int getBusy() {
		return busy;
	}

	public void setBusy(int busy) {
		this.busy = busy;
	}

	public int getEmpty() {
		return empty;
	}

	public void setEmpty(int empty) {
		this.empty = empty;
	}

	@Override
	public String toString() {
		return "Spaces [id=" + id + ", total=" + total + ", busy=" + busy + ", empty=" + empty + "]";
	}

}
