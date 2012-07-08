package com.progress.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the ReservationDetails database table.
 * 
 * @author agoel
 */
@Entity
@Table(name = "reservationDetails")
public class ReservationDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	// Original props
	@Id
	@Column(name = "confirmationNumber")
	private int confirmationNumber;
	@Column(name = "teeTime")
	private String teeTime;
	@Column(name = "noOfGolfers")
	private int noOfGolfers;
	@Column(name = "reminderRequired")
	private boolean reminderRequired;
	@Column(name = "userID")
	private String userID;

	// TODO: Ankit - Add mapping to user table
	// many-to-one association to Authority
	// @ManyToOne
	// @JoinColumn(name = "AUTHORITY_ID")
	// private Authority authority;

	// Constructors
	public ReservationDetails() {
	}

	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getTeeTime() {
		return teeTime;
	}

	public void setTeeTime(String teeTime) {
		this.teeTime = teeTime;
	}

	public int getNoOfGolfers() {
		return noOfGolfers;
	}

	public void setNoOfGolfers(int noOfGolfers) {
		this.noOfGolfers = noOfGolfers;
	}

	public boolean isReminderRequired() {
		return reminderRequired;
	}

	public void setReminderRequired(boolean reminderRequired) {
		this.reminderRequired = reminderRequired;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}