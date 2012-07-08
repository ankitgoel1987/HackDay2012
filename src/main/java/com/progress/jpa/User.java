package com.progress.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The persistent class for the USERS database table.
 * 
 * @author agoel
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;
	// Original props
	@Id
	@Column(name = "USER_ID")
	private int userId;
	@Id
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "ENABLED")
	private String enabled = "true";
	@Column(name = "PASSWORD")
	private String password;

	// many-to-one association to Authority
	@ManyToOne
	@JoinColumn(name = "AUTHORITY_ID")
	private Authority authority;

	// Constructors
	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Getters and setters for relation property

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	// Spring Security props
	private transient Collection<GrantedAuthority> authorities;

	// UserDetails methods
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isEnabled() {
		return getEnabled().equals("true");
	}

	@Transient
	public void setUserAuthorities(List<String> authorities) {
		List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
		for (String role : authorities) {
			listOfAuthorities.add(new GrantedAuthorityImpl(role));
		}
		this.authorities = (Collection<GrantedAuthority>) listOfAuthorities;
	}

}