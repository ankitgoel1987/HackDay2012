package com.progress.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the Capacity database table.
 * 
 * @author agoel
 */
@Entity
@Table(name = "capacity")
public class Capacity implements Serializable {

	private static final long serialVersionUID = 1L;
	// Original props
	@Id
	@Column(name = "capacityID")
	private int capacityID;
	@Column(name = "teeTime")
	private String teeTime;
	@Column(name = "maxcount")
	private int maxcount;

	// Constructors
	public Capacity() {
	}

	public int getCapacityID() {
		return capacityID;
	}

	public void setCapacityID(int capacityID) {
		this.capacityID = capacityID;
	}

	public String getTeeTime() {
		return teeTime;
	}

	public void setTeeTime(String teeTime) {
		this.teeTime = teeTime;
	}

	public int getMaxcount() {
		return maxcount;
	}

	public void setMaxcount(int maxcount) {
		this.maxcount = maxcount;
	}

}