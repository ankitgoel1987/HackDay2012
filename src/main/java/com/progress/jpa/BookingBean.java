package com.progress.jpa;

import java.util.Calendar;

/**
 * Hold the data about the booking
 * 
 * @author kiranb
 * 
 */
public class BookingBean {
	private Calendar bookingStartDate;
	private int duration = 1;

	private String userName;
	private String confirmID = "32423423423";
	private String toemailAdd;

	public BookingBean() {
	}

	// Minimal Data
	public BookingBean(Calendar bkData, String name, String toEmailAdd, String confirmationID) {
		this.bookingStartDate = bkData;
		this.userName = name;
		this.toemailAdd = toEmailAdd;
		this.confirmID = confirmationID;
	}

	public BookingBean(Calendar bkDate, int duration, String name, String uid) {
		this.bookingStartDate = bkDate;
		this.duration = duration;
		this.userName = name;
		this.confirmID = uid;
	}

	public Calendar getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(Calendar bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConfirmID() {
		return confirmID;
	}

	public void setConfirmID(String confirmID) {
		this.confirmID = confirmID;
	}

	public String getToemailAdd() {
		return toemailAdd;
	}

	public void setToemailAdd(String toemailAdd) {
		this.toemailAdd = toemailAdd;
	}

	public String getBookingMessage() {
		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder.append("<p>Hi " + userName + ",<br><br>");
		msgBuilder.append("Congratulations. Your booking has been confirmed.");
		msgBuilder.append("&nbsp;Please revert with <b>Confirmation ID:" + confirmID + "</b> for future queries.</b>");
		msgBuilder.append("<br><br>-GolfCourse Facilities Team</p>");
		return msgBuilder.toString();
	}
}
