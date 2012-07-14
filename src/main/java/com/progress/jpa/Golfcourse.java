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
	private byte[] bannerImage;
	private String urlExtension;
	private String homePageMenuName;
	private Boolean homePageHtml;
	private byte[] homePageImage;
	private String homePageText;
	private String facilityPageMenuName;
	private Boolean facilityPageHtml;
	private byte[] facilityPageImage;
	private String facilityPageText;
	private String cssName;
	private Boolean contactUsPageHtml;
	private String contactUsPageText;
	private String googleMapUrl;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Reservationdetails> reservationdetailses = new HashSet<Reservationdetails>(0);
	private Capacity capacity;

	public Golfcourse() {
	}

	public Golfcourse(String name, byte[] bannerImage, String urlExtension,
			String homePageMenuName, Boolean homePageHtml,
			byte[] homePageImage, String homePageText,
			String facilityPageMenuName, Boolean facilityPageHtml,
			byte[] facilityPageImage, String facilityPageText, String cssName,
			Boolean contactUsPageHtml, String contactUsPageText,
			String googleMapUrl, Set<Users> userses, Set<Reservationdetails> reservationdetailses,
			Capacity capacity) {
		this.name = name;
		this.bannerImage = bannerImage;
		this.urlExtension = urlExtension;
		this.homePageMenuName = homePageMenuName;
		this.homePageHtml = homePageHtml;
		this.homePageImage = homePageImage;
		this.homePageText = homePageText;
		this.facilityPageMenuName = facilityPageMenuName;
		this.facilityPageHtml = facilityPageHtml;
		this.facilityPageImage = facilityPageImage;
		this.facilityPageText = facilityPageText;
		this.cssName = cssName;
		this.contactUsPageHtml = contactUsPageHtml;
		this.contactUsPageText = contactUsPageText;
		this.googleMapUrl = googleMapUrl;
		this.userses = userses;
		this.reservationdetailses = reservationdetailses;
		this.capacity = capacity;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "bannerImage")
	public byte[] getBannerImage() {
		return this.bannerImage;
	}

	public void setBannerImage(byte[] bannerImage) {
		this.bannerImage = bannerImage;
	}

	@Column(name = "urlExtension", length = 50)
	public String getUrlExtension() {
		return this.urlExtension;
	}

	public void setUrlExtension(String urlExtension) {
		this.urlExtension = urlExtension;
	}

	@Column(name = "homePageMenuName", length = 50)
	public String getHomePageMenuName() {
		return this.homePageMenuName;
	}

	public void setHomePageMenuName(String homePageMenuName) {
		this.homePageMenuName = homePageMenuName;
	}

	@Column(name = "homePageHTML")
	public Boolean getHomePageHtml() {
		return this.homePageHtml;
	}

	public void setHomePageHtml(Boolean homePageHtml) {
		this.homePageHtml = homePageHtml;
	}

	@Column(name = "homePageImage")
	public byte[] getHomePageImage() {
		return this.homePageImage;
	}

	public void setHomePageImage(byte[] homePageImage) {
		this.homePageImage = homePageImage;
	}

	@Column(name = "homePageText", length = 500)
	public String getHomePageText() {
		return this.homePageText;
	}

	public void setHomePageText(String homePageText) {
		this.homePageText = homePageText;
	}

	@Column(name = "facilityPageMenuName", length = 50)
	public String getFacilityPageMenuName() {
		return this.facilityPageMenuName;
	}

	public void setFacilityPageMenuName(String facilityPageMenuName) {
		this.facilityPageMenuName = facilityPageMenuName;
	}

	@Column(name = "facilityPageHTML")
	public Boolean getFacilityPageHtml() {
		return this.facilityPageHtml;
	}

	public void setFacilityPageHtml(Boolean facilityPageHtml) {
		this.facilityPageHtml = facilityPageHtml;
	}

	@Column(name = "facilityPageImage")
	public byte[] getFacilityPageImage() {
		return this.facilityPageImage;
	}

	public void setFacilityPageImage(byte[] facilityPageImage) {
		this.facilityPageImage = facilityPageImage;
	}

	@Column(name = "facilityPageText", length = 500)
	public String getFacilityPageText() {
		return this.facilityPageText;
	}

	public void setFacilityPageText(String facilityPageText) {
		this.facilityPageText = facilityPageText;
	}

	@Column(name = "cssName", length = 50)
	public String getCssName() {
		return this.cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	@Column(name = "contactUsPageHTML")
	public Boolean getContactUsPageHtml() {
		return this.contactUsPageHtml;
	}

	public void setContactUsPageHtml(Boolean contactUsPageHtml) {
		this.contactUsPageHtml = contactUsPageHtml;
	}

	@Column(name = "contactUsPageText", length = 500)
	public String getContactUsPageText() {
		return this.contactUsPageText;
	}

	public void setContactUsPageText(String contactUsPageText) {
		this.contactUsPageText = contactUsPageText;
	}

	@Column(name = "googleMapUrl", length = 50)
	public String getGoogleMapUrl() {
		return this.googleMapUrl;
	}

	public void setGoogleMapUrl(String googleMapUrl) {
		this.googleMapUrl = googleMapUrl;
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

	public void setReservationdetailses(Set<Reservationdetails> reservationdetailses) {
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
