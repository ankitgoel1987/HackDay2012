package com.progress.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the UserDetails database table.
 * 
 * @author agoel
 */
@Entity
@Table(name = "userDetails")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	// Original props
	@Id
	@Column(name = "userID")
	private int userID;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email = "true";
	@Column(name = "phoneNumber")
	private String phoneNumber;

	// TODO: Ankit - Add mapping to user table
	// many-to-one association to Authority
	// @ManyToOne
	// @JoinColumn(name = "AUTHORITY_ID")
	// private Authority authority;

	public UserDetails() {
	}

	public int getUserId() {
		return this.userID;
	}

	public void setUserId(int userId) {
		this.userID = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}