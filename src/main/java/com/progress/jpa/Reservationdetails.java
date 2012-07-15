package com.progress.jpa;

// default package
// Generated Jul 13, 2012 12:48:05 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author agoel
 * 
 */
@Entity
@Table(name = "reservationdetails")
public class Reservationdetails implements java.io.Serializable {

	private Integer confirmationNumber;
	private Golfcourse golfcourse;
	private Users users;
	private Date bookingDateTime;
	private Integer noOfGolfers;
	private Boolean reminderRequired;
	private Integer status = 1;
	private String timeRange;
	private String date;

	public Reservationdetails() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "confirmationNumber", unique = true, nullable = false)
	public Integer getConfirmationNumber() {
		return this.confirmationNumber;
	}

	@Column(name = "timeRange", length = 50)
	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

	@Column(name = "gameDate", length = 50)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setConfirmationNumber(Integer confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	@ManyToOne()
	@JoinColumn(name = "golfCourseID")
	public Golfcourse getGolfcourse() {
		return this.golfcourse;
	}

	public void setGolfcourse(Golfcourse golfcourse) {
		this.golfcourse = golfcourse;
	}

	@ManyToOne()
	@JoinColumn(name = "userID")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bookingDateTime", length = 19)
	public Date getBookingDateTime() {
		return this.bookingDateTime;
	}

	public void setBookingDateTime(Date bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	@Column(name = "noOfGolfers")
	public Integer getNoOfGolfers() {
		return this.noOfGolfers;
	}

	public void setNoOfGolfers(Integer noOfGolfers) {
		this.noOfGolfers = noOfGolfers;
	}

	@Column(name = "reminderRequired")
	public Boolean getReminderRequired() {
		return this.reminderRequired;
	}

	public void setReminderRequired(Boolean reminderRequired) {
		this.reminderRequired = reminderRequired;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
