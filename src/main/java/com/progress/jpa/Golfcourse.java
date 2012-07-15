package com.progress.jpa;

// default package
// Generated Jul 13, 2012 12:48:05 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author agoel
 * 
 */
@Entity
@Table(name = "golfcourse")
public class Golfcourse implements java.io.Serializable {
	private Integer golfCourseId;
	private String name;
	private String bannerImageURL;
	private String urlExtension;

	private String homePageShortText;
	private String homePageLongText;
	private String imageURL1;
	private String imageURL2;
	private String imageURL3;
	private String cssName;
	private String latitude;
	private String longitude;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Reservationdetails> reservationdetailses = new HashSet<Reservationdetails>(
			0);
	private Capacity capacity;

	public Golfcourse() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "golfCourseID", unique = true, nullable = false)
	public Integer getGolfCourseId() {
		return this.golfCourseId;
	}

	public void setGolfCourseId(Integer golfCourseId) {
		this.golfCourseId = golfCourseId;
	}

	@Column(name = "urlExtension", length = 50)
	public String getUrlExtension() {
		return urlExtension;
	}

	public void setUrlExtension(String urlExtension) {
		this.urlExtension = urlExtension;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "bannerImageURL", length = 100)
	public String getBannerImageURL() {
		return bannerImageURL;
	}

	public void setBannerImageURL(String bannerImageURL) {
		this.bannerImageURL = bannerImageURL;
	}

	@Column(name = "homePageShortText", length = 100)
	public String getHomePageShortText() {
		return homePageShortText;
	}

	public void setHomePageShortText(String homePageShortText) {
		this.homePageShortText = homePageShortText;
	}

	@Column(name = "homePageLongText", length = 100)
	public String getHomePageLongText() {
		return homePageLongText;
	}

	public void setHomePageLongText(String homePageLongText) {
		this.homePageLongText = homePageLongText;
	}

	@Column(name = "imageURL1", length = 100)
	public String getImageURL1() {
		return imageURL1;
	}

	public void setImageURL1(String imageURL1) {
		this.imageURL1 = imageURL1;
	}

	@Column(name = "imageURL2", length = 100)
	public String getImageURL2() {
		return imageURL2;
	}

	public void setImageURL2(String imageURL2) {
		this.imageURL2 = imageURL2;
	}

	@Column(name = "imageURL3", length = 100)
	public String getImageURL3() {
		return imageURL3;
	}

	public void setImageURL3(String imageURL3) {
		this.imageURL3 = imageURL3;
	}

	@Column(name = "latitude", length = 100)
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", length = 100)
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "cssName", length = 50)
	public String getCssName() {
		return this.cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	@OneToMany(mappedBy = "golfcourse")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(mappedBy = "golfcourse")
	public Set<Reservationdetails> getReservationdetailses() {
		return this.reservationdetailses;
	}

	public void setReservationdetailses(
			Set<Reservationdetails> reservationdetailses) {
		this.reservationdetailses = reservationdetailses;
	}

	@OneToOne(mappedBy = "golfcourse")
	public Capacity getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Capacity capacity) {
		this.capacity = capacity;
	}
}
