package com.progress.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * The persistent class for the AUTHORITIES database table.
 * 
 */
@Entity
@Table(name = "AUTHORITIES")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "AUTHORITY_ID")
	private int authority_id;

	@Column(name = "AUTHORITY")
	private String authorityName; // Spring Security demands them to start with
									// "ROLE_"

	// Bi-directional one-to-many association to User
	@OneToMany(mappedBy = "authority")
	private Set<User> user;

	// Getters & Setters for original props
	public int getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}

	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authority) {
		this.authorityName = authority;
	}

	// Getters and setters for relation property
	public Set<User> getUsers() {
		return this.user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	// Constructors
	public Authority(int id) {
		this.authority_id = id;
	}

	public Authority() {
	}
}