package com.progress.jpa;
// default package
// Generated Jul 13, 2012 12:48:05 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
* @author agoel
 */
@Entity
@Table(name = "capacity")
public class Capacity implements java.io.Serializable {

	private Integer capacityId;
	private Golfcourse golfcourse;
	private Integer golfCourseId;
	private String teetime;
	private Integer maxcount;

	public Capacity() {
	}

	public Capacity(Golfcourse golfcourse) {
		this.golfcourse = golfcourse;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "golfcourse"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "capacityID", unique = true, nullable = false)
	public Integer getCapacityId() {
		return this.capacityId;
	}

	public void setCapacityId(Integer capacityId) {
		this.capacityId = capacityId;
	}

	@OneToOne()
	@PrimaryKeyJoinColumn
	public Golfcourse getGolfcourse() {
		return this.golfcourse;
	}

	public void setGolfcourse(Golfcourse golfcourse) {
		this.golfcourse = golfcourse;
	}

	@Column(name = "golfCourseID")
	public Integer getGolfCourseId() {
		return this.golfCourseId;
	}

	public void setGolfCourseId(Integer golfCourseId) {
		this.golfCourseId = golfCourseId;
	}

	@Column(name = "teetime", length = 50)
	public String getTeetime() {
		return teetime;
	}

	public void setTeetime(String teetime) {
		this.teetime = teetime;
	}

	@Column(name = "maxcount")
	public Integer getMaxcount() {
		return this.maxcount;
	}

	public void setMaxcount(Integer maxcount) {
		this.maxcount = maxcount;
	}

}
