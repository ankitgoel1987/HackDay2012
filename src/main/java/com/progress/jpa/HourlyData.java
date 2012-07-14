package com.progress.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hourlydata")
public class HourlyData {

	@Id
	@Column(name = "hourlyDataID", unique = true, nullable = false)
	private String hourlyDataID;
	@Column(name = "weatherCondition", length = 50)
	private String condition;
	@Column(name = "timeRange", length = 50)
	private String timeRange;
	@Column(name = "weatherDate", length = 50)
	private String date;
	@Column(name = "humidity", length = 50)
	private String humidity;
	@Column(name = "iconUrl", length = 100)
	private String iconUrl;
	@Column(name = "temperature", length = 100)
	private String temperature;

	// private Date abc;

	// public Date getAbc() {
	// return abc;
	// }
	//
	// public void setAbc(Date abc) {
	// this.abc = abc;
	// }

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
		hourlyDataID = this.date + this.timeRange;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		hourlyDataID = this.date + this.timeRange;
	}

	public String getHourlyDataID() {
		return hourlyDataID;
	}

	public void setHourlyDataID(String hourlyDataID) {
		this.hourlyDataID = hourlyDataID;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}
