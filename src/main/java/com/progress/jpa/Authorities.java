package com.progress.jpa;

// default package
// Generated Jul 13, 2012 12:48:05 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author agoel
 */
@Entity
@Table(name = "authorities")
public class Authorities implements java.io.Serializable {

	private Integer authorityId;
	private String authority;
	private Set<Users> userses = new HashSet(0);

	public Authorities() {
	}

	public Authorities(String authority, Set userses) {
		this.authority = authority;
		this.userses = userses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "authorityID", unique = true, nullable = false)
	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	@Column(name = "authority", length = 50)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "authority")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
