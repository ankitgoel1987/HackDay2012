package com.progress.jpa;

// default package
// Generated Jul 13, 2012 12:48:05 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author agoel
 *
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userID", unique = true, nullable = false)
	private Integer userId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "golfCourseID")
	private Golfcourse golfcourse;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorityID")
	private Authorities authority;
	@Column(name = "username", length = 50)
	private String username;
	@Column(name = "password", length = 100)
	private String password;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "phoneNumber", length = 50)
	private String phoneNumber;
	@Column(name = "enabled", length = 50)
	private String enabled;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Reservationdetails> reservationdetailses = new HashSet(0);

	public Users() {
	}

	public Users(Golfcourse golfcourse, Authorities authority,
			String userName, String password, String name, String email,
			String phoneNumber, String enabled, Set reservationdetailses) {
		this.golfcourse = golfcourse;
		this.authority = authority;
		this.username = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.reservationdetailses = reservationdetailses;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Golfcourse getGolfcourse() {
		return this.golfcourse;
	}

	public void setGolfcourse(Golfcourse golfcourse) {
		this.golfcourse = golfcourse;
	}

	public Authorities getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authorities authorities) {
		this.authority = authorities;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEnabled() {
		return this.enabled;

	}

	public String setEnabled(String enabled) {
		return this.enabled = enabled;
	}

	public Set<Reservationdetails> getReservationdetailses() {
		return this.reservationdetailses;
	}

	public void setReservationdetailses(
			Set<Reservationdetails> reservationdetailses) {
		this.reservationdetailses = reservationdetailses;
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
		return true;
	}

	@Transient
	public void setUserAuthorities(List<String> authorities) {
		List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
		for (String role : authorities) {
			listOfAuthorities.add(new GrantedAuthorityImpl(role));
		}
		this.authorities = (Collection<GrantedAuthority>) listOfAuthorities;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
